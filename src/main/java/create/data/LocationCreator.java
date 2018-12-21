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
import entities.Location;
import read.file.FileReader;
import store.data.StoreData;

/**
 * Tạo ngẫu nhiên các thực thể Location và lưu chúng vào Database
 * 
 * @author Viet Hung
 *
 */
public class LocationCreator {
	// Mảng lưu trữ tên, mô tả, ngày tháng trích rút link, tên nước mà địa điểm đó thuộc về
	private ArrayList<String> listLocationName;
	private ArrayList<String> listLocationDescription;
	private ArrayList<String> listLocationDate;
	private ArrayList<String> listLocationCountry;

	// Đối tượng định dạng ngày tháng
	private DateTimeFormatter dtf;

	// Lưu trữ các triple để chuẩn bị lưu vào cơ sở dữ liệu
	Model model;

	/**
	 * Constructor: khi tạo mới một đối tượng LocationCreator thì cũng đọc file tương
	 * ứng với đối tượng Event và cập nhật vào các mảng tương ứng.
	 */
	public LocationCreator() {
		FileReader fileReader = new FileReader();
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		model = new TreeModel();

		listLocationName = fileReader.readData(FileConfig.FILE_LOCATION_NAME);
		listLocationDescription = fileReader.readData(FileConfig.FILE_LOCATION_DESCRIPTION);
		listLocationDate = fileReader.readData(FileConfig.FILE_LOCATION_DATE);
		listLocationCountry = fileReader.readData(FileConfig.FILE_LOCATION_COUNTRY);
	}

	/**
	 * Tạo ngẫu nhiên một đối tượng Location với các dữ liệu đọc được từ file.
	 * 
	 * @param locationId
	 *            số Identifier của đối tượng Location.
	 * @return đối tượng Location vừa tạo.
	 */
	public Location randomLocation(int locationId) {
		Random random = new Random();
		int randomRange = listLocationName.size() - 1;

		// Random số trong đoạn [0, randoRange]
		int index = random.nextInt(randomRange);

		String id = EntityConfig.LOCATION_ID + Integer.toString(locationId);
		String name = listLocationName.get(index);
		String description = listLocationDescription.get(index);
		String link = EntityConfig.LOCATION_LINK + id;
		LocalDate date = LocalDate.parse(listLocationDate.get(index), dtf);
		String country = listLocationCountry.get(index);

		Location location = new Location(id, name, description, link, date, country);
		return location;
	}

	/**
	 * Tạo ra một số lượng Location và thêm vào Database.
	 * 
	 * @param numberLocation
	 *            Số lượng Location muốn tạo.
	 * @param conn:
	 *            kết nối đến repository của Database.
	 * @return : list các IRI Id của Location đã thêm vào Database.
	 */
	public ArrayList<IRI> createEvent(int numberLocation, RepositoryConnection conn) {
		ValueFactory vf = conn.getValueFactory();
		StoreData storeData = new StoreData();
		ArrayList<IRI> listLocationIri = new ArrayList<IRI>();
		int count = 1;

		for (int i = 1; i <= numberLocation; i++) {
			Location location = randomLocation(i);

			IRI locationIri = storeData.addToModel(location, vf, model);
			listLocationIri.add(locationIri);

			if (i % 10000 == 0) {
				try {
					storeData.addToDB(model, conn);
					model.clear();
					System.out.println("Đã thêm 10000 Location lần " + count);
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

		return listLocationIri;
	}
}
