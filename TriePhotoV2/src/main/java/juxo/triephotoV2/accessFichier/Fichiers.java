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

	/***
	 * Création d'un objet fichiers avec sa liste de fichier format objet Fichier
	 * En fait le fichier est un dossier
	 * @param dossier
	 * @throws IOException
	 */
	/*public Fichiers(Fichier dossier) throws IOException {
		listeFichiers = dossier.listFiles();
	}

	public Fichiers() {
		listeFichiers = null;
	}*/

	public void deplacerTousLesFichier(String Nwxdossier, String nomDossier){
		for(Fichier f : this){
			f.Deplacer(Nwxdossier, nomDossier);
		}
	}
	
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
		int it=0;
		//On parcours tous les fichiers
		for (File fichierCourant : listeFichiers) {
			if (fichierCourant.isFile()) {
				Fichier monfic = new Fichier(fichierCourant.getPath());
				monfic.renommerFichierParDate(it++);
			}
		}
	}
	
	/**
	 * Fontion de renommage des fichiers par date
	 * @param listeFichiers
	 */
	public static void renommerFichiers(File[] listeFichiers){
		int it=0;
		String nom = "Nom fichier";
		/*@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir le nom d'un fichier :");
		String nom = sc.nextLine();
		System.out.println("Vous avez saisi : " + nom);*/
		//On parcours tous les fichiers
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
		for (File fic : listeFichiers) {
			Fichier monfic = new Fichier(fic.getPath());
			System.out.println(monfic);
			if (monfic.isDirectory()) {
				listFichier(monfic.listFiles());
			}

		}
	}
}
