package juxo.notification;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.io.IOException;

import juxo.system.Parametrage;

public class AfficherNotification {

	public static TrayIcon trayIcon1;
	public static AfficherNotification AfficheNotif;
	public NotificationListener nL = new NotificationListener();
	public MenuItem menu2;
	private PopupMenu popup = new PopupMenu();
	private SystemTray tray = SystemTray.getSystemTray();

	public static AfficherNotification myNotif;

	public AfficherNotification() throws IOException, AWTException {
		AfficheNotif = this;
		myNotif = this;

		if (SystemTray.isSupported()) {

			// Ajout d'un menu � la trayIcon
			MenuItem menu1 = new MenuItem("Quitter");
			menu1.setActionCommand("Quitter");

			menu2 = new MenuItem("Lancer observation du dossier");
			menu2.setActionCommand("StoperThread");

			MenuItem menu3 = new MenuItem("Paramètre");
			menu3.setActionCommand("param");

			// Cr�ation d'une image pour l'icone de notification
			Image image = Toolkit.getDefaultToolkit().createImage(
					getClass().getResource("triephoto.png"));
			// Cr�ation de l'icone de notification
			trayIcon1 = new TrayIcon(image, "Tray Demo", popup);
			trayIcon1.setActionCommand("message");
			trayIcon1.setImageAutoSize(true);

			// Ajout du menu � l'icon de tray
			popup.add(menu3);
			popup.add(menu2);
			popup.add(menu1);

			// Ajout de l'action listener aux objets �cout�
			menu1.addActionListener(nL);
			menu2.addActionListener(nL);
			menu3.addActionListener(nL);
			trayIcon1.addActionListener(nL);

			// ON ajoute � la barre de t�che notre icone
			try {
				tray.add(trayIcon1);
			} catch (AWTException e) {
				System.err.println("TrayIcon could not be added.");
			}

		}

	}

	public static synchronized void AfficherMsgNotification(String msg) {
		if (trayIcon1 != null && Parametrage.getInstance().isSeeNotification())
			trayIcon1.displayMessage(msg, null, TrayIcon.MessageType.INFO);
	}
	
	public synchronized void TrayIconLoad() throws AWTException{
		Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/load.png"));
		trayIcon1.setImage(image);
	}
	
	public synchronized void TrayIconNormal() throws AWTException{
		Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("triephoto.png"));
		trayIcon1.setImage(image);
	}

}