package create.data;

import java.util.ArrayList;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import config.QuantityConfig;
import config.TypeRelationship;
import connection.DatabaseConnector;

public class DataCreator {
	
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
		RepositoryConnection conn = DatabaseConnector.getConnection();
		QuantityConfig quantityConfig = new QuantityConfig(numberEntity, numberRelationship);
		
		CountryCreator countryCreator = new CountryCreator();
		EventCreator eventCreator = new EventCreator();
		LocationCreator locationCreator = new LocationCreator();
		OrganizationCreator organizationCreator = new OrganizationCreator();
		PersonCreator personCreator = new PersonCreator();
		TimeCreator timeCreator = new TimeCreator();
		RelationshipCreator relationshipCreator = new RelationshipCreator();
		
		ArrayList<IRI> listCountryIri = countryCreator.createCountry(quantityConfig.getNumberCountry(), conn);
		ArrayList<IRI> listEventIri = eventCreator.createEvent(quantityConfig.getNumberEvent(), conn);
		
		relationshipCreator.createRelationship(quantityConfig.getNumber_Re_Country_Event(),
						listCountryIri, listEventIri, TypeRelationship.RE_COUNTRY_EVENT, conn);
		listCountryIri.clear();
		
		ArrayList<IRI> listLocationIri = locationCreator.createEvent(quantityConfig.getNumberLocation(), conn);
		
		relationshipCreator.createRelationship(quantityConfig.getNumber_Re_Event_Location(),
						listEventIri, listLocationIri, TypeRelationship.RE_EVENT_LOCATION, conn);
		
		ArrayList<IRI> listTimeIri = timeCreator.createTime(quantityConfig.getNumberTime(), conn);
		
		relationshipCreator.createRelationship(quantityConfig.getNumber_Re_Event_Time(),
						listEventIri, listTimeIri, TypeRelationship.RE_EVENT_TIME, conn);
		listTimeIri.clear();
		
		ArrayList<IRI> listOrganizationIri = organizationCreator.createOrganization(quantityConfig.getNumberOrganization(), conn);
		
		relationshipCreator.createRelationship(quantityConfig.getNumber_Re_Organization_Event(),
				listOrganizationIri, listEventIri, TypeRelationship.RE_ORGANIZATION_EVENT, conn);
		relationshipCreator.createRelationship(quantityConfig.getNumber_Re_Organization_Location(),
						listOrganizationIri, listLocationIri, TypeRelationship.RE_ORGANIZTION_LOCATION, conn);
		listOrganizationIri.clear();
		
		ArrayList<IRI> listPersonIri = personCreator.createPerson(quantityConfig.getNumberPerson(), conn);
		
		relationshipCreator.createRelationship(quantityConfig.getNumber_Re_Person_Event(),
						listPersonIri, listEventIri, TypeRelationship.RE_PERSON_EVENT, conn);
		
		relationshipCreator.createRelationship(quantityConfig.getNumber_Re_Person_Location(),
						listPersonIri, listLocationIri, TypeRelationship.RE_PERSON_LOCATION, conn);
		
	}

}
