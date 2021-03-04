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
	
	private static EntityManager em = Application.emf.createEntityManager();
	
	public static List<TypeVehicules> selectAll() {
		
		TypedQuery<TypeVehicules> query = em.createQuery(
				"SELECT typeVehicules FROM TypeVehicules typeVehicules",
				TypeVehicules.class);
		List<TypeVehicules> typeVehicules = query.getResultList();
		
		return typeVehicules;
	}

	public static void insert() {
		
	}

	public static void editType() {
	}

}
