package juxo.notification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import juxo.UiTriePhotoV2.UiParametre;
import juxo.threads.ProcessObservationDossier;

public class NotificationListener implements ActionListener{

	
   public void actionPerformed(ActionEvent e) {
	
	   switch (e.getActionCommand()){
	   
	   		case "param":
	   			new UiParametre();
	   		break;	
	   		
	   		case "StoperThread" :
	   			if(ProcessObservationDossier.getInstance()!=null){
	   				ProcessObservationDossier.stopExecution();
	   			}else{
					Thread t = new ProcessObservationDossier();
					t.start();
	   			}

			break;
			
	   		case "Quitter" :
	   	        System.exit(0);
	   		break;
	   }
	   
	   
		

   }
}
