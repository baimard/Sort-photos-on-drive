package juxo.triephotoV2.accessFichier;

import java.util.ArrayList;

public class Fichiers extends ArrayList<Fichier>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
}
