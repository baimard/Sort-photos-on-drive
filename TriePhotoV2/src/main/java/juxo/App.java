package juxo;

import java.awt.AWTException;
import java.io.IOException;

import juxo.UiTriePhotoV2.UiPremierDemarrage;
import juxo.notification.AfficherNotification;
import juxo.system.Parametrage;
import juxo.threads.ProcessObservationDossier;

public class App {
	public static void main(String[] args) throws IOException {
		
		try {
			new AfficherNotification();
			AfficherNotification.AfficherMsgNotification("Application Lancée");
			Parametrage.chargerObjet();
			if (Parametrage.getInstance() == null) {
				new Parametrage(null, null);
				new UiPremierDemarrage();
			} else {
				Thread t = new ProcessObservationDossier();
				t.start();
			}

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
