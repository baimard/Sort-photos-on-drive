package juxo.notification;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AfficherNotification {
	
	
	public static TrayIcon trayIcon1;
    public NotificationListener nL = new NotificationListener();
    public MenuItem menu2;
    private PopupMenu popup = new PopupMenu();
    private SystemTray tray = SystemTray.getSystemTray();
    
    
    public static AfficherNotification myNotif;
	
		public  AfficherNotification() throws IOException, AWTException {
			myNotif=this;
			
			
			if (SystemTray.isSupported()) {
				
				 //Ajout d'un menu � la trayIcon
				 MenuItem menu1 = new MenuItem("Quitter");
				 menu1.setActionCommand("Quitter");
				 
				 menu2 = new MenuItem("Lancer observation du dossier");
				 menu2.setActionCommand("StoperThread");
				 
				 MenuItem menu3 = new MenuItem("Paramètre");
				 menu3.setActionCommand("param");
				 
				//Cr�ation d'une image pour l'icone de notification
				BufferedImage imageBuffered= ImageIO.read(getClass().getResource("triephoto.png"));
				int trayIconWidth = new TrayIcon(imageBuffered).getSize().width;

				//Cr�ation de l'icone de notification
				
				trayIcon1 = new TrayIcon(imageBuffered.getScaledInstance(trayIconWidth, -1, Image.SCALE_SMOOTH), "Trie Photo", popup);
			    trayIcon1.setActionCommand("message");
			    trayIcon1.setImageAutoSize(true);
				
			//Ajout du menu � l'icon de tray
			    popup.add(menu3);
			    popup.add(menu2);
			    popup.add(menu1);

			    //Ajout de l'action listener aux objets �cout�
			    menu1.addActionListener(nL);
			    menu2.addActionListener(nL);
			    menu3.addActionListener(nL);
			    trayIcon1.addActionListener(nL);
			   
			    //ON ajoute � la barre de t�che notre icone
				tray.add(trayIcon1);
			}
			
	}
		public static synchronized void  AfficherMsgNotification (String msg) {
			if(trayIcon1!=null)
				trayIcon1.displayMessage(msg,null, TrayIcon.MessageType.INFO);
		}
	
}