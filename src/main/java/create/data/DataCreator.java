package create.data;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import config.EntityConfig;
import config.FileConfig;
import config.QuantityConfig;
import connection.DatabaseConnector;
import entities.Person;
import read.file.FileReader;

/*
 * Class sinh dữ liệu từ file dữ liệu đầu vào
 */
public class DataCreator {
	FileReader fileReader;

	

	private ArrayList<String> listLocationName;
	private ArrayList<String> listLocationDescription;
	private ArrayList<String> listLocationCountry;

	private ArrayList<String> listOrganizationName;
	private ArrayList<String> listOrganizationDescription;
	private ArrayList<String> listOrganizationHeadquarter;
	
	private ArrayList<String> listDateTime;
	private ArrayList<String> listTimeDescription;

	private ArrayList<String> listRe_Country_Event;
	private ArrayList<String> listRe_Event_Location;
	private ArrayList<String> listRe_Event_Time;
	private ArrayList<String> listRe_Organization_Event;
	private ArrayList<String> listRe_Organization_Location;
	private ArrayList<String> listRe_Person_Event;
	private ArrayList<String> listRe_Person_Location;

	// Constructor
	public DataCreator() {
		
	}

	/**
	 * Sinh ngẫu nhiên các thực thể và các quan hệ
	 * 
	 * @param numberEntity
	 *            : Số lượng thực thể muốn tạo
	 * @param numberRelationship
	 *            : Số lượng quan hệ giữa các thực thể muốn tạo
	 */
	public void createData(int numberEntity, int numberRelationship) {
		QuantityConfig quantityConfig = new QuantityConfig(numberEntity, numberRelationship);
		
	}

}
