package test;

import java.util.ArrayList;
import java.util.Random;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.spin.function.spif.ForEach;

import com.ontotext.license.c;

import connection.DatabaseConnector;
import create.data.CountryCreator;
import create.data.DataCreator;
import create.data.EventCreator;
import create.data.LocationCreator;
import create.data.PersonCreator;

public class TestDataCreator {

	public static void main(String[] args) {
		long start, end;
		RepositoryConnection conn = DatabaseConnector.getConnection();
		start = System.currentTimeMillis();
		
		LocationCreator locationCreator = new LocationCreator();
		ArrayList<IRI> list = locationCreator.createEvent(1000000, conn);
		
		end = System.currentTimeMillis();
		
		for (IRI iri : list) {
			System.out.println(iri);
		}
		
		System.out.println("Thời gian: " + (end - start) / 60000 + " p");
	}

}
