package create.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import config.EntityConfig;
import config.FileConfig;
import entities.Person;
import read.file.FileReader;
import store.data.StoreData;

/**
 * Tạo ngẫu nhiên các thực thể Person và lưu chúng vào cơ sở dữ liệu
 * 
 * @author Viet Hung
 *
 */
public class PersonCreator {
	// Mảng lưu trữ tên, mô tả, công việc, ngày tháng trích rút link của đối tượng người
	private ArrayList<String> listPersonName;
	private ArrayList<String> listPersonDescription;
	private ArrayList<String> listPersonJob;
	private ArrayList<String> listPersonDate;
	
	// Đối tượng định dạng ngày tháng
	private DateTimeFormatter dtf;
	
	// Lưu trữ các triple để chuẩn bị lưu vào cơ sở dữ liệu
	Model model;
	
	/**
	 * Constructor: khi tạo mới một đối tượng PersonCreator thì cũng đọc file
	 * tương ứng với đối tượng Person và cập nhật vào các mảng tương ứng.
	 */
	public PersonCreator() {
		FileReader fileReader = new FileReader();
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		model = new TreeModel();
		
		listPersonName = fileReader.readData(FileConfig.FILE_PERSON_NAME);
		listPersonDescription = fileReader.readData(FileConfig.FILE_PERON_DESCRIPTION);
		listPersonJob = fileReader.readData(FileConfig.FILE_PERSON_JOB);
		listPersonDate = fileReader.readData(FileConfig.FILE_PERSON_DATE);
		
	}
	
	/**
	 * Tạo ngẫu nhiên một đối tượng Person với các dữ liệu đọc được từ file.
	 * 
	 * @param personId: số Identifier của đối tượng Person.
	 * @return đối tượng Person vừa tạo.
	 */
	public Person randomPerson(int personId) {
		Random random = new Random();
		int randomRange = listPersonName.size() - 1;
		
		// Random số trong đoạn [0, randoRange]
		int index = random.nextInt(randomRange);
		
		String id = EntityConfig.PERSON_ID + Integer.toString(personId);
		String name = listPersonName.get(index);
		String description = listPersonDescription.get(index);
		String link = EntityConfig.PERSON_LINK + id;
		LocalDate date = LocalDate.parse(listPersonDate.get(index), dtf);
		String job = listPersonJob.get(index);

		Person person = new Person(id, name, description, link, date, job);
		return person;
	}

	/**
	 * Tạo ra một số lượng Person và thêm vào GraphDB
	 * 
	 * @param numberPerson: Số lượng Person muốn tạo
	 * @param conn: kết nối đến repository của GraphDB.
	 * @return : list các IRI Id của Person đã thêm vào GraphDB
	 */
	public ArrayList<IRI> createPerson(int numberPerson, RepositoryConnection conn) {
		ValueFactory vf = conn.getValueFactory();
		StoreData storeData = new StoreData();
		ArrayList<IRI> listPersonIri = new ArrayList<IRI>();
		int count = 1;
		for (int i = 1; i <= numberPerson; i++) {
			Person person = randomPerson(i);
			
			IRI personIri = storeData.addToModel(person, vf, model);
			listPersonIri.add(personIri);
			
			if (i % 10000 == 0) {
				try {
					storeData.addToDB(model, conn);
					model.clear();
					System.out.println("Đã thêm 1000 Person lần " + count);
					count++;

				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}

		// Lưu model vào cơ sở dữ liệu
		try {
			conn.add(model);
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("Đã thêm vào cơ sở dữ liệu");

		return listPersonIri;
	}
}
