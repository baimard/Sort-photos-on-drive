package juxo.triephotoV2.methode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import juxo.apiCalendar.Calendrier;
import juxo.apiCalendar.Calendriers;
import juxo.apiCalendar.Evenement;
import juxo.apiCalendar.Evenements;
import juxo.apiCalendar.clefMap;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.apiCalendar.definitionClasse.Items;
import juxo.apiCalendar.definitionClasse.MediaGroup;
import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

/**
 * Trie les fichiers par date d'événement en comparant si un événement existe
 * dans un agenda google
 * 
 * @author Juxo
 *
 */
public class SortByEvent extends AbstractSortMethod {

	private static SortByEvent mySort;

	public SortByEvent() {
	}

	public SortByEvent(int p) {
		super(p);
		mySort = this;
	}

	public void trie() {
		try {
			new ConnexionGoogle();
		} catch (IOException | URISyntaxException e) {
			System.out.println(e);
		}
		getListCalendars();
		getListEvent();
		if (ConnexionGoogle.googleConnexion != null) {
			// Croisement des événements d'un calendrier avec les dates des
			// photos
			Fichier.listFic.trieFichiersParEvenement(Parametrage.getInstance()
					.getDossierDestination());
		}
	}

	public static SortByEvent getInstance() {
		return mySort;
	}

	/**
	 * Obtient la liste des calendriers attachés à un compte google
	 */
	public void getListCalendars() {
		Calendrier.setCalendriers(new Calendriers());
		if (ConnexionGoogle.googleConnexion.getToken().getExpirationDelay() != 0) {
			ConnexionGoogle c = ConnexionGoogle.googleConnexion;
			if (c != null) {
				MediaGroup m = c.accessListCalendrier();
				for (Items i : m.items) {
					new Calendrier(i.getId());
				}
			}
		}
	}

	/**
	 * Obtient la liste des événements des calendriers attachés à un compte
	 * google
	 */
	public void getListEvent() {
		try {
			if (ConnexionGoogle.googleConnexion == null)
				ConnexionGoogle.googleConnexion = new ConnexionGoogle();
			Evenement.evenements = new HashMap<clefMap, Evenements>();
			for (Calendrier cal : Calendrier.getCalendriers()) {
				MediaGroup m;
				m = ConnexionGoogle.googleConnexion.accessCalendrier(cal
						.getNomCalendrier());
				if (m != null)
					Evenement.chargementEvenement(m);
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (URISyntaxException e) {
			System.out.println(e);
		}
	}

	public void loadMe() {
		mySort = this;
	}
}
