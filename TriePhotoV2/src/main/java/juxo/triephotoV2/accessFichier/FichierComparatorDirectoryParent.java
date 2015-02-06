package juxo.triephotoV2.accessFichier;

import java.util.Comparator;

public class FichierComparatorDirectoryParent implements Comparator<Fichier>{

	public FichierComparatorDirectoryParent(){
		
	}
	
	public int compare(Fichier o1, Fichier o2) {
		return o1.getParentDirectory().compareTo(o2.getParentDirectory());
	}

}
