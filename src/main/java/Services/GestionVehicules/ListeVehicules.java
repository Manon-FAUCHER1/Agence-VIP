package Services.GestionVehicules;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import DAO.TypeVehiculeDAO;
import DAO.VehiculesDAO;
import Entities.Camions;
import Entities.TypeVehicules;
import Entities.Vehicules;
import Entities.Voitures;
import Enumerations.StatusVehicules;
import Executable.Application;
import composants.MenuService;
import composants.Utils;
import composants.ui.ComboBox;
import composants.ui.DateField;
import composants.ui.Form;
import composants.ui.Selectable;
import composants.ui.TextField;

/**
 * @author manon
 *
 */
public class ListeVehicules extends MenuService {
	
	/** VehiculesDAO **/
	private VehiculesDAO vehiculesDao;
	private TypeVehiculeDAO typeVehiculeDAO;

	/**
	 * Constructor
	 */
	public ListeVehicules() {
		EntityManager em = Application.emf.createEntityManager();

		vehiculesDao = new VehiculesDAO(em);
		typeVehiculeDAO = new TypeVehiculeDAO(em);
	}

	@Override
	public void traitement() {
		List<Vehicules> vehicules = vehiculesDao.selectAll();
		
		console.clear();
		console.println("<h1 class='bg-green'>Liste des vehicules</h1>");
		
		console.print("Ajouter un Camion",
				"<a class='btn-blue' href='ajouterCamion()'><img width=25 src='images/plus-blue.png'></a>");
		
		console.print("Ajouter une voiture",
				"<a class='btn-blue' href='ajouterVoiture()'><img width=25 src='images/plus-blue.png'></a>");

		String html = "<table class='table' cellspacing=0>" + "<tr class='bg-green'>" + "<td>&nbsp;</td>"
				+ "<td>&nbsp;</td>" + "<td>Marque</td>" + "<td>Modele</td>" + "<td>Immatriculation</td>" + "<td>Kilometrage</td>" + "<td>Nombre de place</td>" +  "<td>Volume</td>" + "<td>Commentaire</td>" + "</tr>";
		
		for (Vehicules vehicule : vehicules) {
			html += "<tr>" 
					+ "<td>" + "<a class='btn-blue' href='modifier(" + vehicule.getId() + ")'><img width=25 src='images/pencil-blue-xs.png'></a>" + "</td>" 
					+ "<td>" + "<a class='btn-red' href='supprimer(" + vehicule.getId() + ")'><img width=25 src='images/trash-red-xs.png'></a>" + "</td>" 
					+ "<td width='150px'>" + vehicule.getMarque() + "</td>" 
					+ "<td width='150px'>" + vehicule.getModele() + "</td>" 
					+ "<td width='150px'>" + vehicule.getImmatriculation() + "</td>"
					+ "<td width='150px'>" + vehicule.getKilometrage() + "</td>"
					+ "<td width='150px'>" + vehicule.getNbPlace() + "</td>"
					+ "<td width='150px'>" + vehicule.getVolume() + "</td>"
					+ "<td width='150px'>" + vehicule.getCommentaire() + "</td>"
					+ "</tr>";
		}
		html += "</table>";

		console.println(html);
	
	}
	
	/**
	 * Méthode appelée lorsque l'utilisateur clique sur l'icone + Camion
	 */
	public void ajouterCamion() {
		
		Form form = new Form();
		List<TypeVehicules> typevehicule = typeVehiculeDAO.selectAll();
		List<Selectable> selectable = new ArrayList<>(typevehicule);
		
		form.addInput(new TextField("Marque:", "marque"));
		form.addInput(new TextField("Modele:", "modele"));
		form.addInput(new TextField("Type:", "type"));
		form.addInput(new TextField("Immatriculation:", "immatriculation"));
		form.addInput(new TextField("Volume:", "volume"));
		form.addInput(new TextField("Status:", "status", StatusVehicules.DISPONIBLE, false));
		form.addInput(new TextField("Kilometrage:", "kilometrage"));
		form.addInput(new TextField("Commentaire:", "commentaire"));
		form.addInput(new ComboBox("Type:", "type", selectable));
		
		FormVehiculeValidator formValidator = new FormVehiculeValidator();
		
		boolean validation = console.input("Ajout d'un nouveau camion", form, formValidator);
		if (validation) {
			
			StatusVehicules statusV = StatusVehicules.find(form.getValue("status"));
			
			Camions nvCamions = new Camions(
					form.getValue("marque"),
					form.getValue("modele"),
					form.getValue("immatriculation"),
					Utils.parseDouble(form.getValue("kilometrage")),
					statusV,
					form.getValue("commentaire"),
					form.getValue("volume"),
					form.getValue("type"));
					
					vehiculesDao.insertCamion(nvCamions);
					
					traitement();
		}
	}
	
	/**
	 * Méthode appelée lorsque l'utilisateur clique sur l'icone + Voiture
	 */
	public void ajouterVoiture() {
		
		Form form = new Form();
		List<TypeVehicules> typevehicule = typeVehiculeDAO.selectAll();
		List<Selectable> selectable = new ArrayList<>(typevehicule);
		
		form.addInput(new TextField("Marque:", "marque"));
		form.addInput(new TextField("Modele:", "modele"));
		form.addInput(new TextField("Type:", "type"));
		form.addInput(new TextField("Immatriculation:", "immatriculation"));
		form.addInput(new TextField("Volume:", "volume"));
		form.addInput(new TextField("Status:", "status", StatusVehicules.DISPONIBLE, false));
		form.addInput(new TextField("Kilometrage:", "kilometrage"));
		form.addInput(new TextField("Commentaire:", "commentaire"));
		form.addInput(new ComboBox("Nombre de Places:", "nbPlace", selectable));
		
		FormVehiculeValidator formValidator = new FormVehiculeValidator();
		
		boolean validation = console.input("Ajout d'un nouveau camion", form, formValidator);
		if (validation) {
			
			StatusVehicules statusV = StatusVehicules.find(form.getValue("status"));
			
			Voitures nvVoiture = new Voitures(
					form.getValue("marque"),
					form.getValue("modele"),
					form.getValue("immatriculation"),
					Utils.parseDouble(form.getValue("kilometrage")),
					statusV,
					form.getValue("commentaire"),
				 	Utils.parseInteger(form.getValue("nbPlace")),
					form.getValue("type"));
					
					vehiculesDao.insertVoiture(nvVoiture);
					
					traitement();
		}
	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone de modification
	 * dans la table des vehicule.
	 * 
	 * @param id identifiant du vehicule à modifier.
	 */
	public void modifier(int id) {
		
		Vehicules vehicule = vehiculesDao.getVehicule(id);
		
		Form form = new Form();
		
		form.addInput(new TextField("Marque:", "marque", vehicule.getMarque()));
		form.addInput(new TextField("Modele:", "modele", vehicule.getModele()));
		form.addInput(new TextField("Immatriculation:", "immatriculation", vehicule.getImmatriculation()));
		form.addInput(new TextField("Status:", "status", vehicule.getStatusVehicule(), false));
		form.addInput(new TextField("Kilometrage:", "kilometrage", Double.toString(vehicule.getKilometrage())));
		form.addInput(new TextField("Commentaire:", "commentaire", vehicule.getCommentaire()));
		form.addInput(new TextField("Nombre de Places:", "nbPlace", Integer.toString(vehicule.getNbPlace())));
		form.addInput(new TextField("Volume:", "volume", Double.toString(vehicule.getVolume())));
		
		
	}
	
	
	
	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone de suppression
	 * dans la table des Vehicules
	 * 
	 * @param id identifiant du vehicule à supprimer.
	 */
	public void supprimer(int id) {
		boolean result = console.confirm("Suppression du vehicule " + id,
				"Confirmez-vous la suppression du vehicule n°" + id);
		if (result) {
			vehiculesDao.delete(id);
			traitement();
		}
	}
	

}
