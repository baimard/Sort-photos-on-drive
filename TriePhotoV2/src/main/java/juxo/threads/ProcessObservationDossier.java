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

/**
 * Thread d'analyse des dossiers
 * @author Juxo
 *
 */
public class ProcessObservationDossier extends Thread {
	
	private static boolean execution;
	private static ProcessObservationDossier threadObservation;
	
	public ProcessObservationDossier(){
		execution = true;
		threadObservation=this;
	}
	
	public void run(){
		//Changement du nommage d'une ligne dans le menu
		AfficherNotification.AfficheNotif.menu2.setLabel("Arreter Observation");
		
		while (execution){
			try {
				AfficherNotification.AfficheNotif.TrayIconLoad();
				
				Parametrage p = Parametrage.getInstance();
				//réinitialisation de la liste de fichiers
				Fichier.listFic = new MapDateFichiers();
				Fichiers.generationListe(new Fichier(p.getDossierSource()));
				
				//Analyse des photos avec les méthodes de trie demandées par l'utilisateur
				if(Fichier.listFic.size()>0){
					AfficherNotification.AfficherMsgNotification(Fichier.listFic.getAllFichierItem().size() + " photos ont été trouvés");
					
					ArrayList<AbstractSortMethod> mySorts = p.getTabSortMethod();
					Collections.sort(mySorts, new ComparatorSortMethod());
					
					for(AbstractSortMethod s : mySorts){
						s.trie();
					}
				
				}
				
				AfficherNotification.AfficheNotif.TrayIconNormal();
				
				//Intervalle qui stop le thread d'analyse des dossiers pour voir s'il y a de nouvelles photos
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
