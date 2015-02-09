package juxo.UiTriePhotoV2;

import juxo.system.Parametrage;

public class comboElement {

	public String title;
	public int interval;
	
	public comboElement(String t, int i){
		title = t;
		interval = i;
	}

	public String toString(){
		return title;
	}
	
	public void parametreInterval(){
		Parametrage p = Parametrage.getInstance();
		p.setIntervalObservation(interval);
	}
	
}
