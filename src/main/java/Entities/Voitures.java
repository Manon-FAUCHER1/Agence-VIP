/**
 * 
 */
package Entities;

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
public class Voitures extends Vehicules {
	
	@Column(name = "Nombre_de_Place")
	private int nbPlace;
	
	///////// RELATIONS //////////////
	
	@ManyToOne
	@JoinColumn(name="Id_TypeVehicules")
	private TypeVehicules typeVehicule;
	
	////////// CONSTRUCTORS ///////////
	
	/**
	 * Empty Constructor
	 */
	public Voitures() {}

	/**
	 * Constructor
	 * @param id
	 * @param type
	 * @param nbPlace
	 * @param typeVehicule
	 */
	public Voitures(Integer id, int nbPlace, TypeVehicules typeVehicule) {
		super();
		this.nbPlace = nbPlace;
		this.typeVehicule = typeVehicule;
	}
	
	////////// GETTERS & SETTERS ///////////

	public Voitures(String marque, String modele, String immatriculation, double kilometrage,
			StatusVehicules statusVehicule, String commentaire, int nbPlace, TypeVehicules typeVehicule) {
		super(marque, modele, immatriculation, kilometrage, statusVehicule, commentaire);
		this.nbPlace = nbPlace;
		this.typeVehicule = typeVehicule;
	}

	/**
	 * Getter
	 * @return nbPlace
	 */
	public int getNbPlace() {
		return nbPlace;
	}

	/**
	 * Setter
	 * @param nbPlace
	 */
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	/**
	 * Getter
	 * @return typeVehicule
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
	 * @return volume
	 */
	public double getVolume() {
		return 0;
	}
	
	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Voitures [nbPlace=" + nbPlace + ", typeVehicule=" + typeVehicule + "]";
	}




}
