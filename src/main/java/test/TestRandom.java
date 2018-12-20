package test;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.TreeModel;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import config.FileConfig;
import connection.DatabaseConnector;

public class TestRandom extends FileConfig {

	public static void main(String[] args) {
		RepositoryConnection conn = DatabaseConnector.getConnection();
		System.out.println("Kết nối xong");
		ValueFactory vf = conn.getValueFactory();
		System.out.println("Tạo VF xong");

		Model model = new TreeModel();
		String namespace = "http://hunghung.test/";
		long startTime, endTime;
		
		startTime = System.currentTimeMillis();
		for (int i = 1; i <= 1000; i++) {
			IRI hung = vf.createIRI(namespace, "Hung" + i);
			IRI student = vf.createIRI(namespace, "Student" + i);

			model.add(hung, RDF.TYPE, student);
			
			System.out.println(i);
		}
		conn.add(model);
		conn.close();
		endTime = System.currentTimeMillis();
		
		System.out.println("Da them vao GraphDB trong " + (endTime - startTime) + "ms");
	}

}
