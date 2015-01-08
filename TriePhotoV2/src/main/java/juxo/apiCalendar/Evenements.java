package juxo.apiCalendar;

import java.util.ArrayList;

public class Evenements extends ArrayList<EvenementCalendrier>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EvenementCalendrier evenementUtilisable;
	public clefMap ownKey;

	public Evenements(){
		super();
		evenementUtilisable = null;
	}
	
	public EvenementCalendrier getDateUtilisable(){	
		return evenementUtilisable;
	}
	
	public void setDateUtilisable( EvenementCalendrier e){
		evenementUtilisable = e;
	}
	

}
