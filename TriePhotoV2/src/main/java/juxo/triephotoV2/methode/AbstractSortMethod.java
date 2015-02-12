package juxo.triephotoV2.methode;

public abstract class AbstractSortMethod {
	public int priorite;
	
	public AbstractSortMethod(){}
	
	public AbstractSortMethod(int p){priorite = p;}
	
	public void purge(){
		//Vider les listes pour relancer un processus
	}
	
	public abstract void trie();
	public abstract void loadMe();
}
