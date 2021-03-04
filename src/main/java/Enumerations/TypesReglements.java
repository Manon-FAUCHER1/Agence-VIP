/**
 * 
 */
package Enumerations;

import javax.persistence.Column;

/**
 * @author manon
 *
 */
public enum TypesReglements {
	
	CB("CARTE_BLEUE"),
	LIQUIDE("LIQUDE"),
	CHEQUE("CHEQUE");
	
	@Column(name = "Type_Reglement", nullable = false)
	private String typesReglements;

	////////// CONSTRUCTORS ///////////
	
	/**
	 * Empty Constructor
	 */
	private TypesReglements() {
	}

	/**
	 * Constructor
	 * @param typesReglements
	 */
	private TypesReglements(String typesReglements) {
		this.typesReglements = typesReglements;
	}
	
	////////// GETTERS & SETTERS ///////////

	public String getTypesReglements() {
		return typesReglements;
	}

	public void setTypesReglements(String typesReglements) {
		this.typesReglements = typesReglements;
	}
	
	
	
	

}
