package juxo.triephotoV2.methode;

import java.util.Comparator;
/**
 * Permet de trier une liste de méthode de trie par ordre de priorité définit dans l'application
 * @author Juxo
 *
 */
public class ComparatorSortMethod implements Comparator<AbstractSortMethod>{

	public ComparatorSortMethod(){}
	
	public int compare(AbstractSortMethod o1, AbstractSortMethod o2) {
		Integer intO1 = new Integer(o1.priorite);
		Integer intO2 = new Integer(o2.priorite);
		return intO1.compareTo(intO2);
	}

}
