package create.data;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import config.EntityConfig;
import config.FileConfig;
import config.TypeRelationship;
import read.file.FileReader;

/**
 * Đọc các file chứa quan hệ giữa các thực thể, tạo ngẫu nhiên các quan hệ giữa
 * các thực thể và thêm chúng vào database.
 * 
 * @author Viet Hung
 *
 */
public class RelationshipCreator {
	Model model;
	FileReader fileReader;
	ArrayList<String> listRelationship;

	// Constructor
	public RelationshipCreator() {
		model = new TreeModel();
		fileReader = new FileReader();
		listRelationship = new ArrayList<String>();
	}
	
	/**
	 * Đọc file quan hệ giữa các thực thể và trả ra một mảng.
	 * 
	 * @param typeRelationship
	 *            Loại quan hệ của thực thể.
	 * @return Mảng các quan hệ đã đọc được từ file.
	 */
	public ArrayList<String> getListRela(TypeRelationship typeRelationship) {
		ArrayList<String> listRela = new ArrayList<String>();
		
		switch (typeRelationship) {
			case RE_COUNTRY_EVENT:
				listRela = fileReader.readData(FileConfig.FILE_RELATIONSHIP_COUNTRY_EVENT);
				break;
			case RE_EVENT_LOCATION:
				listRela = fileReader.readData(FileConfig.FILE_RELATIONSHIP_EVENT_LOCATION);
				break;
			case RE_EVENT_TIME:
				listRela = fileReader.readData(FileConfig.FILE_RELATIONSHIP_EVENT_TIME);
				break;
			case RE_ORGANIZATION_EVENT:
				listRela = fileReader.readData(FileConfig.FILE_RELATIONSHIP_ORGANIZATION_EVENT);
				break;
			case RE_ORGANIZTION_LOCATION:
				listRela = fileReader.readData(FileConfig.FILE_RELATIONSHIP_ORGANIZATION_LOCATION);
				break;
			case RE_PERSON_EVENT:
				listRela = fileReader.readData(FileConfig.FILE_RELATIONSHIP_PERSON_EVENT);
				break;
			case RE_PERSON_LOCATION:
				listRela = fileReader.readData(FileConfig.FILE_RELATIONSHIP_PERSON_LOCATION);
				break;
	
			default:
				break;
		}
		
		return listRela;
	}
	
	/**
	 * Tạo các quan hệ ngẫu nhiên giữa hai list thực thể và thêm vào Database.
	 * 
	 * @param numberRela
	 *            Số quan hệ giữa các thực thể muốn tạo.
	 * @param listEntity1
	 *            Danh sách thực thể.
	 * @param listEntity2
	 *            Danh sách thực thể.
	 * @param typeRelationship
	 *            Cho biết quan hệ giữa hai thực thể nào.
	 * @param conn
	 *            Kết nối đến repository của Database.
	 */
	public void createRelationship(int numberRela, ArrayList<IRI> listEntity1, ArrayList<IRI> listEntity2,
			TypeRelationship typeRelationship, RepositoryConnection conn) {

		System.out.println("Đang thêm quan hệ...");

		ValueFactory vf = conn.getValueFactory();
		listRelationship = getListRela(typeRelationship);
		Random random = new Random();

		int entity1RandRange = listEntity1.size() - 1;
		int entity2RandRange = listEntity2.size() - 1;
		int relaRandRange = listRelationship.size() - 1;

		IRI entity1Iri;
		IRI entity2Iri;
		IRI relationship;
		String rela;

		int count = 1;
		ModelBuilder builder = new ModelBuilder();

		for (int j = 1; j <= numberRela / 10000; j++) {
			for (int i = 1; i <= 10000; i++) {
				entity1Iri = listEntity1.get(random.nextInt(entity1RandRange));
				entity2Iri = listEntity2.get(random.nextInt(entity2RandRange));
				rela = listRelationship.get(random.nextInt(relaRandRange));
				relationship = vf.createIRI(
						EntityConfig.RELATIONSHIP_NAMESPACE + typeRelationship.getRelationship() + Integer.toString(i), rela);
	
				model.add(entity1Iri, relationship, entity2Iri);
				
//				model = builder.subject(entity1Iri)
//						.add(EntityConfig.RELATIONSHIP_NAMESPACE + Integer.toString(i) + rela, entity2Iri)
//						.build();
			}
			conn.add(model);
			model.clear();
			System.out.println("Thêm 10000 Rela lần " + count);
			count++;
		}
		// conn.add(model);
		System.out.println("Đã thêm quan hệ vào cơ sở dữ liệu");
	}
}
