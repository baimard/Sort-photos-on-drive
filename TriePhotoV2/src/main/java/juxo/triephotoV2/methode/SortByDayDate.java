package juxo.triephotoV2.methode;

import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

public class SortByDayDate extends AbstractSortMethod{
	
	private static SortByDayDate mySort;
	
	public SortByDayDate(int p){
			super(p);
			mySort = this;
	}
	public void trie() {
		Fichier.listFic.trieFichiersDateJour(Parametrage.getInstance().getDossierDestination());
	}
	
	public SortByDayDate getInstance(){
		return mySort;
	}
	
}
