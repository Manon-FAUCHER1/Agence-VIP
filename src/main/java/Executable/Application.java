/**
 * 
 */
package Executable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


/**
 * @author manon
 *
 */
public class Application {
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Agence-VIP");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		transaction.commit();

	}

}
