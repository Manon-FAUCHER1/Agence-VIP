/**
 * 
 */
package Executable;

import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingUtilities;



/**
 * @author manon
 *
 */
public class Launcher {
	
	public static final List<Boolean> holder = new LinkedList<Boolean>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// Création de la fenêtre principale
				final Application wnd = new Application("Application");
				wnd.buildInterfaceGraphique();
				// On passe les données à ce composant pour traitement ultérieur

				// On affiche la fenêtre au démarrage
				wnd.setVisible(true);
			}
		});
	}

}
