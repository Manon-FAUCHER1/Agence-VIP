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

/**
 * @author manon
 *
 */
@Entity
public class Societe {
	
	@Id
	@Column(name = "Id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Nom", nullable = false)
	private String nom;
	
	@Column(name = "Bilan_Comptable", nullable = false)
	private double bilanComptable;
	
	////////// CONSTRUCTORS ///////////
	
	@OneToMany(mappedBy="societe")
	private List<Vehicules> vehicules; 
	
	////////// CONSTRUCTORS ///////////
	
	/**
	 * Empty Constructor
	 */
	public Societe() {}

	/**
	 * Constructor
	 * @param id
	 * @param nom
	 * @param bilanComptable
	 */
	public Societe(Integer id, String nom, double bilanComptable) {
		super();
		this.id = id;
		this.nom = nom;
		this.bilanComptable = bilanComptable;
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
	 * @return bilanComptable
	 */
	public double getBilanComptable() {
		return bilanComptable;
	}

	/**
	 * Setter
	 * @param bilanComptable
	 */
	public void setBilanComptable(double bilanComptable) {
		this.bilanComptable = bilanComptable;
	}

	/**
	 * ToString
	 */
	@Override
	public String toString() {
		return "Societe [id=" + id + ", nom=" + nom + ", bilanComptable=" + bilanComptable + "]";
	}
	
	
	
	


}
