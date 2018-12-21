package test;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.spin.function.spif.ForEach;

import com.ontotext.license.c;

import config.TypeRelationship;
import connection.DatabaseConnector;
import create.data.CountryCreator;
import create.data.DataCreator;
import create.data.EventCreator;
import create.data.LocationCreator;
import create.data.PersonCreator;
import create.data.RelationshipCreator;

public class TestDataCreator {

	public static void main(String[] args) {
		long start, end;
		RepositoryConnection conn = DatabaseConnector.getConnection();
//		 start = System.currentTimeMillis();
		
		CountryCreator countryCreator = new CountryCreator();
		EventCreator eventCreator = new EventCreator();
		RelationshipCreator relationshipCreator = new RelationshipCreator();
		
		ArrayList<IRI> countryIri = countryCreator.createCountry(10000, conn);
		ArrayList<IRI> evenIri = eventCreator.createEvent(10000, conn);
		
		start = System.currentTimeMillis();
		
		//relationshipCreator.createRelationship(100000, countryIri, evenIri, TypeRelationship.RE_COUNTRY_EVENT, conn);
		
		end = System.currentTimeMillis();
		
		System.out.println(countryIri.get(4));
		
		System.out.println("Thời gian: " + (end - start) + " ms");
	}

}
