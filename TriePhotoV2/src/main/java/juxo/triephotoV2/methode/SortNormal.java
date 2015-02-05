package juxo.triephotoV2.methode;

import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

public class SortNormal extends AbstractSortMethod {

	private static SortNormal mySort;
	
	public SortNormal(int p) {
		super(p);
		mySort = this;
	}

	@Override
	public void trie() {
		Fichier.listFic.trieFichiers(Parametrage.getInstance().getDossierDestination());
	}
	
	public SortNormal getInstance(){
		return mySort;
	}
	
}
