/**
 * 
 */
package Services.GestionVehicules;

import composants.ui.Form;
import composants.validator.FormValidator;

/**
 * @author manon
 *
 */
public class FormVehiculeValidator extends FormValidator {

	@Override
	public boolean validate(Form form) {
//		String nvMarque = form.getValue("marque");
//		String nvModele = form.getValue("modele");
//		String nvType = form.getValue("type");
//		String nvImmatriculation = form.getValue("immatriculation");
//		
//		if (nvMarque.trim().isEmpty()) {
//			console.alert("La marque est obligatoire !");
//			return false;
//		}
//		else if (nvModele.trim().isEmpty()) {
//			console.alert("Le modele est obligatoire !");
//			return false;
//		}
//		else if (nvType.trim().isEmpty()) {
//			console.alert("Le type est obligatoire !");
//			return false;
//		}
//		else if (nvImmatriculation.trim().isEmpty()) {
//			console.alert("L'immatriculation est obligatoire !");
//			return false;
//		}
		return true;
	}

	


}
