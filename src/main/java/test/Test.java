package test;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import connection.DatabaseConnector;

public class Test {
	public static void main(String[] args) {

		RepositoryConnection conn = DatabaseConnector.getConnection();
		System.out.println("Kết nối xong");
		ValueFactory vf = conn.getValueFactory();
		System.out.println("Tạo VF xong");
		
		String namespace = "http://hung.test/";
		IRI Person = vf.createIRI(namespace, "Person");
		IRI firstName = vf.createIRI(namespace, "firstName");
		IRI lastName = vf.createIRI(namespace, "lastName");
		IRI isStudent = vf.createIRI(namespace, "isStudent");
		Literal firstName1 = vf.createLiteral("Cao");
		Literal lastName1  = vf.createLiteral("Duc");
		Literal isStudent1 = vf.createLiteral("yes");
		conn.add(vf.createStatement(Person, firstName, firstName1)); // bang, ten cot, gia tri
		conn.add(vf.createStatement(Person, lastName, lastName1));
		conn.add(vf.createStatement(Person, isStudent, isStudent1));
		
		String queryString = "prefix :<http://hung.test/>\n" 		// use database
				+ "select ?p ?o\n"									// lay p va o
				+ "where{\n"
				+ ":Person ?p ?o\n"
				+ "}";
		TupleQuery query = conn.prepareTupleQuery(queryString);
		try {
			TupleQueryResult result = query.evaluate();
			while(result.hasNext()) {
				BindingSet solution = result.next();
				Value s = solution.getValue("s");
				Value p = solution.getValue("p");
				Value o = solution.getValue("o");
				//System.out.println(s);
				System.out.println(p);
				System.out.println(o);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		/*
		IRI testdb1 = vf.createIRI(namespace, "testdb1");
		IRI testdb2 = vf.createIRI(namespace, "testdb2");
		
		conn.add(testdb1, testdb2, vf.createLiteral("Create"));
		
		IRI picasso = vf.createIRI(namespace, "Picasso");
		IRI artist = vf.createIRI(namespace, "Artist");

		// Create a new, empty Model object.
		Model model = new TreeModel();

		// add our first statement: Picasso is an Artist
		model.add(picasso, RDF.TYPE, artist);

		// second statement: Picasso's first name is "Pablo".
		model.add(picasso, FOAF.FIRST_NAME, vf.createLiteral("Pablo"));
		*/
		
		/*ModelBuilder builder = new ModelBuilder();
		Model model = builder.setNamespace("ex", namespace)
				.subject("ex:VietHung")
				.add(RDF.TYPE, "ex:Student")
				.add(FOAF.FIRST_NAME, "Hung")
				.add(FOAF.LAST_NAME, "Viet")
				.build();
		for (Statement statement: model) {
		    System.out.println(statement);
		}
		conn.add(model);*/
		
		System.out.println("Đã thêm vào database");
	}
}
