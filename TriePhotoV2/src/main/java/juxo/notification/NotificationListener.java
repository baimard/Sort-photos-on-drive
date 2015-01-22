package juxo.notification;

import java.awt.AWTException;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import juxo.threads.ProcessObservationDossier;

public class NotificationListener implements ActionListener{

	
   public void actionPerformed(ActionEvent e) {
	
	   switch (e.getActionCommand()){
	   
	   		case "StoperThread" :
	   			ProcessObservationDossier.stopExecution();
			break;
			
	   		case "Quitter" :
	   	        System.exit(0);
	   		break;
	   }
	   
	   
		

   }
}
