package juxo.threads;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import juxo.notification.AfficherNotification;
import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.Fichiers;

public class ProcessObservationDossier extends Thread {
	
	private static boolean execution;
	
	public ProcessObservationDossier(){
		execution = true;
	}
	
	public void run(){
		Parametrage p = Parametrage.getInstance();
		
		while (execution){
			try {
				Fichier.listFic = new HashMap<Calendar, Fichiers>();
				Fichier f = new Fichier(p.getDossierSource());
				Fichiers.generationListe(f);
				Map<Calendar, Fichiers> ff = Fichier.listFic;
				AfficherNotification.AfficherMsgNotification(ff.size()+" Fichiers ont été trouvés");
				sleep(10000);
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
