package juxo.triephotoV2.methode;

import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

public class SortByPlace extends AbstractSortMethod {

	private static SortByPlace mySort;
	
	public SortByPlace(){
		
	}
	
	public SortByPlace(int p) {
		super(p);
		mySort = this;
	}

	@Override
	public void trie() {
		if(ConnexionGoogle.googleConnexion!=null){
			Fichier.listFic.trieFichiersParLieu(Parametrage.getInstance().getDossierDestination());
		}
	}

	public static SortByPlace getInstance(){
		return mySort;
	}
	
}
