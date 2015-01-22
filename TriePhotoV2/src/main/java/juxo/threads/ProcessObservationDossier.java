package juxo.threads;

import java.io.IOException;
import juxo.notification.AfficherNotification;
import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.Fichiers;
import juxo.triephotoV2.accessFichier.MapDateFichiers;

public class ProcessObservationDossier extends Thread {
	
	private static boolean execution;
	
	public ProcessObservationDossier(){
		execution = true;
	}
	
	public void run(){
		Parametrage p = Parametrage.getInstance();
		
		while (execution){
			try {
				Fichier.listFic = new MapDateFichiers();
				Fichiers.generationListe(new Fichier(p.getDossierSource()));
				AfficherNotification.AfficherMsgNotification(Fichier.listFic.size()+" Fichiers ont été trouvés");
				sleep(60000);
			} catch (InterruptedException e) {
				System.out.println(e);
			}catch(IOException e){
				System.out.println(e);
			}
		}
		
		AfficherNotification.AfficherMsgNotification("Écoute du dossier stoppée");
	
	}
	
	public static void stopExecution(){
		execution=false;
	}
	
}
