/**
 * 
 */
package Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author manon
 *
 */
@Embeddable
public class Permis {

	@Column(name = "Type", nullable = false)
	private String type;
	
	@Column(name = "Numero_Permis", nullable = false)
	private String numero;
	
	@Column(name = "Date_Obtention", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateObtention;
	
	////////// CONSTRUCTORS ///////////

	/**
	 * Empty Constructor
	 */
	public Permis() {}
	
	/**
	 * Constructor
	 * @param type
	 * @param numero
	 * @param dateObtention
	 */
	public Permis(String type, String numero, Date dateObtention) {
		super();
		this.type = type;
		this.numero = numero;
		this.dateObtention = dateObtention;
	}
	
	////////// GETTERS & SETTERS ///////////

	/**
	 * Getter
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Setter
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Getter
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Setter
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Getter
	 * @return dateObtention
	 */
	public Date getDateObtention() {
		return dateObtention;
	}

	/**
	 * Setter
	 * @param dateObtention
	 */
	public void setDateObtention(Date dateObtention) {
		this.dateObtention = dateObtention;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Type " + type 
				+ " Numero " + numero 
				+ ", Obtenue le " + dateObtention;
	}
	
	
	
}
