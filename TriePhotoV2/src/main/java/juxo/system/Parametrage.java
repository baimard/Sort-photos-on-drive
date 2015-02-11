package juxo.system;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import juxo.triephotoV2.methode.AbstractSortMethod;
import juxo.triephotoV2.methode.SortNormal;

public class Parametrage implements Serializable {

	private static final long serialVersionUID = 4L;
	public static String SEPARATOR;
	private static Parametrage PARAM;
	private String dossierSource;
	private String dossierDestination;
	private int intervalObservation;
	private boolean triDemarrage;

	public boolean isTriDemarrage() {
		return triDemarrage;
	}

	public void setTriDemarrage(boolean triDemarrage) {
		this.triDemarrage = triDemarrage;
	}

	private ArrayList<AbstractSortMethod> tabSortMethod;
	
	public Parametrage() {

	}

	public Parametrage(String dossierSource, String dossierDestination) {
		this.dossierSource = dossierSource;
		this.dossierDestination = dossierDestination;
		PARAM = this;
		this.intervalObservation=600000;
		tabSortMethod = new ArrayList<AbstractSortMethod>();
		tabSortMethod.add(new SortNormal(4));
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

	public ArrayList<AbstractSortMethod> getTabSortMethod() {
		return tabSortMethod;
	}

	public void setTabSortMethod(ArrayList<AbstractSortMethod> tabSortMethod) {
		this.tabSortMethod = tabSortMethod;
	}
	
	
	

}
