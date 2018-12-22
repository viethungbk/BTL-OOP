package create.data;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
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
	
	public ArrayList<IRI> getListRelaIri(int numRela, TypeRelationship typeRelationship, RepositoryConnection conn) {
		ArrayList<String> listRela = new ArrayList<String>();
		ArrayList<IRI> listRelaIri = new ArrayList<IRI>();
		ValueFactory vf = conn.getValueFactory();
		Random random = new Random();
		String rela;
		int randomRange;
		
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
		
		randomRange = listRela.size() - 1;
		
		for (int i = 1; i <= numRela; i++) {
			rela = listRela.get(random.nextInt(randomRange));
			listRelaIri.add(vf.createIRI(EntityConfig.RELATIONSHIP_NAMESPACE + typeRelationship.getRelationship()
								+ Integer.toString(i), rela));
		}
		
		return listRelaIri;
	}
	
	public ArrayList<IRI> getlistEntityRandom(int numberEntity, ArrayList<IRI> listEntity) {
		Random random = new Random();
		ArrayList<IRI> listResult = new ArrayList<IRI>();
		int randomRange = listEntity.size() - 1;
		
		for (int i = 1; i <= numberEntity; i++) {
			listResult.add(listEntity.get(random.nextInt(randomRange)));
		}
		
		return listResult;
	}
	
	public void createRelationship(int numberRela, ArrayList<IRI> listEntity1, ArrayList<IRI> listEntity2,
			TypeRelationship typeRelationship, RepositoryConnection conn) {
		
		System.out.println("Đang thêm quan hệ...");

		ArrayList<IRI> listRelationshipIRI = getListRelaIri(numberRela, typeRelationship, conn);
		ArrayList<IRI> listEntity1Iri = getlistEntityRandom(numberRela, listEntity1);
		ArrayList<IRI> listEntity2Iri = getlistEntityRandom(numberRela, listEntity2);
		
		int count = 1;
		
		for (int i = 0; i < numberRela; i++) {
			model.add(listEntity1Iri.get(i), listRelationshipIRI.get(i), listEntity2Iri.get(i));
			
			if (i % 1000 == 0) {
				
				conn.add(model);
				model.clear();
				model = new TreeModel();
	
				System.out.println("Thêm 10000 Rela lần " + count);
				count++;
			}
		}
		
		conn.add(model);
		model.clear();
		
		
		System.out.println("Đã thêm quan hệ vào cơ sở dữ liệu");
	}

}
