package juxo.system;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import juxo.triephotoV2.methode.AbstractSortMethod;
import juxo.triephotoV2.methode.SortByDayDate;
import juxo.triephotoV2.methode.SortByEvent;
import juxo.triephotoV2.methode.SortByPlace;
import juxo.triephotoV2.methode.SortNormal;

public class Parametrage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	public static String SEPARATOR;
	private static Parametrage PARAM;
	private String dossierSource;
	private String dossierDestination;
	private int intervalObservation;

	private List<AbstractSortMethod> tabSortMethod;
	
	public Parametrage() {

	}

	public Parametrage(String dossierSource, String dossierDestination) {
		this.dossierSource = dossierSource;
		this.dossierDestination = dossierDestination;
		PARAM = this;
		this.intervalObservation=600000;
		tabSortMethod = new ArrayList<AbstractSortMethod>();
		tabSortMethod.add(new SortNormal(3));
	}

	public void addSortByDay(){
		tabSortMethod.add(new SortByDayDate(2));
	}
	
	public void delSortByDay(){
		tabSortMethod.remove(SortByDayDate.getInstance());
	}
	
	public void addSortByPlace(){
		tabSortMethod.add(new SortByPlace(1));
	}
	
	public void delSortByPlace(){
		tabSortMethod.remove(SortByPlace.getInstance());
	}
	
	public void addSortByEvent(){
		tabSortMethod.add(new SortByEvent(1));
	}
	
	public void delSortByEvent(){
		tabSortMethod.remove(SortByEvent.getInstance());
	}
	
	public static Parametrage getInstance() {
		return PARAM;
	}

	public void enregistrerObjet() {
		try {
			XMLToolsSerialisation.encodeToFile(this, "parametrage");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void setInstance(Parametrage p) {
		if (p != null) {
			PARAM = p;
		}
	}

	public static void chargerObjet() {
		Parametrage p;
		try {
			p = (Parametrage) XMLToolsSerialisation
					.decodeFromFile("parametrage");
			Parametrage.setInstance(p);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public String getDossierSource() {
		return dossierSource;
	}

	public void setDossierSource(String dossierSource) {
		this.dossierSource = dossierSource;
	}

	public String getDossierDestination() {
		return dossierDestination;
	}

	public void setDossierDestination(String dossierDestination) {
		this.dossierDestination = dossierDestination;
	}

	public static String getSEPARATOR() {
		return SEPARATOR;
	}

	public static void setSEPARATOR(String sEPARATOR) {
		SEPARATOR = sEPARATOR;
	}

	public static Parametrage getPARAM() {
		return PARAM;
	}

	public static void setPARAM(Parametrage pARAM) {
		PARAM = pARAM;
	}

	public int getIntervalObservation() {
		return intervalObservation;
	}

	public void setIntervalObservation(int intervalObservation) {
		this.intervalObservation = intervalObservation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<AbstractSortMethod> getTabSortMethod() {
		return tabSortMethod;
	}

	public void setTabSortMethod(List<AbstractSortMethod> tabSortMethod) {
		this.tabSortMethod = tabSortMethod;
	}
	
	
	

}
