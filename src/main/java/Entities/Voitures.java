/**
 * 
 */
package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	public Voitures(Integer id, TypeVehicules type, int nbPlace, TypeVehicules typeVehicule) {
		super();
		this.nbPlace = nbPlace;
		this.typeVehicule = typeVehicule;
	}
	
	////////// GETTERS & SETTERS ///////////

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
	 * ToString
	 */
	@Override
	public String toString() {
		return "Voitures [nbPlace=" + nbPlace + ", typeVehicule=" + typeVehicule + "]";
	}

}
