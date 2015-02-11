package juxo.threads;

import java.util.ArrayList;
import javax.swing.JList;

/**
 * Déprécié
 * @author Juxo
 *
 */
public class ProcessGlobal extends Thread{
		
	private ArrayList<String> listeCalendrier;
	private String destinationDossier;
	
	public ProcessGlobal(ArrayList<String> l, JList<String> logueur, String dossierAnalyse, String destinationDossier){
		this.listeCalendrier =  l;
		this.destinationDossier=destinationDossier;
	}
	
	public void run() {

		Thread tConnexionGoogle = new ProcessChargementEvenements(listeCalendrier);
		tConnexionGoogle.start();
		/*Thread tChargementFichier = new ProcessChargementFichier(sourceDossier);
		tChargementFichier.start();*/
		try {
			tConnexionGoogle.join();
		//	tChargementFichier.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread tTrieFichier = new ProcessTrieFichier(destinationDossier);
		tTrieFichier.start();
	}
}
