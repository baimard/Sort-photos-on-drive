package juxo.triephotoV2.methode;

import juxo.system.Parametrage;
import juxo.triephotoV2.accessFichier.Fichier;

/**
 * Trie de fichier par date du jour de prise de vue
 * @author Juxo
 *
 */
public class SortByDayDate extends AbstractSortMethod{
	
	private static SortByDayDate mySort;
	
	public SortByDayDate(){}
	
	public SortByDayDate(int p){
			super(p);
			mySort = this;
	}
	
	public void trie() {
		Fichier.listFic.trieFichiersDateJour(Parametrage.getInstance().getDossierDestination());
	}
	
	public static SortByDayDate getInstance(){
		return mySort;
	}

	
	public void loadMe() {
		mySort = this;
	}
	
}
