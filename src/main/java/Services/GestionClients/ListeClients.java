/**
 * 
 */
package Services.GestionClients;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import DAO.ClientsDAO;
import Entities.Adresses;
import Entities.Clients;
import Entities.Permis;
import Executable.Application;
import composants.MenuService;
import composants.Utils;
import composants.ui.DateField;
import composants.ui.Form;
import composants.ui.TextField;



/**
 * @author manon
 *
 */
public class ListeClients extends MenuService {

	/** ClientDAO **/
	private ClientsDAO clientsDao;

	/**
	 * Constructor
	 */
	public ListeClients() {
		EntityManager em = Application.emf.createEntityManager();

		clientsDao = new ClientsDAO(em);
		clientsDao.init();
	}

	@Override
	public void traitement() {
		List<Clients> clients = clientsDao.selectAll();

		console.clear();
		console.println("<h1 class='bg-green'>Liste des clients</h1>");
		
		console.print("Ajouter un client",
				"<a class='btn-blue' href='ajouter()'><img width=25 src='images/plus-blue.png'></a>");

		String html = "<table class='table' cellspacing=0>" + "<tr class='bg-green'>" + "<td>&nbsp;</td>"
				+ "<td>&nbsp;</td>" + "<td>Clients</td>" + "</tr>";

		for (Clients client : clients) {
			html += "<tr>" 
					+ "<td>" + "<a class='btn-blue' href='modifier(" + client.getId() + ")'><img width=25 src='images/pencil-blue-xs.png'></a>" + "</td>" 
					+ "<td>" + "<a class='btn-red' href='supprimer(" + client.getId() + ")'><img width=25 src='images/trash-red-xs.png'></a>" + "</td>" 
					+ "<td width='150px'>" + client.getNom() + "</td>" 
					+ "<td width='150px'>" + client.getPrenom()  + "</td>" 
					+ "<td width='150px'>" + client.getTelephone() + "</td>"
					+ "<td width='150px'>" + client.getEmail() + "</td>"
					+ "<td width='150px'>" + client.getAdresse() + "</td>"
					+ "<td width='150px'>" + client.getPermis() + "</td>"
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
		form.addInput(new TextField("Prénom:", "prenom"));
		form.addInput(new TextField("Téléphone:", "telephone"));
		form.addInput(new TextField("Email:", "email"));
		
		form.addInput(new TextField("Numéro de Rue:", "numeroAdresse"));
		form.addInput(new TextField("Nom de Rue:", "rue"));
		form.addInput(new TextField("Code postal:", "codePostal"));
		form.addInput(new TextField("Ville:", "ville"));
		
		form.addInput(new TextField("Type du permis:", "TypePermis"));
		form.addInput(new TextField("Numero du permis:", "numPermis"));
		form.addInput(new DateField("Date d'obtention:", "dateObtention"));
		
		
		FormClientValidator formValidator = new FormClientValidator();
		boolean validation = console.input("Ajout d'une nouvelle personne", form, formValidator);
		if (validation) {
			
			Adresses nvAdresse = new Adresses(Utils.parseInteger(form.getValue("numeroAdresse")) , form.getValue("rue"), form.getValue("codePostal"), form.getValue("ville"));
			Permis nvpermis = new Permis(form.getValue("TypePermis"), form.getValue("numPermis"), Utils.parseDate(form.getValue("dateObtention")));
			Clients nvClient = new Clients(form.getValue("nom"), form.getValue("prenom"), form.getValue("telephone"), form.getValue("email"), nvAdresse, nvpermis);
			
			clientsDao.insert(nvClient);
			
			traitement();
		}
	}
	
	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone de modification
	 * dans la table des clients.
	 * 
	 * @param id identifiant du client à modifier.
	 */
	public void modifier(int id) {

		Clients client = clientsDao.getClient(id);
		Adresses adresses = client.getAdresse();
		Permis permis = client.getPermis();

		// On commence par créér le formulaire vide
		Form form = new Form();

		form.addInput(new TextField("Nom:", "nom", client.getNom() ));
		form.addInput(new TextField("Prénom:", "prenom", client.getPrenom() ));
		form.addInput(new TextField("Téléphone:", "telephone", client.getTelephone() ));
		form.addInput(new TextField("Email:", "email", client.getEmail() ));
		
		form.addInput(new TextField("Numéro de Rue:", "numeroAdresse", Integer.toString(adresses.getNumero()) ));
		form.addInput(new TextField("Nom de Rue:", "rue", adresses.getRue() ));
		form.addInput(new TextField("Code postal:", "codePostal", adresses.getCodePostal() ));
		form.addInput(new TextField("Ville:", "ville", adresses.getVille() ));
		
		form.addInput(new TextField("Type du permis:", "TypePermis", permis.getType() ));
		form.addInput(new TextField("Numero du permis:", "numPermis", permis.getNumero() ));
		form.addInput(new DateField("Date d'obtention:", "dateObtention", Utils.parseDateString(permis.getDateObtention()) ));
		
		// Les règles métier sont vérifiées dans le validator
		FormClientValidator validator = new FormClientValidator();

		boolean valide = console.input("Modification du client " + client.getPrenom() + " " + client.getNom(), form,
				validator);
		if (valide) {
			String nvNom = form.getValue("nom");
			String nvPrenom = form.getValue("prenom");
			String nvTelephone = form.getValue("telephone");
			String nvEmail = form.getValue("email");
			
			int nvNumRue = Utils.parseInteger(form.getValue("numeroAdresse"));
			String nvNomRue = form.getValue("rue");
			String nvCodePostal = form.getValue("codePostal");
			String nvVille = form.getValue("ville");
			
			String nvType = form.getValue("TypePermis");
			String nvNumPermis = form.getValue("numPermis");
			Date nvDateObtention = Utils.parseDate(form.getValue("dateObtention"));
			
			client.setNom(nvNom);
			client.setPrenom(nvPrenom);
			client.setTelephone(nvTelephone);
			client.setEmail(nvEmail);
			
			adresses.setNumero(nvNumRue);
			adresses.setRue(nvNomRue);
			adresses.setCodePostal(nvCodePostal);
			adresses.setVille(nvVille);
			client.setAdresse(adresses);
			
			permis.setType(nvType);
			permis.setNumero(nvNumPermis);
			permis.setDateObtention(nvDateObtention);
			client.setPermis(permis);			

			clientsDao.edit(client);

			traitement();
		}
	}
	
	/**
	 * Méthode appelée lorsque l'utilisateur clique sur une icone de suppression
	 * dans la table des clients
	 * 
	 * @param id identifiant du client à supprimer.
	 */
	public void supprimer(int id) {
		boolean result = console.confirm("Suppression de l'item " + id,
				"Confirmez-vous la suppression de l'item n°" + id);
		if (result) {
			clientsDao.delete(id);
			traitement();
		}
	}
	
	

}
