/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.Camions;
import Entities.Societe;
import Entities.TypeVehicules;
import Entities.Vehicules;
import Entities.Voitures;
import Enumerations.StatusVehicules;
import Executable.Application;
import Utils.VerifUtils;

/**
 * @author manon
 *
 */
public class VehiculesDAO {
	private static EntityManager em = Application.emf.createEntityManager();

	/**
	 * @return List<Vehicules>
	 */
	public static List<Vehicules> selectAll() {

		TypedQuery<Vehicules> query = em.createQuery("SELECT vehicules FROM Vehicules vehicules", Vehicules.class);
		List<Vehicules> vehicules = query.getResultList();

		return vehicules;
	}

	public static List<Vehicules> selectVehiculeReservNull() {

		TypedQuery<Vehicules> query = em.createQuery(
				"SELECT vehicules FROM Vehicules vehicules JOIN vehicules.reservations reservations WHERE reservations.",
				Vehicules.class);
		List<Vehicules> vehicules = query.getResultList();

		return vehicules;
	}

	public static void insertVoiture(String marque, String modele, TypeVehicules typeVehicule, String immatriculation,
			String nbPlace, String kilometrage, String commentaire) {

		Voitures voiture = new Voitures();

		// Verification des champs obligatoire
		marque = VerifUtils.verifString(marque);
		modele = VerifUtils.verifString(modele);
		immatriculation = VerifUtils.verifString(immatriculation);
		StatusVehicules statusVehicule = StatusVehicules.find("DISPONIBLE");
		int nbPlace1 = VerifUtils.parseInteger(nbPlace);
		double kilometrage1 = VerifUtils.parseDouble(kilometrage);

		voiture.setMarque(marque);
		voiture.setModele(modele);
		voiture.setTypeVehicule(typeVehicule);
		voiture.setImmatriculation(immatriculation);
		voiture.setStatusVehicule(statusVehicule);
		voiture.setKilometrage(kilometrage1);
		voiture.setNbPlace(nbPlace1);
		voiture.setCommentaire(commentaire);

		TypedQuery<Voitures> query = em.createQuery(
				"SELECT voitures FROM Voitures voitures WHERE voitures.immatriculation = ?", Voitures.class);
		query.setParameter(1, immatriculation);
		List<Voitures> voitures = query.getResultList();

		if (voitures.isEmpty()) {
			em.persist(voitures);
		} else {
			voiture = voitures.get(0);
		}

	}

	public static void insertCamion(String marque, String modele, TypeVehicules typeVehicule, String immatriculation,
			String volume, String kilometrage, String commentaire) {

		Camions camion = new Camions();

		// Verification des champs obligatoire
		marque = VerifUtils.verifString(marque);
		modele = VerifUtils.verifString(modele);
		immatriculation = VerifUtils.verifString(immatriculation);
		StatusVehicules statusVehicule = StatusVehicules.find("DISPONIBLE");
		double volume1 = VerifUtils.parseDouble(volume);
		double kilometrage1 = VerifUtils.parseDouble(kilometrage);

		camion.setMarque(marque);
		camion.setModele(modele);
		camion.setTypeVehicule(typeVehicule);
		camion.setImmatriculation(immatriculation);
		camion.setVolume(volume1);
		camion.setStatusVehicule(statusVehicule);
		camion.setKilometrage(kilometrage1);
		camion.setCommentaire(commentaire);

		TypedQuery<Camions> query = em
				.createQuery("SELECT camions FROM Camions camions WHERE camions.immatriculation = ?", Camions.class);
		query.setParameter(1, immatriculation);
		List<Camions> camions = query.getResultList();

		if (camions.isEmpty()) {
			em.persist(camions);
		} else {
			camion = camions.get(0);
		}
	}

	public static void edit(Vehicules vehiculeUpdate) {

		// Modification de l'immatriculation seulement si le vehicule 
		List<Vehicules> Listvehicules = VehiculesDAO.selectVehiculeReservNull();
		for (Vehicules vehicule : Listvehicules) {
			if (vehiculeUpdate == vehicule) {

				TypedQuery<Vehicules> query = em.createQuery(
						"UPDATE Vehicules vehicule SET vehicule.immatriculation = :newImmatriculation WHERE vehicule.id = ?1",
						Vehicules.class);
				query.setParameter("newImmatriculation", vehicule.getImmatriculation());
				query.setParameter(1, vehicule.getId());

			}
		}
		
		

	}

	public static void delete(Vehicules vehicule) {

		TypedQuery<Vehicules> query = em
				.createQuery("DELETE FROM Vehicules vehicule WHERE vehicule.immatriculation = ?1", Vehicules.class);
		query.setParameter(1, vehicule.getImmatriculation());

	}

}
