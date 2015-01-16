package juxo.threads;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import juxo.apiCalendar.Evenement;
import juxo.apiCalendar.Evenements;
import juxo.apiCalendar.clefMap;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.apiCalendar.definitionClasse.MediaGroup;

public class ProcessChargementEvenements extends Thread{
		
	private JList<String> jlab;
	private ArrayList<String> mesIdCalendrier;
	
	public ProcessChargementEvenements(ArrayList<String> l, JList<String> j){
		jlab = j;
		mesIdCalendrier = l;
	}
	
	public void run() {
		
			DefaultListModel<String> model = (DefaultListModel<String>) jlab.getModel();
			model.add(0, "Connexion Google ...");

	    	try{
	    		if(ConnexionGoogle.googleConnexion == null)
	    			ConnexionGoogle.googleConnexion = new ConnexionGoogle();
		    		
	    	}catch(IOException e){
	    		System.out.println(e);
	    	}catch(URISyntaxException e){
	    		System.out.println(e);
	    	}
	    	Evenement.evenements = new HashMap<clefMap, Evenements>();
	    	for(String cal : mesIdCalendrier){
	    		System.out.println(cal);
	    		MediaGroup m;
				try {
					m = ConnexionGoogle.googleConnexion.accessCalendrier(cal);
		    		if(m!=null)
		    			Evenement.chargementEvenement(m);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

	    	}
	    	
			model.add(0, "Connexion réussie :) - " + Evenement.evenements.size() + " d'événements trouvés");
			model.add(0, "Votre clef d'accès : " + ConnexionGoogle.googleConnexion.getToken().getTokenAcess());
	  }				
}
