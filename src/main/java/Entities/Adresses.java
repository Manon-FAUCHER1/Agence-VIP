/**
 * 
 */
package Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author manon
 *
 */
@Embeddable
public class Adresses {
	
	@Column(name = "Numero_Adresse", nullable = false)
	private int numero;
	
	@Column(name = "Rue", nullable = false)
	private String rue;
	
	@Column(name = "Code_Postal", nullable = false)
	private String codePostal;
	
	@Column(name = "Ville", nullable = false)
	private String ville;
	
	////////// CONSTRUCTORS ///////////

	/**
	 * Empty Constructor
	 */
	public Adresses() {}
	
	/**
	 * Constructor
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param ville
	 */
	public Adresses(int numero, String rue, String codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	////////// GETTERS & SETTERS ///////////

	/**
	 * Getter
	 * @return numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Setter
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * Getter
	 * @return rue
	 */
	public String getRue() {
		return rue;
	}

	/**
	 * Setter
	 * @param rue
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}

	/**
	 * Getter
	 * @return codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}

	/**
	 * Setter
	 * @param codePostal
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter
	 * @return ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Adresse : " + numero + " " + rue + ", " + codePostal + " " + ville + "\n";
	}


	
	
	
}
