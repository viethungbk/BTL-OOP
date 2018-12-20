package connection;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.http.HTTPRepository;

import config.ConectionConfig;

/*
 * Connect to database
 */
public class DatabaseConnector extends ConectionConfig {

	/*
	 * Tạo kết nối đến database
	 */
	public static RepositoryConnection getConnection() {
		Repository repo = new HTTPRepository(ConectionConfig.GRAPHDB_SERVER, ConectionConfig.REPOSITORY_ID);
		System.out.println("1 lần connect");
		try {
			repo.initialize();
			RepositoryConnection conn = repo.getConnection();
			System.out.println("Connected !");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Cant connect !");
		return null;
	}
}
