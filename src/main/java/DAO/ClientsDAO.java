/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import Entities.Clients;
import composants.db.SqlUtils;




/**
 * @author manon
 *
 */
public class ClientsDAO {

	/** entity manager */
	private EntityManager em;

	/**
	 * Constructor
	 * @param em entity manager
	 */
	public ClientsDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	/** Retourne une personne en fonction de son id
	 * @param id identifiant
	 * @return {@link Client}
	 */
	public Clients getClient(int id){
		return em.find(Clients.class, id);
	}
	
	/**
	 * Returne la liste de tout les clients
	 * @return List<Clients>
	 */
	public List<Clients> selectAll() {
		TypedQuery<Clients> query = em.createQuery("SELECT clients FROM Clients clients", Clients.class);
		return query.getResultList();
	}
	

	/**
	 * Insererer un client
	 * @param client : nouveau client
	 */
	public void insert(Clients client) {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		em.persist(client);
		
		transaction.commit();
	}

	/** 
	 * Modifie un client
	 * @param client : client avec les nouvelles données
	 */
	public void edit(Clients client) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Clients clientDB = getClient(client.getId());
		if (clientDB!=null) {
			clientDB.setNom(client.getNom());
			clientDB.setPrenom(client.getPrenom());
			clientDB.setAdresse(client.getAdresse());
			clientDB.setTelephone(client.getTelephone());
			clientDB.setPermis(client.getPermis());
			clientDB.setEmail(client.getEmail());
			
		}
		
		transaction.commit();
	}

	/** Suppression du client dont l'id est passé en paramètre
	 * @param id : identifiant du client
	 */
	public void delete(int id) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Clients clientDB = getClient(id);
		if (clientDB!=null) {
			em.remove(clientDB);
		}
		transaction.commit();
	}
	
	/**
	 * Lance un script d'initialisation si la table des Clients est vide
	 */
	public void init() {
		TypedQuery<Clients> query = em.createQuery("SELECT clients FROM Clients clients", Clients.class);
		List<Clients> clients = query.getResultList();
		if (clients.size()==0) {
			SqlUtils.executeFile("exemple.sql", em);
		}
	}
	
}
