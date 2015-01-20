package juxo.notification;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.glassfish.jersey.message.internal.NewCookieProvider;
import javax.swing.*;

public class AfficherNotification {
	
	
	public static TrayIcon trayIcon1;
	
//	public NotificationListener(TrayIcon i){
	//	trayIcon1=i;
//	}
	
	  //Création de Listener
    NotificationListener nL = new NotificationListener();
    
    //private MenuItem defaultItem;
    private PopupMenu popup = new PopupMenu();
    private SystemTray tray = SystemTray.getSystemTray();
	
		public  AfficherNotification() throws IOException, AWTException {
			
			if (SystemTray.isSupported()) {
				
				 //Ajout d'un menu ï¿½ la trayIcon
				 MenuItem menu1 = new MenuItem("Quitter");
				 menu1.setActionCommand("Quitter");
				 
				 MenuItem menu2 = new MenuItem("toto");
				 
				//Crï¿½ation d'une image pour l'icone de notification
				BufferedImage imageBuffered= ImageIO.read(getClass().getResource("triephoto.png"));
				int trayIconWidth = new TrayIcon(imageBuffered).getSize().width;

				//Création de l'icone de notification
				trayIcon1 = new TrayIcon(imageBuffered.getScaledInstance(trayIconWidth, -1, Image.SCALE_SMOOTH), "Trie Photo", popup);
			    trayIcon1.setActionCommand("message");
			    trayIcon1.setImageAutoSize(true);
				
			//Ajout du menu ï¿½ l'icon de tray
			    popup.add(menu1);
			    popup.add(menu2);

			    //Ajout de l'action listener aux objets ï¿½coutï¿½
			    menu1.addActionListener(nL);
			    trayIcon1.addActionListener(nL);
			   
			    //ON ajoute ï¿½ la barre de tï¿½che notre icone
				tray.add(trayIcon1);
			}
			
	}
		public static  void  AfficherMsgNotification (String msg) {
			
		trayIcon1.displayMessage(msg,null, TrayIcon.MessageType.INFO);
				
			/*JFrame fenetre = new JFrame();
			JPanel panel = new JPanel();
	fenetre.setVisible(true);
	fenetre.setTitle("Message de notification");
	fenetre.setSize(200, 150);
	fenetre.setLocationRelativeTo(null);
	fenetre.getContentPane().add(panel);
	JLabel label =new JLabel(msg);
	JToolTip toolTip = label.createToolTip();
	toolTip.setTipText(msg);
	panel.add(label);*/
		}
	
}