package juxo.threads;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

import juxo.apiCalendar.Calendrier;
import juxo.apiCalendar.Calendriers;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;


/**
 * N'est plus utilisé dans le projet courant
 * @author Juxo
 *
 */
public class ProcessChargementCalendriers extends Thread{
		
	private JList<String> jlab;
	private JTextArea textAreaCalendrier;
	
	public ProcessChargementCalendriers(JList<String> j, JTextArea t){
		jlab = j;
		textAreaCalendrier = t;
		
	}
	
	public void run() {
			//Afficher quelque chose dans Jlist dans l'interface graphique
			DefaultListModel<String> model = (DefaultListModel<String>) jlab.getModel();
			model.add(0, "Connexion Google ...");

			//Connexion google
	    	try{
	    		if(ConnexionGoogle.googleConnexion == null)
	    			ConnexionGoogle.googleConnexion = new ConnexionGoogle();
		    		
	    	}catch(IOException e){
	    		System.out.println(e);
	    	}catch(URISyntaxException e){
	    		System.out.println(e);
	    	}
	    	
	    	Calendrier.setCalendriers(new Calendriers());
	    	textAreaCalendrier.setText("");
	    	Calendrier.chargementCalendriers(
	    			ConnexionGoogle.googleConnexion.accessListCalendrier());
	    	for(Calendrier c : Calendrier.getCalendriers()){
	    		textAreaCalendrier.setText(c.getNomCalendrier() + ";\r\n" + textAreaCalendrier.getText() );
	    	}
	    	
			model.add(0, "Votre clef d'accès : " + ConnexionGoogle.googleConnexion.getToken().getTokenAcess());
	  }				
}
