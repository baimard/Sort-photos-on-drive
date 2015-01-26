package juxo.triephotoV2.methode;

import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

public class SortByPlace extends AbstractSortMethod {

	public SortByPlace(int p) {
		super(p);
	}

	@Override
	public void trie() {
		if(ConnexionGoogle.googleConnexion!=null){
			Fichier.listFic.trieFichiersParLieu(Parametrage.getInstance().getDossierDestination());
		}
	}

}
