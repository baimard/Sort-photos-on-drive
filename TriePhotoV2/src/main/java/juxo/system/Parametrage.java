package juxo.system;

import java.io.IOException;
import java.io.Serializable;

public class Parametrage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;

	private static Parametrage param;
	
	

	private String dossierSource;
	private String dossierDestination;
	
	public Parametrage(){
		
	}
	
	public Parametrage(String dossierSource, String dossierDestination){
		this.dossierSource = dossierSource;
		this.dossierDestination = dossierDestination;
		param = this;
	}
	
	public static Parametrage getInstance(){
		return param;
	}
	
	
	public void enregistrerObjet(){
    	try{
    		XMLToolsSerialisation.encodeToFile( this, "parametrage");
    	} catch(Exception e){
    		System.out.println(e);
    	}
	}
	
	private static void setInstance(Parametrage p){
		if(p!=null){
			param = p;			
		}
	}
	
	public static void chargerObjet(){
		Parametrage p;
		try {
			p = (Parametrage) XMLToolsSerialisation.decodeFromFile("parametrage");
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
	
}

