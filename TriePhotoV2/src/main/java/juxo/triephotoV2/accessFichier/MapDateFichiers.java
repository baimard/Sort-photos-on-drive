package juxo.triephotoV2.accessFichier;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

import juxo.UiTriePhotoV2.UiQuestion;
import juxo.apiCalendar.Evenement;
import juxo.apiCalendar.Evenements;
import juxo.system.Parametrage;

public class MapDateFichiers extends HashMap<Calendar, Fichiers> {

	/**
	 * Default serial id
	 */
	private static final long serialVersionUID = 6L;

	/**
	 * Trie tous les fichiers en indiquant le nom du dossier de destination
	 * Les fichiers sont triés dans ANNEE/MOIS/NomDossierDestination
	 * @param nomDossier
	 */
	public void trieFichiers(String nomDossierDestination){
		for(Fichiers lesFichiers : this.values()){
			lesFichiers.deplacerTousLesFichier(nomDossierDestination);
		}
	}
	 
	public void trieFichiersDateJour(String nomDossierDestination){
		for(Fichiers lesFichiers : this.values()){
			lesFichiers.deplacerTousLesFichierDateJour(nomDossierDestination);
		}
	}
	
	/**
	 * Trie tous les fichiers qu'il peut par lieu de prise de vue
	 * Les fichiers sont triés dans ANNEE/MOIS/Lieu
	 * @param nomDossierDestination
	 */
	public void trieFichiersParLieu(String nomDossierDestination){
		ArrayList<Calendar> listeDesObjetsSupprimer = new ArrayList<Calendar>();
		Iterator<Calendar> it = this.keySet().iterator();
		while(it.hasNext()){
			Calendar maClefDeListe = it.next();
			Fichiers LesFichiers = Fichier.listFic.get(maClefDeListe);
			LesFichiers.deplacerTousLesFichiersParLieu(nomDossierDestination);
			if(LesFichiers.size()==0){
				listeDesObjetsSupprimer.add(maClefDeListe);
			}
		}
		supprimerDesEntrees(listeDesObjetsSupprimer);
	}
	
	/**
	 * Trie tous les fichiers qu'il peut par date d'événement
	 * Et nomme le dossier selon la date d'un événement
	 */
	public void trieFichiersParEvenement(String nomDossierDestination){
		Iterator<Calendar> it = this.keySet().iterator();
		ArrayList<Calendar> listeDesObjetsSupprimer = new ArrayList<Calendar>();
		while(it.hasNext()){
			Calendar maClefDeListe = it.next();
			Fichiers listFichier = Fichier.listFic.get(maClefDeListe);
			Evenements listEv = Evenement.searchDateEvenement(maClefDeListe);
			if(listEv!=null){
				SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
				UiQuestion ui = new UiQuestion(null, format1.format(maClefDeListe.getTime()), true, listEv, listFichier);
				Evenement evenement = ui.showUiQuestion();
				if(evenement!=null && !(evenement.nomEvenement.equals("aucun"))){
					listFichier.deplacerTousLesFichier(Parametrage.getInstance().getDossierDestination(), evenement.getNomPropre());
					listeDesObjetsSupprimer.add(maClefDeListe);
				}
			}
		}
		supprimerDesEntrees(listeDesObjetsSupprimer);
	}
	
	public void supprimerDesEntrees(ArrayList<Calendar> l){
		for(Calendar c : l){
			this.remove(c);
		}
	}
	
	public ArrayList<Fichier> getAllFichierItem(){
		ArrayList<Fichier> newList  = new ArrayList<Fichier>();
		for(Fichiers lesFichiers : this.values()){
			for(Fichier fic : lesFichiers){
				newList.add(fic);
			}
		}
		return newList;
	}
	
}
