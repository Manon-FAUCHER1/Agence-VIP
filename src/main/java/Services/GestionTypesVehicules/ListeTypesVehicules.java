package Services.GestionTypesVehicules;

import java.util.List;

import javax.persistence.EntityManager;

import DAO.TypeVehiculeDAO;
import DAO.VehiculesDAO;
import Entities.TypeVehicules;
import Executable.Application;
import composants.MenuService;
import composants.Utils;
import composants.ui.Form;
import composants.ui.TextField;

public class ListeTypesVehicules extends MenuService {
	
	/** DAO **/
	private TypeVehiculeDAO typeVehiculeDAO;
	
	/**
	 * Constructor
	 */
	public ListeTypesVehicules() {
		EntityManager em = Application.emf.createEntityManager();

		typeVehiculeDAO = new TypeVehiculeDAO(em);
		
		typeVehiculeDAO.init();
	}

	@Override
	public void traitement() {
		List<TypeVehicules> TypesVehicules = typeVehiculeDAO.selectAll();
		
		console.clear();
		console.println("<h1 class='bg-green'>Liste des Type de vehicule</h1>");
		
		console.print("Ajouter un type de vehicule","<a class='btn-ajout' style='font-size:15px' href='ajouter()'><img width=25 src='images/plus-dark.png'></a>");
		
		String html = "<table class='table' cellspacing=0>" + "<tr class='bg-green'>" 
		+ "<td>&nbsp;</td>" + "<td>&nbsp;</td>" + "<td>Nom</td>" + "<td>Tarif jour</td>" + "<td>Caution</td>" + "</tr>";

		for (TypeVehicules typeVehicule : TypesVehicules) {
			
			html += "<tr>" 
					+ "<td>" + "<a class='btn-blue' href='modifier(" + typeVehicule.getId() + ")'><img width=25 src='images/pencil-blue-xs.png'></a>" + "</td>" 
					+ "<td>" + "<a class='btn-red' href='supprimer(" + typeVehicule.getId() + ")'><img width=25 src='images/trash-red-xs.png'></a>" + "</td>" 
					+ "<td width='140px'>" + typeVehicule.getNom() + "</td>" 
					+ "<td width='140px'>" + typeVehicule.getTarifJour()  + "</td>" 
					+ "<td width='140px'>" + typeVehicule.getCaution() + "</td>"
					+ "</tr>";
		}
		html += "</table>";
			
		console.println(html);
		
	}

	/**
	 * Méthode appelée lorsque l'utilisateur clique sur l'icone +
	 */
	public void ajouter() {
		
		Form form = new Form();
		
		form.addInput(new TextField("Nom:", "nom"));
		form.addInput(new TextField("Tarif jour:", "tarifJour"));
		form.addInput(new TextField("Caution:", "caution"));
		
		FormTypesVehicules formValidator = new FormTypesVehicules();
		boolean validation = console.input("Ajout d'un nouveau type de vehicule", form, formValidator);
		if (validation) {
			
			TypeVehicules nvType = new TypeVehicules();
			nvType.setNom(form.getValue("nom"));
			nvType.setTarifJour(Utils.parseDouble(form.getValue("tarifJour")));
			nvType.setCaution(Utils.parseDouble(form.getValue("caution")));
			
			typeVehiculeDAO.insert(nvType);

			traitement();
		}		
	}
	
	/**
	 * Méthode appelée lorsque l'utilisateur clique sur l'icone de modification
	 * dans la table des type.
	 * 
	 * @param id identifiant du type à modifier.
	 */
	public void modifier(Integer id) {
		
		TypeVehicules typeVehicules = typeVehiculeDAO.getType(id);
		
		// On commence par créér le formulaire vide
		Form form = new Form();
		
		form.addInput(new TextField("Nom:", "nom", typeVehicules.getNom() ));
		form.addInput(new TextField("Tarif jour:", "tarifJour", Double.toString(typeVehicules.getTarifJour()) ));
		form.addInput(new TextField("Caution:", "caution", Double.toString(typeVehicules.getCaution()) ));
		
		FormTypesVehicules validator = new FormTypesVehicules();
		
		boolean valide = console.input("Modification du type " + typeVehicules.getNom(), form, validator);
		
		if (valide) {
			typeVehicules.setNom(form.getValue("nom"));
			typeVehicules.setTarifJour(Utils.parseDouble(form.getValue("tarifJour")) );
			typeVehicules.setCaution(Utils.parseDouble(form.getValue("caution")) );
			
			typeVehiculeDAO.editType(typeVehicules);
			traitement();
		}
		
		
	}
	
}
