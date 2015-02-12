package juxo.threads;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import juxo.notification.AfficherNotification;
import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.Fichiers;
import juxo.triephotoV2.accessFichier.MapDateFichiers;
import juxo.triephotoV2.methode.AbstractSortMethod;
import juxo.triephotoV2.methode.ComparatorSortMethod;

public class ProcessObservationDossier extends Thread {
	
	private static boolean execution;
	private static ProcessObservationDossier threadObservation;
	
	public ProcessObservationDossier(){
		execution = true;
		threadObservation=this;
	}
	
	public void run(){
		AfficherNotification.AfficheNotif.menu2.setLabel("Arreter Observation");
		while (execution){
			try {
				AfficherNotification.AfficheNotif.TrayIconLoad();
				Parametrage p = Parametrage.getInstance();
				Fichier.listFic = new MapDateFichiers();
				Fichiers.generationListe(new Fichier(p.getDossierSource()));
				AfficherNotification.AfficherMsgNotification(Fichier.listFic.size()+" Fichiers ont été trouvés");
				
				if(Fichier.listFic.size()>0){
					ArrayList<AbstractSortMethod> mySorts = p.getTabSortMethod();
					Collections.sort(mySorts, new ComparatorSortMethod());
					for(AbstractSortMethod s : mySorts){
						s.trie();
					}
				}
				AfficherNotification.AfficheNotif.TrayIconNormal();
				sleep(p.getIntervalObservation());
			} catch (InterruptedException e) {
				System.out.println(e);
			}catch(IOException e){
				System.out.println(e);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		AfficherNotification.AfficherMsgNotification("Écoute du dossier stoppée");
		threadObservation=null;
		AfficherNotification.AfficheNotif.menu2.setLabel("Lancer Observation");
	}
	
	public static void stopExecution(){
		execution=false;
	}
	
	public static ProcessObservationDossier getInstance(){
		return threadObservation;
	}
	
}
