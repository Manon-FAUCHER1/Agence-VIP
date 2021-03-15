/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Clients;
import Entities.Reservations;
import Executable.Application;

/**
 * @author manon
 */
public class ReservationsDAO {
	
	private static EntityManager em;
	
	public ReservationsDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	/**
	 * Retourne la liste des Reservations en cours
	 * @return Liste<Reservation>
	 */
	public List<Reservations> selectCurrent() {
		TypedQuery<Reservations> query = em.createQuery(
				"SELECT reservations FROM Reservations reservations WHERE reservations.date_fin IS NULL",
				Reservations.class);
		return query.getResultList();
	}
	
	/**
	 * Retourne la liste des Reservations fini
	 * @return Liste<Reservation>
	 */
	public List<Reservations> selectFinish() {		
		TypedQuery<Reservations> query = em.createQuery(
				"SELECT reservations FROM Reservations reservations WHERE reservations.date_fin < DATE( NOW() )",
				Reservations.class);
		 return query.getResultList();		 
	}
	
	public void insert(Reservations reservation) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(reservation);
		
		transaction.commit();
	}
	
	public void close() {
		
	}

}
