package Services.GestionTypesVehicules;

import composants.ui.Form;
import composants.validator.FormValidator;

public class FormTypesVehicules extends FormValidator {

	@Override
	public boolean validate(Form form) {
		
		String nvNom = form.getValue("nom");
		String nvTarifJour = form.getValue("nom");
		String nvCaution = form.getValue("nom");
		
		if (nvNom.trim().isEmpty()) {
			console.alert("Le nom est obligatoire !");
			return false;
		}
		else if (nvTarifJour.trim().isEmpty()) {
			console.alert("Le montant du tarif jour est obligatoire !");
			return false;
		}
		else if (nvCaution.trim().isEmpty()) {
			console.alert("Le montant de la caution est obligatoire !");
			return false;
		}
		
		return true;
	}

}
