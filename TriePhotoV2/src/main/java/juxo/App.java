package juxo;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URISyntaxException;

import juxo.UiTriePhotoV2.UiPremierDemarrage;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.notification.AfficherNotification;
import juxo.system.Parametrage;
import juxo.threads.ProcessObservationDossier;
import juxo.triephotoV2.methode.SortByEvent;
import juxo.triephotoV2.methode.SortByPlace;

public class App {
	public static void main(String[] args) throws IOException{
		try {
			System.setProperty("apple.awt.UIElement", "true");
			
			new AfficherNotification();
			Parametrage.chargerObjet();
			
			//Connexion Google
			ConnexionGoogle.chargerToken();
			if (ConnexionGoogle.token != null && ConnexionGoogle.connexionTest()) {
					new ConnexionGoogle();
			}else{
				AfficherNotification.AfficherMsgNotification("Pas de connexion à internet, fonction de trie désactivé");
				if(Parametrage.getInstance() != null){
					Parametrage.getInstance().getTabSortMethod().remove(
							SortByPlace.getInstance());
					Parametrage.getInstance().getTabSortMethod().remove(
							SortByEvent.getInstance());
				}
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
