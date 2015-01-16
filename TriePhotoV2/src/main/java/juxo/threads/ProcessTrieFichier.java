package juxo.threads;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import juxo.UiTriePhotoV2.UiQuestion;
import juxo.apiCalendar.Evenement;
import juxo.apiCalendar.Evenements;
import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.Fichiers;

public class ProcessTrieFichier extends Thread{
	private String Nwxdossier;
	private JList<String> logueur;
	private Evenements listEv = null;
	private Iterator<Calendar> mesClefsFichiers;
	
	public ProcessTrieFichier(String destinationDossier, JList<String> logueur){
		this.Nwxdossier = destinationDossier;
		this.logueur = logueur;
	}
	
	public void run() {
			DefaultListModel<String> model = (DefaultListModel<String>) logueur.getModel();
			model.add(0, "Démarrage du déplacement des fichiers ...");
			SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
			mesClefsFichiers = Fichier.listFic.keySet().iterator();
			while(mesClefsFichiers.hasNext()){
				Calendar keyCalendar = mesClefsFichiers.next();
				model.add(0, "Journée en cours d'analyse: " + format1.format(keyCalendar.getTime()));
				
				Fichiers listFile = Fichier.listFic.get(keyCalendar);

				listEv = Evenement.searchDateEvenement(keyCalendar);
				
				if(listEv != null){
					UiQuestion ui = new UiQuestion(null, format1.format(keyCalendar.getTime()), true, listEv, listFile);
					Evenement evenement = ui.showUiQuestion();
					if(evenement != null && evenement.nomEvenement.equals("aucun")){
						Evenement.evenements.remove(listEv.ownKey);
						listFile.deplacerTousLesFichier(Nwxdossier);
					}else{
						String nomDossier=evenement.getNomPropre();
						listFile.deplacerTousLesFichier(Nwxdossier, nomDossier);
					}
					
				}else{
					listFile.deplacerTousLesFichier(Nwxdossier);
				}
			}

			model.add(0, "Fin du trie");	
	  }				
}
