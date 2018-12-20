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
import entities.Organization;
import read.file.FileReader;
import store.data.StoreData;

/**
 * Tạo ngẫu nhiên các thực thể Organization và lưu vào database.
 * 
 * @author Viet Hung
 *
 */
public class OrganizationCreator {
	// Mảng lưu trữ tên, mô tả, ngày tháng trích rút link, trụ sở của tổ chức
	private ArrayList<String> listOrganizationName;
	private ArrayList<String> listOrganizationDescription;
	private ArrayList<String> listOrganizationDate;
	private ArrayList<String> listOrganizationHeadquarter;

	// Đối tượng định dạng ngày tháng
	private DateTimeFormatter dtf;

	// Lưu trữ các triple để chuẩn bị lưu vào cơ sở dữ liệu
	Model model;

	/**
	 * Constructor: khi tạo mới một đối tượng OrganizationCreator thì cũng đọc file tương
	 * ứng với đối tượng Event và cập nhật vào các mảng tương ứng.
	 */
	public OrganizationCreator() {
		FileReader fileReader = new FileReader();
		dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		model = new TreeModel();

		listOrganizationName = fileReader.readData(FileConfig.FILE_ORGANIZATION_NAME);
		listOrganizationDescription = fileReader.readData(FileConfig.FILE_ORGANIZATION_DESCRIPTION);
		listOrganizationDate = fileReader.readData(FileConfig.FILE_ORGANIZATION_DATE);
		listOrganizationHeadquarter = fileReader.readData(FileConfig.FILE_ORGANIZATION_HEADQUARTER);
	}

	/**
	 * Tạo ngẫu nhiên một đối tượng Organzation với các dữ liệu đọc được từ file.
	 * 
	 * @param organizationId
	 *            số Identifier của đối tượng Location.
	 * @return đối tượng Organzation vừa tạo.
	 */
	public Organization randomOrganzation(int organizationId) {
		Random random = new Random();
		int randomRange = listOrganizationName.size() - 1;

		// Random số trong đoạn [0, randoRange]
		int index = random.nextInt(randomRange);

		String id = EntityConfig.ORGANIZATION_ID + Integer.toString(organizationId);
		String name = listOrganizationName.get(index);
		String description = listOrganizationDescription.get(index);
		String link = EntityConfig.LOCATION_LINK + id;
		LocalDate date = LocalDate.parse(listOrganizationDate.get(index), dtf);
		String headquarter = listOrganizationHeadquarter.get(index);

		Organization organization = new Organization(id, name, description, link, date, headquarter);
		return organization;
	}

	/**
	 * Tạo ra một số lượng Organzation và thêm vào database.
	 * 
	 * @param numberOrganization
	 *            Số lượng Organization muốn tạo.
	 * @param conn:
	 *            kết nối đến repository của GraphDB.
	 * @return : list các IRI Id của Organization đã thêm vào GraphDB
	 */
	public ArrayList<IRI> createEvent(int numberOrganization, RepositoryConnection conn) {
		ValueFactory vf = conn.getValueFactory();
		StoreData storeData = new StoreData();
		ArrayList<IRI> listOrganizationIri = new ArrayList<IRI>();
		int count = 1;

		for (int i = 1; i <= numberOrganization; i++) {
			Organization organization = randomOrganzation(i);

			IRI locationIri = storeData.addToModel(organization, vf, model);
			listOrganizationIri.add(locationIri);

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

		return listOrganizationIri;
	}
}
