/*package juxo.triephotoV2.accessFichier;
import java.io.*;

public class Dossier {
	private String nom = "";
	private String path = "";
	private File[] listfichier;

	*//***
	 * Création d'un objet dossier avec sa liste de fichiers format String
	 * @param dossier
	 * @throws IOException
	 *//*
	public Dossier(String dossier) throws IOException {
		File mesfichier = new File(dossier);
		nom = (mesfichier.getName());
		path = (mesfichier.getPath());
		listfichier = mesfichier.listFiles();
	}

	*//***
	 * Création d'un objet dossier avec sa liste de fichier format objet Fichier
	 * En fait le fichier est un dossier
	 * @param dossier
	 * @throws IOException
	 *//*
	public Dossier(Fichier dossier) throws IOException {
		nom = (dossier.getName());
		path = (dossier.getPath());
		listfichier = dossier.listFiles();
	}

	*//***
	 * Trie des fichiers contenus dans un dossier
	 * On parcour le dossier sans se soucier de son arborescence
	 * @param Nwxdossier
	 * @throws IOException
	 *//*
	public void listFichier() throws IOException {
		//On parcour tous les fichiers
		for (File fic : listfichier) {
			Fichier monfic = new Fichier(fic.getPath());
			if (monfic.isDirectory()) {
				Dossier mondossier = new Dossier(monfic);
				mondossier.listFichier();
			}

		}
	}

	public String getname() {
		return nom;
	}

	public String getpath() {
		return path;
	}

}
*/