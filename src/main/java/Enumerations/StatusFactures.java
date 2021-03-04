/**
 * 
 */
package Enumerations;

import javax.persistence.Column;

/**
 * @author manon
 *
 */
public enum StatusFactures {
	
	PAYER("PAYER"),
	NON_PAYER("NON PAYER");
	
	@Column(name = "Status_Facture", nullable = false)
	private String statusFactures;
	
	////////// CONSTRUCTORS ///////////

	/**
	 * Empty Constructor
	 */
	private StatusFactures() {}

	/**
	 * Constructor
	 * @param statusFactures
	 */
	private StatusFactures(String statusFactures) {
		this.statusFactures = statusFactures;
	}
	
	////////// GETTERS & SETTERS ///////////

	public String getStatusFactures() {
		return statusFactures;
	}

	public void setStatusFactures(String statusFactures) {
		this.statusFactures = statusFactures;
	}
	

	
	
	
	

}
