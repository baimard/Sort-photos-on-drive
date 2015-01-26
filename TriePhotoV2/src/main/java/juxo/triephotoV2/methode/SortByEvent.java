package juxo.triephotoV2.methode;

import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

public class SortByEvent extends AbstractSortMethod {

	public SortByEvent(int p) {
		super(p);
	}
	
	@Override
	public void trie() {
		if(ConnexionGoogle.googleConnexion!=null){
			Fichier.listFic.trieFichiersParEvenement(Parametrage.getInstance().getDossierDestination());
		}
	}

}
