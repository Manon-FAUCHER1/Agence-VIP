package Services.GestionReservations;

import java.util.List;

import javax.persistence.EntityManager;

import DAO.ReservationsDAO;
import DAO.TypeVehiculeDAO;
import DAO.VehiculesDAO;
import Entities.Reservations;
import Executable.Application;
import composants.MenuService;

public class ListeReservationsTerminee extends MenuService {

	/** DAO **/
	private ReservationsDAO reservationsDao;

	
	/**
	 * Constructor
	 */
	public ListeReservationsTerminee() {
		EntityManager em = Application.emf.createEntityManager();

		reservationsDao = new ReservationsDAO(em);
	}


	@Override
	public void traitement() {
		List<Reservations> reservations = reservationsDao.selectFinish();
		
		console.clear();
		console.println("<h1 class='bg-green'>Liste des vehicules</h1>");
		
		String html = "<table class='table' cellspacing=0>" + "<tr class='bg-green'>"
				+ "<td>Numero de reservation</td>" + "<td>Vehicule</td>" + "<td>Clients</td>" + "<td>Date de debut</td>" + "<td>Date de fin</td>" + "<td>Commentaire</td>" + "</tr>";
		
		for (Reservations reservation : reservations) {
			html += "<tr>" 
					+ "<td width='150px'>" + reservation.getId() + "</td>" 
					+ "<td width='150px'>" + reservation.getVehicule() + "</td>" 
					+ "<td width='150px'>" + reservation.getClient() + "</td>"
					+ "<td width='150px'>" + reservation.getDateDebut() + "</td>"
					+ "<td width='150px'>" + reservation.getDateFin() + "</td>"
					+ "<td width='150px'>" + reservation.getCommentaire() + "</td>"
					+ "</tr>";
		}
		html += "</table>";

		console.println(html);
		
	}
	
	

}
