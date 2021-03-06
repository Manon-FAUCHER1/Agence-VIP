package composants.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.persistence.EntityManager;

import composants.error.ErrorManager;

/** Permet de charger un script SQL en base de données
 * @author RichardBONNAMY
 *
 */
public class SqlUtils {

	/** Exécute toutes les requêtes SQL situées dans un fichier. Le fichier doit être dans le répertoire resources 
	 * @param fileName nom du fichier
	 * @param entityManager entityManager
	 */
	public static void executeFile(String fileName, EntityManager entityManager) {
	    try {
	    	InputStream sqlFileInputStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(sqlFileInputStream));
			String line = null;
			while( (line = br.readLine()) != null ) {
			    entityManager.getTransaction().begin();
			    System.out.println(line);
			    if (line.trim().length() > 0) {
			    	 entityManager.createNativeQuery(line).executeUpdate();
				}
			 
			    entityManager.getTransaction().commit();
			}
			br.close();
		} catch (IOException e) {
			ErrorManager.manage(e.getMessage(), e);
		}
	}
}
