/**
 * 
 */
package Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import Enumerations.StatusVehicules;

/**
 * @author manon
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicules {
	
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Marque", nullable = false, length = 50)
	private String marque;
	
	@Column(name = "Modele", nullable = false, length = 50)
	private String modele;

	@Column(name = "Immatriculation", nullable = false, unique = true, length = 9)
	private String immatriculation;
	
	@Column(name = "Kilometrage", nullable = false)
	private double kilometrage;
	
	@Enumerated(EnumType.STRING)
	private StatusVehicules statusVehicule;
	
	@Column(name = "Commentaire", nullable = true, length = 255)
	private String commentaire;
	
	///////// RELATIONS //////////////
	
	@OneToMany(mappedBy="vehicule")
	private List<Reservations> reservations; 
	
	@OneToMany(mappedBy="vehicule")
	private List<Maintenances> maintenances; 
	
	@ManyToOne
	@JoinColumn(name="Id_societe")
	private Societe societe;
	
	////////// CONSTRUCTORS ///////////
	
	/**
	 * Empty Constructor
	 */
	public Vehicules() {}
	
	/**
	 * Constructor
	 * @param id
	 * @param marque
	 * @param modele
	 * @param immatriculation
	 * @param kilometrage
	 * @param statusVehicule
	 * @param commentaire
	 * @param reservations
	 * @param maintenances
	 * @param societe
	 */
	public Vehicules(String marque, String modele, String immatriculation, double kilometrage,
			StatusVehicules statusVehicule, List<Reservations> reservations,
			List<Maintenances> maintenances, Societe societe, String commentaire) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
		this.kilometrage = kilometrage;
		this.statusVehicule = statusVehicule;
		this.commentaire = commentaire;
		this.reservations = reservations;
		this.maintenances = maintenances;
		this.societe = societe;
	}
	
	
	
	public Vehicules(String marque, String modele, String immatriculation, double kilometrage,
			StatusVehicules statusVehicule, String commentaire) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
		this.kilometrage = kilometrage;
		this.statusVehicule = statusVehicule;
		this.commentaire = commentaire;
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
	 * @return marque
	 */ 
	public String getMarque() {
		return marque;
	}

	/**
	 * Setter
	 * @param marque
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * Getter
	 * @return modele
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * Setter
	 * @param modele
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 * Getter
	 * @return immatriculation
	 */
	public String getImmatriculation() {
		return immatriculation;
	}

	/**
	 * Setter
	 * @param immatriculation
	 */
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	/**
	 * Getter
	 * @return kilometrage
	 */
	public double getKilometrage() {
		return kilometrage;
	}

	/**
	 * Setter
	 * @param kilometrage
	 */
	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}

	/**
	 * Getter
	 * @return statusVehicule
	 */
	public StatusVehicules getStatusVehicule() {
		return statusVehicule;
	}

	/**
	 * Setter
	 * @param statusVehicule
	 */
	public void setStatusVehicule(StatusVehicules statusVehicule) {
		this.statusVehicule = statusVehicule;
	}

	/**
	 * Getter
	 * @return commentaire
	 */
	public String getCommentaire() {
		return commentaire;
	}

	/**
	 * Setter
	 * @param commentaire
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	/**
	 * Getter
	 * @return reservations
	 */
	public List<Reservations> getReservations() {
		return reservations;
	}

	/**
	 * Setter
	 * @param reservations
	 */
	public void setReservations(List<Reservations> reservations) {
		this.reservations = reservations;
	}

	/**
	 * Getter
	 * @return maintenances
	 */
	public List<Maintenances> getMaintenances() {
		return maintenances;
	}

	/**
	 * Setter
	 * @param maintenances
	 */
	public void setMaintenances(List<Maintenances> maintenances) {
		this.maintenances = maintenances;
	}

	/**
	 * Getter
	 * @return societe
	 */
	public Societe getSociete() {
		return societe;
	}

	/**
	 * Setter
	 * @param societe
	 */
	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	
	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Vehicules [id=" + id + ", marque=" + marque + ", modele=" + modele + ", immatriculation="
				+ immatriculation + ", kilometrage=" + kilometrage + ", statusVehicule=" + statusVehicule
				+ ", commentaire=" + commentaire + ", reservations=" + reservations + ", maintenances=" + maintenances
				+ ", societe=" + societe + "]";
	}
	
	public abstract double getVolume();
	public abstract int getNbPlace();
	public abstract TypeVehicules getTypeVehicule();


	
}
