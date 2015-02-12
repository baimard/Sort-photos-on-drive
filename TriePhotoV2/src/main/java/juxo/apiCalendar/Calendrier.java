package juxo.apiCalendar;

import java.util.List;
import juxo.apiCalendar.definitionClasse.Items;
import juxo.apiCalendar.definitionClasse.MediaGroup;

public class Calendrier {

	private static Calendriers calendriers = new Calendriers();
	private String nomCalendrier;
	
	/**
	 * Constructeur par défaut pour la sérialisation
	 */
	public Calendrier(){}
	
	/**
	 * Constructeur d'un objet calendrier 
	 * qui sera ajouté à une liste globale automatiquement
	 * @param nomCalendrier
	 */
	public Calendrier(String nomCalendrier){
		this.nomCalendrier = nomCalendrier;
		calendriers.add(this);
	}
	
	
	/**
	 * Procédure statique permettant de construire chaque objet calendrier
	 * provenant d'une réponse de Type MediaGroup contenant une liste de calendrier.
	 * (Provient de l'objet connexionGoogle)
	 * @param m
	 */
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

	
	public static Calendriers getCalendriers() {
		return calendriers;
	}

	public static void setCalendriers(Calendriers calendriers) {
		Calendrier.calendriers = calendriers;
	}

	public String getNomCalendrier() {
		return nomCalendrier;
	}

	public void setNomCalendrier(String nomCalendrier) {
		this.nomCalendrier = nomCalendrier;
	}
	
}
