package juxo;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URISyntaxException;

import juxo.UiTriePhotoV2.UiPremierDemarrage;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.notification.AfficherNotification;
import juxo.system.Parametrage;
import juxo.threads.ProcessObservationDossier;

public class App {
	public static void main(String[] args) throws IOException {

		try {
			new AfficherNotification();
			Parametrage.chargerObjet();
			//Connexion Google
			ConnexionGoogle.chargerToken();
			if (ConnexionGoogle.token != null) {
				new ConnexionGoogle();
			}
			
			if (Parametrage.getInstance() == null) {
				new Parametrage(null, null);
				new UiPremierDemarrage();
			} else {
				Thread t = new ProcessObservationDossier();
				t.start();
			}

		} catch (AWTException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
