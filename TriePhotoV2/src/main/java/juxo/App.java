package juxo;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import juxo.UiTriePhotoV2.UiPremierDemarrage;
import juxo.notification.AfficherNotification;
import juxo.system.Parametrage;
import juxo.threads.ProcessObservationDossier;
import juxo.triephotoV2.accessFichier.Fichier;

import com.apple.eawt.Application;

@SuppressWarnings("restriction")
public class App {
	public static void main(String[] args) throws IOException {
		Application application = Application.getApplication();
		Image icone = Toolkit.getDefaultToolkit().getImage(
				UiPremierDemarrage.class.getResource("Resource"
						+ Fichier.SEPARATOR + "icone-pioupiou.jpg"));
		application.setDockIconImage(icone);

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
