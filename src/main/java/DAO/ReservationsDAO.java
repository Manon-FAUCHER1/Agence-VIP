/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.Clients;
import Entities.Reservations;
import Executable.Application;

/**
 * @author manon
 */
public class ReservationsDAO {
	
	private static EntityManager em = Application.emf.createEntityManager();
	
	public static List<Reservations> slectCurrent() {
		
		TypedQuery<Reservations> query = em.createQuery(
				"SELECT reservations FROM Reservations reservations WHERE reservations.date_fin IS NULL",
				Reservations.class);
		List<Reservations> reservations = query.getResultList();
		
		return reservations;
		
	}
	
	public static List<Reservations> selectFinish() {
		
		TypedQuery<Reservations> query = em.createQuery(
				"SELECT reservations FROM Reservations reservations WHERE reservations.date_fin < DATE( NOW() )",
				Reservations.class);
		List<Reservations> reservations = query.getResultList();
		
		return reservations;
	}
	
	public static void edit() {
		
	}
	
	public static void delete() {
		
	}

}
