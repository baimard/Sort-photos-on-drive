package juxo.triephotoV2.methode;

/**
 * Méthode abstraite pour la classification des fichiers
 * @author Juxo
 *
 */
public abstract class AbstractSortMethod {
	public int priorite;
	
	public AbstractSortMethod(){}
	public AbstractSortMethod(int p){priorite = p;}
	public void purge(){
		//TODO Vider les listes pour relancer un processus
	}
	public abstract void trie();
	/**
	 * Permet de créer les singletons à la suite d'une désérialisation
	 */
	public abstract void loadMe();
}
