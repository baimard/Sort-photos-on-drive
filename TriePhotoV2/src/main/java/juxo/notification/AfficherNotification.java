package juxo.notification;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AfficherNotification {
	
		public void notification() {
			
	
			
			// On verifie que le support de la figure du SystemTray est compatible avec l'OS hot
			if (SystemTray.isSupported()) {
				// Notre icone dans la barre systeme
				final TrayIcon trayIcon ; 
				 
			    SystemTray tray = SystemTray.getSystemTray();
			    
			    // On recupere l'image qui nous servira d'icone
	            Image image = Toolkit.getDefaultToolkit().getImage("triephoto.gif"); 
	            // Notre menu (clic droit sur l'icone systray)
			    PopupMenu popup = new PopupMenu();
			    MenuItem defaultItem = new MenuItem("Quitter");
			    
			    	defaultItem.addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			            System.exit(0);
			        }
			    	});
			    	
			    popup.add(defaultItem);
			    // Creation de l'icone systray
			    trayIcon = new TrayIcon(image, "Trie Photo", popup); 

			    		ActionListener actionListener = new ActionListener() {
			    		public void actionPerformed(ActionEvent e) {
			    			trayIcon.displayMessage("Trie Photo disponible",
			             null, TrayIcon.MessageType.INFO);
			    		}
			    		};
			    trayIcon.setImageAutoSize(true);
			    trayIcon.addActionListener(actionListener);
			    
				    	try {
				    		tray.add(trayIcon);} 
				    	catch (AWTException e) {
				        e.printStackTrace();
				    	}

			} else {
				// ...
			}
		
	}
}