package composants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import composants.error.ErrorManager;


public class Utils {

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
	 * @param valeur
	 * @return
	 */
	public static Date parseDate(String valeur) {
		SimpleDateFormat spDate = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			return spDate.parse(valeur);
		} catch (ParseException e) {
			ErrorManager.manage("Erreur de parsing", e);
		}
		
		return null;
	}
	
	public static String parseDateString(Date date) {
		String dateToStr = DateFormatUtils.format(date, "dd/MM/yyyy");
		return dateToStr;
		
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
	



}
