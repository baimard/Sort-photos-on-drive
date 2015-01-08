package juxo.threads;

import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;


public class ProcessGlobal extends Thread{
		
	private ArrayList<String> listeCalendrier;
	private JList<String> logueur;
	private String dossierAnalyse;
	private String destinationDossier;
	
	public ProcessGlobal(ArrayList<String> l, JList<String> logueur, String dossier, String destinationDossier){
		this.listeCalendrier =  l;
		this.logueur = logueur;
		this.dossierAnalyse=dossier;
		this.destinationDossier=destinationDossier;
	}
	
	public void run() {

		Thread tConnexionGoogle = new ProcessChargementEvenements(listeCalendrier, logueur);
		tConnexionGoogle.start();
		Thread tChargementFichier = new ProcessChargementFichier(dossierAnalyse, logueur);
		
		tChargementFichier.start();
		try {
			tConnexionGoogle.join();
			tChargementFichier.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Thread tTrieFichier = new ProcessTrieFichier(destinationDossier, logueur);
		tTrieFichier.start();
		DefaultListModel<String> model = (DefaultListModel<String>) logueur.getModel();
		model.add(0, "Fermeture des processus");
	}
}
