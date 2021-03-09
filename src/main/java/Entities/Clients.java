/**
 * 
 */
package Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author manon
 *
 */
@Entity
public class Clients {
	
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Nom", nullable = false)
	private String nom;
	
	@Column(name = "Prenom", nullable = false)
	private String prenom;
	
	@Column(name = "Telephone", nullable = false, length = 10)
	private String telephone;
	
	@Column(name = "Email", nullable = false, unique = true)
	private String email;
	
	@Embedded
	private Adresses adresse;
	
	@Embedded
	private Permis permis;
	
	///////// RELATIONS //////////////
	
	@OneToMany(mappedBy="client")
	private List<Reservations> reservations; 
	
	////////// CONSTRUCTORS ///////////
	
	/**
	 * Empty Constructor
	 */
	public Clients() {}
	
	/**
	 * Constructor
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param telephone
	 * @param email
	 * @param adresse
	 * @param permis
	 * @param reservations
	 */
	public Clients(String nom, String prenom, String telephone, String email, Adresses adresse,
			Permis permis) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.adresse = adresse;
		this.permis = permis;
		this.reservations = new ArrayList<>();
	}
	
	////////// GETTERS & SETTERS ///////////
	
	/**
	 * Getter
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Setter
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter
	 * @return adresse
	 */
	public Adresses getAdresse() {
		return adresse;
	}

	/**
	 * Setter
	 * @param adresse
	 */
	public void setAdresse(Adresses adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter
	 * @return permis
	 */
	public Permis getPermis() {
		return permis;
	}

	/**
	 * Setter
	 * @param permis
	 */
	public void setPermis(Permis permis) {
		this.permis = permis;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Clients : " + nom + " " + prenom 
				+ "\nTelephone : " + telephone 
				+ "\nEmail : " + email 
				+ "\nAdresse=" + adresse 
				+ "\nPermis=" + permis;
	}
	
	

	
	
	
	

}
