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

/**
 * Class permettant d'afficher une icone dans la zone de notification
 * @author Juxo
 *
 */
public class AfficherNotification {
	public static AfficherNotification AfficheNotif;
	public NotificationListener nL = new NotificationListener();
	public MenuItem menu2;
	private PopupMenu popup = new PopupMenu();
	private SystemTray tray = SystemTray.getSystemTray();
	public static TrayIcon trayIcon1;
	
	/**
	 * Constructeur qui affiche directement l'icone de notification
	 * @throws IOException
	 * @throws AWTException
	 */
	public AfficherNotification() throws IOException, AWTException {
		AfficheNotif = this;

		if (SystemTray.isSupported()) {

			// Ajout d'un menu à la trayIcon
			MenuItem menu1 = new MenuItem("Quitter");
			menu1.setActionCommand("Quitter");

			menu2 = new MenuItem("Lancer observation du dossier");
			menu2.setActionCommand("StoperThread");

			MenuItem menu3 = new MenuItem("Paramètre");
			menu3.setActionCommand("param");

			// Création d'une image pour l'icone de notification
			Image image = Toolkit.getDefaultToolkit().createImage(
					getClass().getResource("triephoto.png"));
			// Création de l'icone de notification
			trayIcon1 = new TrayIcon(image, "Tray Demo", popup);
			trayIcon1.setActionCommand("message");
			trayIcon1.setImageAutoSize(true);

			// Ajout du menu à l'icon de tray
			popup.add(menu3);
			popup.add(menu2);
			popup.add(menu1);

			// Ajout de l'action listener aux objets écoutés
			menu1.addActionListener(nL);
			menu2.addActionListener(nL);
			menu3.addActionListener(nL);
			trayIcon1.addActionListener(nL);

			// ON ajoute à la barre de tâche notre icone
			try {

				tray.add(trayIcon1);
			} catch (AWTException e) {
				System.err.println("TrayIcon could not be added.");
			}

		}

	}

	/**
	 * Si l'objet singleton trayIcon est instancié
	 * Cette méthode permet d'envoyer un messagede notification
	 * à partir de n'importe qu'elle classe
	 * @param msg
	 */
	public static synchronized void AfficherMsgNotification(String msg) {
		if (trayIcon1 != null && Parametrage.getInstance().isSeeNotification())
			trayIcon1.displayMessage(msg, "Message important", TrayIcon.MessageType.INFO);
	}
	
	/**
	 * Permet d'afficher une icone de notification de chargement
	 * @throws AWTException
	 */
	public synchronized void TrayIconLoad() throws AWTException{
		Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/load.png"));
		trayIcon1.setImage(image);
	}
	
	/**
	 * Permet d'afficher l'icone standard dans la zone de notification de l'application
	 * @throws AWTException
	 */
	public synchronized void TrayIconNormal() throws AWTException{
		Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("triephoto.png"));
		trayIcon1.setImage(image);
	}

}