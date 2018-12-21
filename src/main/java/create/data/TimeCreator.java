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
import entities.Time;
import read.file.FileReader;
import store.data.StoreData;

/**
 * Tạo ngẫu nhiên các thực thể Time và lưu vào database.
 * 
 * @author Viet Hung
 *
 */
public class TimeCreator {
	// Mảng lưu trữ tên hiển thị, mô tả, ngày tháng trích rút link của thực thể thời gian
	private ArrayList<String> listTimeLabel;
	private ArrayList<String> listTimeDescription;
	private ArrayList<String> listTimeDate;

	// Đối tượng định dạng ngày tháng
	private DateTimeFormatter dtf;

	// Lưu trữ các triple để chuẩn bị lưu vào cơ sở dữ liệu
	Model model;

	/**
	 * Constructor: khi tạo mới một đối tượng Time thì cũng đọc file tương
	 * ứng với đối tượng Time và cập nhật vào các mảng tương ứng.
	 */
	public TimeCreator() {
		FileReader fileReader = new FileReader();
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		model = new TreeModel();

		listTimeLabel = fileReader.readData(FileConfig.FILE_TIME_LABEL);
		listTimeDescription = fileReader.readData(FileConfig.FILE_TIME_DESCRIPTION);
		listTimeDate = fileReader.readData(FileConfig.FILE_TIME_DATE);
	}

	/**
	 * Tạo ngẫu nhiên một đối tượng Time với các dữ liệu đọc được từ file.
	 * 
	 * @param timeId
	 *            số Identifier của đối tượng Time.
	 * @return đối tượng Time vừa tạo.
	 */
	public Time randomTime(int timeId) {
		Random random = new Random();
		int randomRange = listTimeLabel.size() - 1;

		// Random số trong đoạn [0, randoRange]
		int index = random.nextInt(randomRange);

		String id = EntityConfig.TIME_ID + Integer.toString(timeId);
		String name = listTimeLabel.get(index);
		String description = listTimeDescription.get(index);
		String link = EntityConfig.TIME_LINK + id;
		LocalDate date = LocalDate.parse(listTimeDate.get(index), dtf);

		Time time = new Time(id, name, description, link, date);
		return time;
	}

	/**
	 * Tạo ra một số lượng Time và thêm vào database.
	 * 
	 * @param numberTime
	 *            Số lượng Time muốn tạo.
	 * @param conn:
	 *            kết nối đến repository của GraphDB.
	 * @return : list các IRI Id của Time đã thêm vào Database.
	 */
	public ArrayList<IRI> createTime(int numberTime, RepositoryConnection conn) {
		ValueFactory vf = conn.getValueFactory();
		StoreData storeData = new StoreData();
		ArrayList<IRI> listTimeIri = new ArrayList<IRI>();
		int count = 1;

		for (int i = 1; i <= numberTime; i++) {
			Time time = randomTime(i);

			IRI timeIri = storeData.addToModel(time, vf, model);
			listTimeIri.add(timeIri);

			if (i % 10000 == 0) {
				try {
					storeData.addToDB(model, conn);
					model.clear();
					System.out.println("Đã thêm 10000 Time lần " + count);
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

		return listTimeIri;
	}
}
