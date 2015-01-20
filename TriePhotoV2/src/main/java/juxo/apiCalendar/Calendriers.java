package juxo.apiCalendar;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import juxo.serialisation.XMLTools;

public class Calendriers extends ArrayList<Calendrier> implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

    public void enregistrerObjet(){
    	try{
    		XMLTools.encodeToFile( this, "calendriers");
    	} catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    public static void chargerCalendrier(){
    	try {
    		Calendriers c = (Calendriers) XMLTools.decodeFromFile("calendriers");
			Calendrier.setCalendriers(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
