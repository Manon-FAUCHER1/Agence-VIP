/**
 * 
 */
package Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import Enumerations.StatusVehicules;

/**
 * @author manon
 *
 */
@Entity
public class Camions extends Vehicules {
	
	@Column(name = "Volume_camion")
	private double volume;
	
	///////// RELATIONS //////////////
	
	@ManyToOne
	@JoinColumn(name="Id_TypeVehicules")
	private TypeVehicules typeVehicule;
	
	////////// CONSTRUCTORS ///////////

	/**
	 * Empty Constructor
	 */
	public Camions() {}

	/**
	 * Constructor
	 * @param type
	 * @param volume
	 * @param typeVehicule
	 */
	public Camions(double volume, TypeVehicules typeVehicule) {
		super();
		this.volume = volume;
		this.typeVehicule = typeVehicule;
	}
	
	public Camions(String marque, String modele, String immatriculation, double kilometrage,
			StatusVehicules statusVehicule, String commentaire, double volume, TypeVehicules typeVehicule) {
		super(marque, modele, immatriculation, kilometrage, statusVehicule, commentaire);
		this.volume = volume;
		this.typeVehicule = typeVehicule;
	}
	
	////////// GETTERS & SETTERS ///////////

	/**
	 * Getter
	 * @return
	 */
	public double getVolume() {
		return volume;
	}

	/**
	 * Setter
	 * @param volume
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}

	/**
	 * Getter
	 * @return
	 */
	public TypeVehicules getTypeVehicule() {
		return typeVehicule;
	}

	/**
	 * Setter
	 * @param typeVehicule
	 */
	public void setTypeVehicule(TypeVehicules typeVehicule) {
		this.typeVehicule = typeVehicule;
	}
	
	/**
	 * Getter
	 * @return nbPlace
	 */
	public int getNbPlace() {
		return 3;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Camions [volume=" + volume + ", typeVehicule=" + typeVehicule + "]";
	}

	
	
	
	

}
