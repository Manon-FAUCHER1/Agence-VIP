/**
 * 
 */
package Services.GestionClients;

import java.util.Date;

import composants.Utils;
import composants.ui.Form;
import composants.validator.FormValidator;

/**
 * @author manon
 *
 */
public class FormClientValidator extends FormValidator{

	@Override
	public boolean validate(Form form) {		
		String nvNom = form.getValue("nom");
		String nvPrenom = form.getValue("prenom");
		String nvTelephone = form.getValue("telephone");
		String nvEmail = form.getValue("email");
		
		String nvNumRue = form.getValue("numeroAdresse");
		String nvNomRue = form.getValue("rue");
		String nvCodePostal = form.getValue("codePostal");
		String nvVille = form.getValue("ville");
		
		String nvType = form.getValue("TypePermis");
		String nvNumPermis = form.getValue("numPermis");
		String nvDateObtention =form.getValue("dateObtention");
		
		if (nvNom.trim().isEmpty()) {
			console.alert("Le nom est obligatoire !");
			return false;
		}
		else if (nvPrenom.trim().isEmpty()) {
			console.alert("Le prénom est obligatoire !");
			return false;
		}
		else if (nvTelephone.trim().isEmpty()) {
			console.alert("Le numéro de téléphone est obligatoire !");
			return false;
		}
		else if (nvEmail.trim().isEmpty()) {
			console.alert("L'email est obligatoire !");
			return false;
		}
		else if (nvNumRue.trim().isEmpty()) {
			console.alert("Le numéro de rue est obligatoire !");
			return false;
		}
		else if (nvNomRue.trim().isEmpty()) {
			console.alert("Le nom de rue est obligatoire !");
			return false;
		}
		else if (nvCodePostal.trim().isEmpty()) {
			console.alert("Le code postal est obligatoire !");
			return false;
		}
		else if (nvVille.trim().isEmpty()) {
			console.alert("La ville est obligatoire !");
			return false;
		}
		else if (nvType.trim().isEmpty()) {
			console.alert("Le type du permis est obligatoire !");
			return false;
		}
		else if (nvNumPermis.trim().isEmpty()) {
			console.alert("Le numéro du permis est obligatoire !");
			return false;
		}
		else if (nvDateObtention.trim().isEmpty()) {
			console.alert("La date est obligatoire !");
			return false;
		}
		
		return true;
	}

}
