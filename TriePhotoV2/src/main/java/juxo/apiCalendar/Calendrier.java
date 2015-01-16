package juxo.apiCalendar;

import java.util.List;
import juxo.apiCalendar.definitionClasse.Items;
import juxo.apiCalendar.definitionClasse.MediaGroup;

public class Calendrier {

	public static Calendriers calendriers = new Calendriers();
	public String nomCalendrier;
	
	
	public Calendrier(String nomCalendrier){
		this.nomCalendrier = nomCalendrier;
		calendriers.add(this);
	}
	
	public static void chargementCalendriers(MediaGroup m){
    	List<Items> mylist = m.items;
		for( Items i : mylist){
			try{
				new Calendrier(i.getId());
			}catch(NullPointerException e){
				System.out.println("C'est pas grave ... : " + e);
			}
		}
	}
	
}
