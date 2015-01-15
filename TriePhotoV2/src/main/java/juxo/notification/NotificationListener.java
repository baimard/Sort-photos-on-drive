package juxo.notification;

import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationListener implements ActionListener{
	private TrayIcon trayIcon1;
	
	public NotificationListener(TrayIcon i){
		trayIcon1=i;
	}
	
	
	

   public void actionPerformed(ActionEvent e) {
	   switch (e.getActionCommand()){
	   		case "message" :
	   			trayIcon1.displayMessage("Trie Photo disponible",null, TrayIcon.MessageType.INFO);
	   		break;
	   		case "Quitter" :
	   	        System.exit(0);
	   		break;
	   }
	   
	   
		

   }
}
