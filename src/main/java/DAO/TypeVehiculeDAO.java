/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Entities.Clients;
import Entities.TypeVehicules;
import Executable.Application;
import composants.db.SqlUtils;

/**
 * @author manon
 *
 */
public class TypeVehiculeDAO {
	
	/** entity manager */
	private EntityManager em;
	
	/**
	 * Constructor
	 * @param em entity manager
	 */
	public TypeVehiculeDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	/** Retourne un type de vehicule en fonction de son id
	 * @param id identifiant
	 * @return {@link TypeVehicules}
	 */
	public TypeVehicules getType(int id){
		return em.find(TypeVehicules.class, id);
	}
	
	/**
	 * Returne la liste de tout les TypeVehicules
	 * @return List<TypeVehicules>
	 */
	public List<TypeVehicules> selectAll() {
		
		TypedQuery<TypeVehicules> query = em.createQuery(
				"SELECT typeVehicules FROM TypeVehicules typeVehicules",
				TypeVehicules.class);
		List<TypeVehicules> typeVehicules = query.getResultList();
		
		return typeVehicules;
	}

	/**
	 * Insererer un client
	 * @param TypeVehicules : nouveau Type
	 */
	public void insert(TypeVehicules typeVehicule) {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(typeVehicule);
		
		transaction.commit();
	}

	/** 
	 * Modifie un client
	 * @param client : client avec les nouvelles données
	 */
	public void editType(TypeVehicules typeVehicule) {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		TypeVehicules typeDB = getType(typeVehicule.getId());
		if (typeDB!=null) {
			typeDB.setNom(typeVehicule.getNom());
			typeDB.setTarifJour(typeVehicule.getTarifJour());
			typeDB.setCaution(typeVehicule.getCaution());
		}
		
		transaction.commit();
	}
	
	/**
	 * Lance un script d'initialisation si la table des Clients est vide
	 */
	public void init() {
		TypedQuery<TypeVehicules> query = em.createQuery("SELECT type FROM TypeVehicules type", TypeVehicules.class);
		List<TypeVehicules> clients = query.getResultList();
		if (clients.size()==0) {
			SqlUtils.executeFile("exemple.sql", em);
		}
	}

}
