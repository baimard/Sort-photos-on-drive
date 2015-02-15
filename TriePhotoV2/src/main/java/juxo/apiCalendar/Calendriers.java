package juxo.apiCalendar;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import juxo.system.XMLToolsSerialisation;

/**
 * Objets de type liste surchargeant une ArrayList et qui est sérializable
 * @author Juxo
 *
 */
public class Calendriers extends ArrayList<Calendrier> implements Serializable  {
	private static final long serialVersionUID = 3L;

	
	/**
	 * Permet de sérialiser la liste des calendriers
	 */
    public void enregistrerObjet(){
    	try{
    		XMLToolsSerialisation.encodeToFile( this, "calendriers");
    	} catch(Exception e){
    		System.out.println(e);
    	}
    }
    
    /**
     * Permet de charger une liste de calendriers sérialisées
     */
    public static void chargerCalendrier(){
    	try {
    		Calendriers c = (Calendriers) XMLToolsSerialisation.decodeFromFile("calendriers");
			Calendrier.setCalendriers(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
