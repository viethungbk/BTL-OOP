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
import entities.Country;
import read.file.FileReader;
import store.data.StoreData;

/**
 * Tạo ngẫu nhiên các thực thể Country và lưu chúng vào cơ sở dữ liệu
 * 
 * @author Viet Hung
 *
 */
public class CountryCreator {
	// Mảng lưu trữ tên, mô tả, ngày tháng trích rút link của đối tượng Country
	private ArrayList<String> listCountry;
	private ArrayList<String> listCountryDescription;
	private ArrayList<String> listCountryDate;
	
	// Đối tượng định dạng ngày tháng
	private DateTimeFormatter dtf;

	// Lưu trữ các triple để chuẩn bị lưu vào cơ sở dữ liệu
	Model model;

	/**
	 * Constructor: khi tạo mới một đối tượng PersonCreator thì cũng đọc file tương
	 * ứng với đối tượng Person và cập nhật vào các mảng tương ứng.
	 */
	public CountryCreator() {
		FileReader fileReader = new FileReader();
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		model = new TreeModel();
		
		listCountry = fileReader.readData(FileConfig.FILE_COUNTRY_NAME);
		listCountryDescription = fileReader.readData(FileConfig.FILE_COUNTRY_DESCRIPTION);
		listCountryDate = fileReader.readData(FileConfig.FILE_COUNTRY_DATE);
		
	}

	/**
	 * Tạo ngẫu nhiên một đối tượng Country với các dữ liệu đọc được từ file.
	 * 
	 * @param countryId:
	 *            số Identifier của đối tượng Country.
	 * @return đối tượng Country vừa tạo.
	 */
	public Country randomCountry(int countryId) {
		Random random = new Random();
		int randomRange = listCountry.size() - 1;

		// Random số trong đoạn [0, randoRange]
		int index = random.nextInt(randomRange);

		String id = EntityConfig.COUNTRY_ID + Integer.toString(countryId);
		String name = listCountry.get(index);
		String description = listCountryDescription.get(index);
		String link = EntityConfig.PERSON_LINK + id;
		LocalDate date = LocalDate.parse(listCountryDate.get(index), dtf);

		Country country = new Country(id, name, description, link, date);
		return country;
	}

	/**
	 * Tạo ra một số lượng Country và thêm vào GraphDB
	 * 
	 * @param numberCountry:
	 *            Số lượng Country muốn tạo
	 * @param conn:
	 *            kết nối đến repository của GraphDB.
	 * @return : list các IRI Id của Country đã thêm vào GraphDB
	 */
	public ArrayList<IRI> createCountry(int numberCountry, RepositoryConnection conn) {
		ValueFactory vf = conn.getValueFactory();
		StoreData storeData = new StoreData();
		ArrayList<IRI> listCountryIri = new ArrayList<IRI>();
		int count = 1;
		for (int i = 1; i <= numberCountry; i++) {
			Country country = randomCountry(i);

			IRI countryIri = storeData.addToModel(country, vf, model);
			listCountryIri.add(countryIri);

			if (i % 10000 == 0) {
				try {
					storeData.addToDB(model, conn);
					model.clear();
					System.out.println("Đã thêm 10000 Country lần " + count);
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

		return listCountryIri;
	}
}
