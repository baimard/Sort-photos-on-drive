package juxo.threads;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

import juxo.apiCalendar.Calendrier;
import juxo.apiCalendar.EvenementCalendrier;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;

public class ProcessChargementCalendriers extends Thread{
		
	private JList<String> jlab;
	private JTextArea textAreaCalendrier;
	
	public ProcessChargementCalendriers(JList<String> j, JTextArea t){
		jlab = j;
		textAreaCalendrier = t;
		
	}
	
	public void run() {
		
			DefaultListModel<String> model = (DefaultListModel<String>) jlab.getModel();
			model.add(0, "Connexion Google ...");

	    	try{
	    		if(ConnexionGoogle.googleConnexion == null)
	    			ConnexionGoogle.googleConnexion = new ConnexionGoogle("125768752842-8kgilik6k7ucmbhph49kqoia3bum3pqr.apps.googleusercontent.com", "oKcIMqOmQKDIuT8_Xhw9SKBE");
		    		
	    	}catch(IOException e){
	    		System.out.println(e);
	    	}catch(URISyntaxException e){
	    		System.out.println(e);
	    	}
	    	
	    	Calendrier.calendriers = new ArrayList<Calendrier>();
	    	textAreaCalendrier.setText("");
	    	Calendrier.chargementCalendriers(
	    			ConnexionGoogle.googleConnexion.accessListCalendrier());
	    	for(Calendrier c : Calendrier.calendriers){
	    		textAreaCalendrier.setText(c.nomCalendrier + ";\r\n" + textAreaCalendrier.getText() );
	    	}
	    	
			model.add(0, "Votre clef d'accès : " + ConnexionGoogle.googleConnexion.token.getToken());
	  }				
}
