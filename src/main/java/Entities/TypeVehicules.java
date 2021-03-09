/**
 * 
 */
package Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import composants.ui.Selectable;

/**
 * @author manon
 *
 */
@Entity
public class TypeVehicules implements Selectable {
	
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Nom", nullable = false)
	private String nom;
	
	@Column(name = "Tarif_Jour", nullable = false)
	private double tarifJour;
	
	@Column(name = "Caution", nullable = false)
	private double caution;
	
	///////// RELATIONS //////////////
	
	@OneToMany(mappedBy="typeVehicule")
	private List<Voitures> voitures;
	
	@OneToMany(mappedBy="typeVehicule")
	private List<Camions> camions;
	
	////////// CONSTRUCTORS ///////////

	/**
	 * Empty Constructor
	 */
	public TypeVehicules() {}

	/**
	 * Constructor
	 * @param id
	 * @param nom
	 * @param tarifJour
	 * @param caution
	 * @param voitures
	 * @param camions
	 */
	public TypeVehicules(Integer id, String nom, double tarifJour, double caution, List<Voitures> voitures,
			List<Entities.Camions> camions) {
		super();
		this.id = id;
		this.nom = nom;
		this.tarifJour = tarifJour;
		this.caution = caution;
		this.voitures = voitures;
		this.camions = camions;
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
	 * @return tarifJour
	 */
	public double getTarifJour() {
		return tarifJour;
	}

	/**
	 * Setter
	 * @param tarifJour
	 */
	public void setTarifJour(double tarifJour) {
		this.tarifJour = tarifJour;
	}

	/**
	 * Getter
	 * @return caution
	 */
	public double getCaution() {
		return caution;
	}

	/**
	 * Setter
	 * @param caution
	 */
	public void setCaution(double caution) {
		this.caution = caution;
	}

	/**
	 * Getter
	 * @return voitures
	 */
	public List<Voitures> getVoitures() {
		return voitures;
	}

	/**
	 * Setter
	 * @param voitures
	 */
	public void setVoitures(List<Voitures> voitures) {
		this.voitures = voitures;
	}

	/**
	 * Getter
	 * @return camions
	 */
	public List<Camions> getCamions() {
		return camions;
	}

	/**
	 * Setter
	 * @param camions
	 */
	public void setCamions(List<Camions> camions) {
		this.camions = camions;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "TypeVehicules [id=" + id + ", nom=" + nom + ", tarifJour=" + tarifJour + ", caution=" + caution
				+ ", voitures=" + voitures + ", Camions=" + camions + "]";
	}
	
	
	

}
