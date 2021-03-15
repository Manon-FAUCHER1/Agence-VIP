package Services.GestionReservations;

import java.util.List;

import javax.persistence.EntityManager;

import DAO.ReservationsDAO;
import DAO.TypeVehiculeDAO;
import DAO.VehiculesDAO;
import Entities.Reservations;
import Entities.Vehicules;
import Executable.Application;
import composants.MenuService;
import composants.Utils;

public class ListeReservationsEnCours extends MenuService {

	/** DAO **/
	private ReservationsDAO reservationsDao;

	
	/**
	 * Constructor
	 */
	public ListeReservationsEnCours() {
		EntityManager em = Application.emf.createEntityManager();

		reservationsDao = new ReservationsDAO(em);
	}


	@Override
	public void traitement() {
		List<Reservations> reservations = reservationsDao.selectCurrent();
		
		console.clear();
		console.println("<h1 class='bg-green'>Liste des vehicules</h1>");
		
		String html = "<table class='table' cellspacing=0>" + "<tr class='bg-green'>"
				+ "<td>&nbsp;</td>" + "<td>Numero de reservation</td>" + "<td>Vehicule</td>" + "<td>Clients</td>" + "<td>Date de debut</td>" + "<td>Commentaire</td>" + "</tr>";
		
		for (Reservations reservation : reservations) {
			html += "<tr>" 
					+ "<td>" + "<a class='btn-blue' href='cloreReservation(" + reservation.getId() + ")'><img width=25 src='images/pencil-blue-xs.png'></a>" + "</td>" 
					+ "<td width='150px'>" + reservation.getId() + "</td>" 
					+ "<td width='150px'>" + reservation.getVehicule() + "</td>" 
					+ "<td width='150px'>" + reservation.getClient() + "</td>"
					+ "<td width='150px'>" + reservation.getDateDebut() + "</td>"
					+ "<td width='150px'>" + reservation.getCommentaire() + "</td>"
					+ "</tr>";
		}
		html += "</table>";

		console.println(html);
		
	}
	
	

}
