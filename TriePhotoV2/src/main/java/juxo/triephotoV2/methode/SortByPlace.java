package juxo.triephotoV2.methode;

import java.io.IOException;
import java.net.URISyntaxException;

import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

/**
 * trie par coordonnées GPS d'un fichier
 * @author Juxo
 *
 */
public class SortByPlace extends AbstractSortMethod {

	private static SortByPlace mySort;
	
	public SortByPlace(){}
	
	public SortByPlace(int p) {
		super(p);
		mySort = this;
	}

	@Override
	public void trie() {
		try {
			new ConnexionGoogle();
			if(ConnexionGoogle.googleConnexion!=null){
				Fichier.listFic.trieFichiersParLieu(Parametrage.getInstance().getDossierDestination());
			}
		} catch (IOException | URISyntaxException e) {
			System.out.println(e);
		}

	}

	public static SortByPlace getInstance(){
		return mySort;
	}
	public void loadMe() {
		mySort = this;
	}
	
}
