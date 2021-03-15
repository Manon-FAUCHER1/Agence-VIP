/**
 * 
 */
package Executable;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Services.GestionClients.ListeClients;
import Services.GestionReservations.ListeReservationsEnCours;
import Services.GestionTypesVehicules.ListeTypesVehicules;
import Services.GestionVehicules.ListeVehicules;
import composants.AbstractApplication;




/**
 * @author manon
 *
 */
public class Application extends AbstractApplication {
	
	/** serialVersionUID */
	private static final long serialVersionUID = 6755835482616236832L;
	
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Agence-VIP");
	
	/**
	 * Constructor
	 * @param title
	 */
	public Application(String title) {
		super(title);
	}
	
	/**
	 * @param args
	 */
	public void main() {
		
		addMenu(1, "Gestion des véhicules");
		addMenu(2, "Gestion des clients");
		addMenu(3, "Gestion des réservations");
		
		addMenuOption(1, "Liste des Vehicules", new ListeVehicules());
		addMenuOption(1, "Liste des types de vehicule", new ListeTypesVehicules());
		addMenuOption(2, "Liste des clients", new ListeClients());
		addMenuOption(3, "Liste des résertions en cours", new ListeReservationsEnCours());
		addMenuOption(3, "Liste des résertions terminé", new ListeReservationsEnCours());
		addMenuOption(3, "ouvrire une nouvelle reservation", new ListeReservationsEnCours());
		
		
	}

}
