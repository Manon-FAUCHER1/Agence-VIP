/**
 * 
 */
package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.TypeVehicules;
import Executable.Application;

/**
 * @author manon
 *
 */
public class TypeVehiculeDAO {
	
	private EntityManager em;
	
	/**
	 * Constructor
	 * @param em entity manager
	 */
	public TypeVehiculeDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	public List<TypeVehicules> selectAll() {
		
		TypedQuery<TypeVehicules> query = em.createQuery(
				"SELECT typeVehicules FROM TypeVehicules typeVehicules",
				TypeVehicules.class);
		List<TypeVehicules> typeVehicules = query.getResultList();
		
		return typeVehicules;
	}

	public void insert() {
		
	}

	public void editType() {
	}

}
