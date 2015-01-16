package juxo.notification;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AfficherNotification {
	
    private NotificationListener nL;
    //private MenuItem defaultItem;
    private PopupMenu popup = new PopupMenu();
    private SystemTray tray = SystemTray.getSystemTray();
	
		public  AfficherNotification() throws IOException, AWTException {
			
			if (SystemTray.isSupported()) {
				
				 //Ajout d'un menu � la trayIcon
				 MenuItem menu1 = new MenuItem("Quitter");
				 menu1.setActionCommand("Quitter");
				 
				 MenuItem menu2 = new MenuItem("toto");
				 
				//Cr�ation d'une image pour l'icone de notification
				BufferedImage imageBuffered= ImageIO.read(getClass().getResource("triephoto.png"));
				int trayIconWidth = new TrayIcon(imageBuffered).getSize().width;
				
				//Cr�ation de l'icone de notification
			    final TrayIcon trayIcon1 = new TrayIcon(imageBuffered.getScaledInstance(trayIconWidth, -1, Image.SCALE_SMOOTH), "Trie Photo", popup);
			    trayIcon1.setActionCommand("message");
			    trayIcon1.setImageAutoSize(true);
			    
			    //Cr�ation de Listener
				nL = new NotificationListener(trayIcon1);
				
				//Ajout du menu � l'icon de tray
			    popup.add(menu1);
			    popup.add(menu2);

			    //Ajout de l'action listener aux objets �cout�
			    menu1.addActionListener(nL);
			    trayIcon1.addActionListener(nL);
			   
			    //ON ajoute � la barre de t�che notre icone
				tray.add(trayIcon1);
			}
			
	}
		public void AfficherMsgNotification (String msg) {
			
		}
}