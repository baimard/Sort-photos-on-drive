package juxo.notification;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationListener implements ActionListener{

	
   public void actionPerformed(ActionEvent e) {
	
	   switch (e.getActionCommand()){
	   		case "message" :


			break;
			
	   		case "Quitter" :
	   	        System.exit(0);
	   		break;
	   }
	   
	 
		

   }
}
