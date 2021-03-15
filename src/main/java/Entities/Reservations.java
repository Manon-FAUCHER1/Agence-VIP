/**
 * 
 */
package Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author manon
 *
 */
@Entity
public class Reservations {
	
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Date_Debut", nullable = false)
	private Date dateDebut;
	
	@Column(name = "Date_Fin", nullable = false)
	private Date datefin;
	
	@Column(name = "Commentaire", nullable = true)
	private String commentaire;
	
	///////// RELATIONS /////////////
	
	@ManyToOne
	@JoinColumn(name="Id_Vehicules")
	private Vehicules vehicule; 
	
	@ManyToOne
	@JoinColumn(name="Id_Clients")
	private Clients client; 
	
	////////// CONSTRUCTORS ///////////

	/**
	 * Empty Constructor
	 */
	public Reservations() {}
	
	/**
	 * Constructor
	 * @param id
	 * @param dateDebut
	 * @param date_fin
	 * @param commentaire
	 * @param vehicule
	 * @param client
	 */
	public Reservations(Integer id, Date dateDebut, Date date_fin, String commentaire, Vehicules vehicule,
			Clients client) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.datefin = date_fin;
		this.commentaire = commentaire;
		this.vehicule = vehicule;
		this.client = client;
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
	 * @return dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter
	 * @param dateDebut
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Getter
	 * @return date_fin
	 */
	public Date getDateFin() {
		return datefin;
	}

	/**
	 * Setter
	 * @param date_fin
	 */
	public void setDateFin(Date date_fin) {
		this.datefin = date_fin;
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
	 * @return vehicule
	 */
	public Vehicules getVehicule() {
		return vehicule;
	}

	/**
	 * Setter
	 * @param vehicule
	 */
	public void setVehicule(Vehicules vehicule) {
		this.vehicule = vehicule;
	}

	/**
	 * Getter
	 * @return client
	 */
	public Clients getClient() {
		return client;
	}

	/**
	 * Setter
	 * @param client
	 */
	public void setClient(Clients client) {
		this.client = client;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Reservations [id=" + id + ", dateDebut=" + dateDebut + ", date_fin=" + datefin + ", commentaire="
				+ commentaire + "]";
	}
	
	

	
	
	

}
