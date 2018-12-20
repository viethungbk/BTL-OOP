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
import entities.Event;
import read.file.FileReader;
import store.data.StoreData;

/**
 * Tạo ngẫu nhiên các thực thể Event và lưu chúng vào GraphDB.
 * 
 * @author Viet Hung
 *
 */
public class EventCreator {
	// Mảng lưu trữ tên, mô tả, ngày tháng trích rút link của đối tượng Event
	private ArrayList<String> listEventName;
	private ArrayList<String> listEventDescription;
	private ArrayList<String> listEventDate;

	// Đối tượng định dạng ngày tháng
	private DateTimeFormatter dtf;

	// Lưu trữ các triple để chuẩn bị lưu vào cơ sở dữ liệu
	Model model;

	/**
	 * Constructor: khi tạo mới một đối tượng EventCreator thì cũng đọc file tương
	 * ứng với đối tượng Event và cập nhật vào các mảng tương ứng.
	 */
	public EventCreator() {
		FileReader fileReader = new FileReader();
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		model = new TreeModel();

		listEventName = fileReader.readData(FileConfig.FILE_EVENT_NAME);
		listEventDescription = fileReader.readData(FileConfig.FILE_EVENT_DESCRIPTION);
		listEventDate = fileReader.readData(FileConfig.FILE_EVENT_DATE);

	}

	/**
	 * Tạo ngẫu nhiên một đối tượng Event với các dữ liệu đọc được từ file.
	 * 
	 * @param eventId
	 *            số Identifier của đối tượng Event.
	 * @return đối tượng Event vừa tạo.
	 */
	public Event randomEvent(int eventId) {
		Random random = new Random();
		int randomRange = listEventName.size() - 1;

		// Random số trong đoạn [0, randoRange]
		int index = random.nextInt(randomRange);

		String id = EntityConfig.EVENT_ID + Integer.toString(eventId);
		String name = listEventName.get(index);
		String description = listEventDescription.get(index);
		String link = EntityConfig.PERSON_LINK + id;
		LocalDate date = LocalDate.parse(listEventDate.get(index), dtf);

		Event event = new Event(id, name, description, link, date);
		return event;
	}

	/**
	 * Tạo ra một số lượng Event và thêm vào GraphDB
	 * 
	 * @param numberEvent
	 *            Số lượng Event muốn tạo.
	 * @param conn:
	 *            kết nối đến repository của GraphDB.
	 * @return : list các IRI Id của Person đã thêm vào GraphDB
	 */
	public ArrayList<IRI> createEvent(int numberEvent, RepositoryConnection conn) {
		ValueFactory vf = conn.getValueFactory();
		StoreData storeData = new StoreData();
		ArrayList<IRI> listEventIri = new ArrayList<IRI>();
		int count = 1;
		
		for (int i = 1; i <= numberEvent; i++) {
			Event event = randomEvent(i);

			IRI eventIri = storeData.addToModel(event, vf, model);
			listEventIri.add(eventIri);

			if (i % 10000 == 0) {
				try {
					storeData.addToDB(model, conn);
					model.clear();
					System.out.println("Đã thêm 10000 Event lần " + count);
					count++;

				} catch (Exception e) {
					e.getMessage();
				}
			}

		}

		// Lưu model vào cơ sở dữ liệu
		try {
			conn.add(model);
		} catch (Exception e) {
			e.getMessage();
		}

		System.out.println("Đã thêm vào cơ sở dữ liệu");

		return listEventIri;
	}
}
