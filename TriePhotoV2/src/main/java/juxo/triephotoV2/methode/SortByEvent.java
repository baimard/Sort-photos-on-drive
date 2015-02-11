package juxo.triephotoV2.methode;

import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

public class SortByEvent extends AbstractSortMethod {

	private static SortByEvent mySort;
	
	public SortByEvent(){
		
	}
	
	public SortByEvent(int p) {
		super(p);
		mySort = this;
	}
	
	@Override
	public void trie() {
		if(ConnexionGoogle.googleConnexion!=null){
			Fichier.listFic.trieFichiersParEvenement(Parametrage.getInstance().getDossierDestination());
		}
	}

	public static SortByEvent getInstance(){
		return mySort;
	}
	
}
