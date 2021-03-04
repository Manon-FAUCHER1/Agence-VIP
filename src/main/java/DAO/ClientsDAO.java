/**
 * 
 */
package DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.Adresses;
import Entities.Clients;
import Entities.Permis;
import Executable.Application;
import Utils.VerifUtils;

/**
 * @author manon
 *
 */
public class ClientsDAO {

	private static EntityManager em = Application.emf.createEntityManager();

	/**
	 * @return List<Clients>
	 */
	public static List<Clients> selectAll() {

		TypedQuery<Clients> query = em.createQuery("SELECT clients FROM Clients clients", Clients.class);
		List<Clients> clients = query.getResultList();

		return clients;
	}

	public static void insert(String nom, String prenom, String telephone, String email, String numeroRue,
			String libelleRue, String codePostal, String ville, String typePermis, String numeroPermis,
			Date dateObtention) {

		Adresses adresse = new Adresses();
		
		int numeroRue2 = VerifUtils.parseInteger(numeroRue);
		adresse.setNumero(numeroRue2);
		libelleRue = VerifUtils.verifString(libelleRue);
		adresse.setRue(libelleRue);
		codePostal = VerifUtils.verifString(codePostal);
		adresse.setCodePostal(codePostal);
		ville = VerifUtils.verifString(ville);
		adresse.setVille(ville);
		
		Permis permis = new Permis();
		
		typePermis = VerifUtils.verifString(typePermis);
		permis.setType(typePermis);
		numeroPermis = VerifUtils.verifString(numeroPermis);
		permis.setNumero(numeroPermis);
		
		permis.setDateObtention(dateObtention);
				
		Clients client = new Clients();
		
		nom = VerifUtils.verifString(nom);
		client.setNom(nom);
		
		prenom = VerifUtils.verifString(prenom);
		client.setPrenom(prenom);
		
		telephone = VerifUtils.verifString(telephone);
		telephone = VerifUtils
		client.setTelephone(telephone);
		client.setEmail(email);
		client.setAdresse(adresse);
		client.setPermis(permis);
		

	}

	public static void edit() {

	}

	public static void delete() {

	}
}
