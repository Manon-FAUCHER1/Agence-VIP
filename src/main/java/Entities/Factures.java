/**
 * 
 */
package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import Enumerations.StatusFactures;
import Enumerations.TypesReglements;

/**
 * @author manon
 *
 */
@Entity
public class Factures {
	
	@Id
	@Column(name = "Numero_Facture", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numeroFacture;
	
	@Column(name = "Coût", nullable = false)
	private double cout;
	
	@Enumerated(EnumType.STRING)
	private StatusFactures statusFacture; 
	
	@Enumerated(EnumType.STRING)
	private TypesReglements typeReglement;
	
	///////// RELATIONS /////////////
	
	@OneToOne
	@JoinColumn(name="Id_Reservations" )
	private Reservations reservation;
	
	////////// CONSTRUCTORS ///////////

	/**
	 * Empty Constructor
	 */
	public Factures() {}

	/**
	 * Constructor
	 * @param numeroFacture
	 * @param cout
	 * @param statusFacture
	 * @param typeReglement
	 * @param reservation
	 */
	public Factures(Integer numeroFacture, double cout, StatusFactures statusFacture, TypesReglements typeReglement,
			Reservations reservation) {
		super();
		this.numeroFacture = numeroFacture;
		this.cout = cout;
		this.statusFacture = statusFacture;
		this.typeReglement = typeReglement;
		this.reservation = reservation;
	}

	
	////////// GETTERS & SETTERS ///////////
	
	/**
	 * Getter
	 * @return numeroFacture
	 */
	public Integer getNumeroFacture() {
		return numeroFacture;
	}
	

	/**
	 * Setter
	 * @param numeroFacture
	 */
	public void setNumeroFacture(Integer numeroFacture) {
		this.numeroFacture = numeroFacture;
	}
	

	/**
	 * Getter
	 * @return cout
	 */
	public double getCout() {
		return cout;
	}
	

	/**
	 * Setter
	 * @param cout
	 */
	public void setCout(double cout) {
		this.cout = cout;
	}
	

	/**
	 * Getter
	 * @return statusFacture
	 */
	public StatusFactures getStatusFacture() {
		return statusFacture;
	}
	

	/**
	 * Setter
	 * @param statusFacture
	 */
	public void setStatusFacture(StatusFactures statusFacture) {
		this.statusFacture = statusFacture;
	}
	

	/**
	 * Getter
	 * @return typeReglement
	 */
	public TypesReglements getTypeReglement() {
		return typeReglement;
	}
	

	/**
	 * Setter
	 * @param typeReglement
	 */
	public void setTypeReglement(TypesReglements typeReglement) {
		this.typeReglement = typeReglement;
	}
	

	/**
	 * Getter
	 * @return reservation
	 */
	public Reservations getReservation() {
		return reservation;
	}
	

	/**
	 * Setter
	 * @param reservation
	 */
	public void setReservation(Reservations reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "Factures " + numeroFacture + ", cout=" + cout + ", statusFacture=" + statusFacture
				+ ", typeReglement=" + typeReglement + ", reservation=" + reservation + "]";
	}
	
	


	
	

}
