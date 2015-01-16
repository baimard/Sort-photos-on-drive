package juxo.apiCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import juxo.apiCalendar.definitionClasse.Items;
import juxo.apiCalendar.definitionClasse.MediaGroup;

/**
 * Permet de lister des événements
 * @author Juxo
 *
 */
public class Evenement {
	
	/**
	 * Liste des événements
	 */
	public static Map<clefMap, Evenements> evenements = new HashMap<clefMap, Evenements>();
	
	public String nomEvenement;
	public Calendar dateEvenement;
	public Calendar dateFin;
	public int duree;
	public boolean utilisable;
	public int	attended;
	
	/**
	 * Création d'un événement
	 * L'événement est automatiquement ajouté à la list static d'événements
	 * @param e
	 * @param d
	 */
	public Evenement(String e, Date debut, Date fin){
		
		nomEvenement = e;
		dateEvenement = Calendar.getInstance();
		dateEvenement.setTime(debut);
		dateFin = Calendar.getInstance();
		dateFin.setTime(fin);
		duree = fin.compareTo(debut);
		
		utilisable=false;
		Evenements ev = searchDateEvenement(dateEvenement);
		if(ev!=null){
			ev.add(this);
		}else{
			ev = new Evenements();
			ev.add(this);
			clefMap clef = new clefMap(dateEvenement,dateFin,duree);
			ev.ownKey = clef;
			evenements.put(clef, ev);
		}
	}
	
	/***
	 * affichage du nom d'un événement avec épuration du string nom
	 * Pour pouvoir créer un dossier par exemple
	 */
	public String toString(){
		return nomEvenement;
	}
	
	/**
	 * Méthode permettant de rechercher une liste d'événement pour une date
	 * @param d
	 * @return
	 */
	public static Evenements searchDateEvenement(Calendar d){
		
		Iterator<clefMap> it = evenements.keySet().iterator();
		boolean trouve = false;
		Evenements event = null;
		
		while(it.hasNext() && !trouve){
			clefMap key = (clefMap) it.next();
			Calendar debut = key.debut;
			Calendar fin = key.fin;
			
			if((d.get(Calendar.DAY_OF_MONTH)==debut.get(Calendar.DAY_OF_MONTH)
					&& d.get(Calendar.MONTH)==debut.get(Calendar.MONTH)
					&& d.get(Calendar.YEAR)==debut.get(Calendar.YEAR))
					||
				(d.get(Calendar.DAY_OF_MONTH)>=debut.get(Calendar.DAY_OF_MONTH)
				&& d.get(Calendar.DAY_OF_MONTH)<=fin.get(Calendar.DAY_OF_MONTH)
				&& d.get(Calendar.MONTH)>=debut.get(Calendar.MONTH)
				&& d.get(Calendar.MONTH)<=fin.get(Calendar.MONTH)
				&& d.get(Calendar.YEAR)>=debut.get(Calendar.YEAR)
				&& d.get(Calendar.YEAR)<=fin.get(Calendar.YEAR)
			)){
				trouve = true;
				event = evenements.get(key);
			}
		}
		
		return event;
	}
	
	/**
	 * Méthode permettant de transformer une liste de MediaGroup en EvenementCalendrier
	 * (Obtenu par l'api de Google (voir ConnexionGoogle))
	 * @param m
	 */
	public static void chargementEvenement(MediaGroup m){
    	List<Items> mylist = m.items;
		for( Items i : mylist){
			try{
				new Evenement(i.summary, i.getStart().getRealDate(), i.getEnd().getRealDate());
			}catch(NullPointerException e){
				System.out.println("C'est pas grave ... : " + e);
			}
		}
	}
	
	/**
	 * Utilisation du nom de l'événement pour les dossiers
	 * @return
	 */
	public String getNomPropre(){
		String propre = nomEvenement.replaceAll("\\W", " ");
		if (propre.length() >30){
			String prop2 =  propre.substring(0, 30);
			propre = prop2;
		}
		return propre;
	}
	

}
