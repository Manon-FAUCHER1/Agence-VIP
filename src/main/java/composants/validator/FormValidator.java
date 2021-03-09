package composants.validator;

import composants.Console;
import composants.ui.Form;

/** validateur de formulaire
 * @author rbonn
 *
 */
public abstract class FormValidator {
	
	/** Console pour générer l'alerte */
	protected Console console = new Console();

	/** Méthode qui valide le formulaire et retourne true ou false
	 * @param form formulaire
	 * @return boolean
	 */
	public abstract boolean validate(Form form);
}
