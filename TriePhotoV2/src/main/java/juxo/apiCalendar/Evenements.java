package juxo.apiCalendar;

import java.util.ArrayList;

public class Evenements extends ArrayList<Evenement>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Evenement evenementUtilisable;
	public clefMap ownKey;

	public Evenements(){
		super();
		evenementUtilisable = null;
	}
	
	public Evenement getDateUtilisable(){	
		return evenementUtilisable;
	}
	
	public void setDateUtilisable( Evenement e){
		evenementUtilisable = e;
	}
	

}
