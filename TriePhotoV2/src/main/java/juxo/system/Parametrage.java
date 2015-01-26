package juxo.system;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import juxo.triephotoV2.methode.AbstractSortMethod;

public class Parametrage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	public static String SEPARATOR;
	private static Parametrage PARAM;

	private List<AbstractSortMethod> methodSort;
	private String dossierSource;
	private String dossierDestination;

	public Parametrage() {

	}

	public Parametrage(String dossierSource, String dossierDestination) {
		this.dossierSource = dossierSource;
		this.dossierDestination = dossierDestination;
		getPathSystem();
		PARAM = this;
		
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

	public String getOperatingSystem() {
		String strOSName = System.getProperty("os.name");
		return strOSName.toLowerCase().substring(0, 3);
	}

	public void  getPathSystem (){
		switch(getOperatingSystem()) {
			case "win":
				SEPARATOR="\\";
			break;
			case "mac":
				SEPARATOR="/";
			break;
			case "lin":
				SEPARATOR="/";
			break;
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

}
