package juxo.threads;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import juxo.UiTriePhotoV2.UiQuestion;
import juxo.apiCalendar.Evenement;
import juxo.apiCalendar.Evenements;
import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.Fichiers;
/**
 * N'est plus utilisé dans le projet courant
 * @author Juxo
 *
 */
public class ProcessTrieFichier extends Thread{
	private String Nwxdossier;
	private Evenements listEv = null;
	private Iterator<Calendar> mesClefsFichiers;
	
	public ProcessTrieFichier(String destinationDossier){
		this.Nwxdossier = destinationDossier;
	}
	
	public void run() {
		SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		mesClefsFichiers = Fichier.listFic.keySet().iterator();
		while(mesClefsFichiers.hasNext()){
			Calendar keyCalendar = mesClefsFichiers.next();
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

	 }				
}
