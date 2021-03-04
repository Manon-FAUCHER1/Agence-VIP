package Utils;

import org.apache.commons.lang3.math.NumberUtils;


public class VerifUtils {

	/**
	 * @param String valeur
	 * @return
	 */
	public static double parseDouble(String valeur) {

		if (valeur.isEmpty()) {
			return 0.0;
		} else if (!NumberUtils.isDigits(valeur) || valeur.length() > 255) {
			return 0.0;
		} else {
			return Double.parseDouble(valeur);
		}
	}
	
	/**
	 * @param String valeur
	 * @return
	 */
	public static int parseInteger(String valeur) {
		
		if (valeur.isEmpty()) {
			return 0;
		} else {
			return Integer.parseInt(valeur);
		}
	}

	/**
	 * @param String valeur
	 * @return
	 */
	public static String verifString(String valeur) {

		if (valeur.isEmpty()) {
			return "La valeur ne peut pas etre null";
		} else {
			return valeur;
		}
	}
	
	public static String verifTelephone(String tel) {
		
		
		
		switch (tel) {
		case value:
			
			break;

		default:
			break;
		}
		
	}
	


}
