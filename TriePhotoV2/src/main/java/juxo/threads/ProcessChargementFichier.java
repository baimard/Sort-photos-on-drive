package juxo.threads;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.Fichiers;

public class ProcessChargementFichier extends Thread{
		
	private String dossierAnalyser;
	private JList<String> logueur;
	
	public ProcessChargementFichier(String m, JList<String> logueur){
		dossierAnalyser = m;
		this.logueur = logueur;
	}
	
	public void run() {

			try{
				DefaultListModel<String> model = (DefaultListModel<String>) logueur.getModel();
				model.add(0,"Chargement des dossiers ...");
				Fichier.listFic = new HashMap<Calendar, Fichiers>();
				Fichier f = new Fichier(dossierAnalyser);
				Fichiers.generationListe(f);
				model.add(0,"Fin de chargement de dossier : " + Fichier.listFic.size() + " Journée à analyser");
			}catch(IOException e){
				System.out.println(e);
			}
			System.out.println("stop");				
	  }				
}
