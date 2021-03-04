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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author manon
 *
 */
@Entity
public class Maintenances {
	
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Date_de_Debut", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Column(name = "Date_de_Fin", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@Column(name = "Cout_Reparation", nullable = true)
	private double CoutReparation;
	
	///////// RELATIONS //////////////
	
	@ManyToOne
	@JoinColumn(name="Id_vehicule")
	private Vehicules vehicule;
	
	////////// CONSTRUCTORS ///////////

	/**
	 * Empty Constructor
	 */
	public Maintenances() {}

	/**
	 * Constructor
	 * @param id
	 * @param dateDebut
	 * @param dateFin
	 * @param coutReparation
	 * @param vehicule
	 */
	public Maintenances(Integer id, Date dateDebut, Date dateFin, double coutReparation, Vehicules vehicule) {
		super();
		this.id = id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		CoutReparation = coutReparation;
		this.vehicule = vehicule;
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
	 * @return dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * Setter
	 * @param dateFin
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Getter
	 * @return CoutReparation
	 */
	public double getCoutReparation() {
		return CoutReparation;
	}

	/**
	 * Setter
	 * @param coutReparation
	 */
	public void setCoutReparation(double coutReparation) {
		CoutReparation = coutReparation;
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
	 * ToString
	 */
	@Override
	public String toString() {
		return "Maintenances [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", CoutReparation="
				+ CoutReparation + ", vehicule=" + vehicule + "]";
	}
	
	
	
	
	
	

}
