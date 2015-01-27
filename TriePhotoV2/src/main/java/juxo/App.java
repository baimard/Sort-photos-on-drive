package juxo;

import java.awt.AWTException;
import java.io.IOException;


import juxo.UiTriePhotoV2.UiUser;
import juxo.notification.AfficherNotification;
import juxo.system.Parametrage;
import juxo.threads.ProcessObservationDossier;

public class App 
{
	public static void main( String[] args ) throws IOException
    {
		//new UiUser();

	try {
			new AfficherNotification();
			AfficherNotification.AfficherMsgNotification("Application Lancée");
			Parametrage.chargerObjet();
			if(Parametrage.getInstance() == null){
				//Ouvrir ici la fenêtre de premier démarrage et bloque l'écoute du thread d'observation
			}else{
				Thread t = new ProcessObservationDossier();
				t.start();
			}
			
			


			
		} catch (AWTException e) {
			e.printStackTrace();
		}
    }
}
