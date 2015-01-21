package juxo.triephotoV2.accessFichier;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Fichiers extends ArrayList<Fichier>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private File[] listeFichiers;

	/***
	 * Création d'un objet fichiers avec sa liste de fichiers format String
	 * @param dossier
	 * @throws IOException
	 */
	public static void generationListe(Fichier dossier) throws IOException {
		listFichier(dossier.listFiles());
	}

	/**
	 * Déplace les fichiers de la liste dans le nouveau nom de dossier
	 * @param Nwxdossier
	 * @param nomDossier
	 */
	public void deplacerTousLesFichier(String Nwxdossier, String nomDossier){
		for(Fichier f : this){
			f.Deplacer(Nwxdossier, nomDossier);
		}
	}
	
	/**
	 * Déplace tous les fichiers sans indiquer de nouveau dossier
	 * Donc par ANNEES ET PAR MOIS
	 * @param Nwxdossier
	 */
	public void deplacerTousLesFichier(String Nwxdossier){
		for(Fichier f : this){
			f.Deplacer(Nwxdossier);
		}
	}
	
	
	/**
	 * Fontion de renommage des fichiers par date
	 * @param listeFichiers
	 */
	public static void renommerFichiersParDate(File[] listeFichiers){
		int it=1;
		//On parcours tous les fichiers
		for (File fichierCourant : listeFichiers) {
			if (fichierCourant.isFile()) {
				Fichier monfic = new Fichier(fichierCourant.getPath());
				monfic.renommerFichierParDate(it++);
			}
		}
	}
	
	/**
	 * Fontion de renommage des fichiers en fonction du lieu de prise de vue
	 * @param listeFichiers
	 */
	public void renommerFichiersParLieu(){
		int it=1;
		//On parcours tous les fichiers
		for (Fichier fichierCourant : this) {
			if (fichierCourant.isFile()) {
				fichierCourant.renommerFichierParLieu(it++);
			}
		}
	}
	
	/**
	 * Fontion de renommage des fichiers simple
	 * @param listeFichiers
	 * @param nom
	 */
	public static void renommerFichiers(File[] listeFichiers, String nom){
		int it=1;
		for (File fichierCourant : listeFichiers) {
			if (fichierCourant.isFile()) {
				Fichier monfic = new Fichier(fichierCourant.getPath());
				monfic.renommerFichier(nom, it++);
			}
		}
	}
	
	/***
	 * Trie des fichiers contenus dans un dossier
	 * On parcour le dossier sans se soucier de son arborescence
	 * @param Nwxdossier
	 * @throws IOException
	 */
	public static void listFichier(File[] listeFichiers) throws IOException {
		//On parcours tous les fichiers
		Fichier monfic = null;
		
		for (File fic : listeFichiers) {
			if(!(fic.isHidden()))
				monfic = new Fichier(fic.getPath());
			
			if (monfic!= null && monfic.isDirectory()){
				listFichier(monfic.listFiles());
			}

		}
	}
}
