package juxo.apiCalendar;

import java.util.Calendar;

/**
 * Objet qui est inséré comme clef dans la Map des événements
 * @author Juxo
 *
 */
public class clefMap {
	public Calendar debut;
	public Calendar fin;
	public int duree;
	
	/**
	 * Constructeur
	 * @param d
	 * @param f
	 * @param dureee
	 */
	public clefMap(Calendar d, Calendar f, int dureee){
		debut= d;
		fin=f;
		duree=dureee;
	}
	
}
