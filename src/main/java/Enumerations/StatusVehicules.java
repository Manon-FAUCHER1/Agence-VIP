package Enumerations;

import javax.persistence.Column;

/**
 * @author manon
 *
 */
public enum StatusVehicules {
	
	DISPONIBLE("DISPONIBLE"),
	LOUE("LOUE"),
	EN_MAINTENANCE("EN MAINTENANCE");
	
	@Column(name = "Status_du_vehicule", nullable = false)
	private String StatusVehicule;
	
	////////// CONSTRUCTORS ///////////

	/**
	 * Empty Constructor
	 */
	private StatusVehicules() {}

	/**
	 * Constructor
	 * @param statusVehicule
	 */
	private StatusVehicules(String statusVehicule) {
		StatusVehicule = statusVehicule;
	}
	
	////////// GETTERS & SETTERS ///////////

	/**
	 * Getter
	 * @return StatusVehicule
	 */
	public String getStatusVehicule() {
		return StatusVehicule;
	}

	/**
	 * Setter
	 * @param statusVehicule
	 */
	public void setStatusVehicule(String statusVehicule) {
		StatusVehicule = statusVehicule;
	}
	
	public static StatusVehicules find(String value) {
		
		final StatusVehicules[] listeStatutVehicule = StatusVehicules.values();
		for (StatusVehicules status : listeStatutVehicule) {
			if (status.getStatusVehicule().equals(value.toUpperCase())) {
				return status;
			}
		}
		return null;
	}
	
	
	
	
	
	
	

}
