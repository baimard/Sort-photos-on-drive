package juxo.triephotoV2.methode;

import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

public class SortByDayDate extends AbstractSortMethod{
	
	public SortByDayDate(int p){
			super(p);
	}
	public void trie() {
		Fichier.listFic.trieFichiersDateJour(Parametrage.getInstance().getDossierDestination());
	}

	
}
