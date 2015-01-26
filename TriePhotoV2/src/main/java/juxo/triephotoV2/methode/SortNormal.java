package juxo.triephotoV2.methode;

import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

public class SortNormal extends AbstractSortMethod {

	public SortNormal(int p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void trie() {
		Fichier.listFic.trieFichiers(Parametrage.getInstance().getDossierDestination());
	}
	
}
