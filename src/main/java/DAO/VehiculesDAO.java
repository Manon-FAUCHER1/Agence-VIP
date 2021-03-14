/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Camions;
import Entities.Clients;
import Entities.Vehicules;
import Entities.Voitures;
import composants.db.SqlUtils;


/**
 * @author manon
 *
 */
public class VehiculesDAO {
	
	/** entity manager */
	private EntityManager em;
	
	/**
	 * Constructor
	 * @param em entity manager
	 */
	public VehiculesDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	/** Retourne un vehicule en fonction de son id
	 * @param id identifiant
	 * @return {@link Vehicules}
	 */
	public Vehicules getVehicule(int id){
		return em.find(Vehicules.class, id);
	}

	/**
	 * Return la liste de tous les Vehicules
	 * @return List<Vehicules>
	 */
	public List<Vehicules> selectAll() {
		TypedQuery<Vehicules> query = em.createQuery("SELECT vehicules FROM Vehicules vehicules ORDER BY vehicules.marque ASC", Vehicules.class);
		return query.getResultList();
	}

	/**
	 * Return la liste de tous les Vehicules qui n'on aucune reservation
	 * @return List<Vehicules>
	 */
	public List<Vehicules> selectVehiculeReservNull() {

		TypedQuery<Vehicules> query = em.createQuery(
				"SELECT vehicules FROM Vehicules vehicules JOIN vehicules.reservations reservations WHERE reservations.",
				Vehicules.class);
		return query.getResultList();

	}

	/**
	 * Insererer une voiture
	 * @param voiture : nouvelle voiture
	 */
	public  void insertVoiture(Voitures voiture) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(voiture);
		
		transaction.commit();
	}
	
	/**
	 * Insererer un camion
	 * @param camion : nouveau camion
	 */
	public  void insertCamion(Camions camion) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(camion);
		
		transaction.commit();
	}

	/** 
	 * Modifie un vehicule
	 * @param vehicule : vehicule avec les nouvelles données
	 */
	public  void edit(Vehicules vehicule) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Vehicules vehiculeDB = getVehicule(vehicule.getId());
		if (vehiculeDB!=null) {
			vehiculeDB.setMarque(vehicule.getMarque());
			vehiculeDB.setModele(vehicule.getModele());
			vehiculeDB.setImmatriculation(vehicule.getImmatriculation());
			vehiculeDB.setKilometrage(vehicule.getKilometrage());
			vehiculeDB.setCommentaire(vehicule.getCommentaire());
		}
		
		transaction.commit();
	}

	/** Suppression d'un vehicule dont l'id est passé en paramètre
	 * @param id : identifiant du vehicule
	 */
	public  void delete(int id) {

		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		List<Vehicules> liVehicules = selectVehiculeReservNull();
		Vehicules vehiculeDB = getVehicule(id);
		
		for (Vehicules vehicules : liVehicules) {
			if (vehicules == vehiculeDB && vehiculeDB!=null) {
				em.remove(vehiculeDB);
			} else {
				System.err.println("Le vehicule a des reservation il ne peut pas etre supprimé !");
			}	
		}
		
		transaction.commit();
	}
	
	/**
	 * Lance un script d'initialisation si la table des Vehicule est vide
	 */
	public void init() {
		TypedQuery<Clients> query = em.createQuery("SELECT clients FROM Clients clients", Clients.class);
		List<Clients> clients = query.getResultList();
		if (clients.size()==0) {
			SqlUtils.executeFile("exemple.sql", em);
		}
	}

}
