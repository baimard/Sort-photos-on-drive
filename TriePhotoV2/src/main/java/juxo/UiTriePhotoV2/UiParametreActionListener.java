package juxo.UiTriePhotoV2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Collections;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.system.Parametrage;
import juxo.system.XMLToolsSerialisation;
import juxo.threads.ProcessObservationDossier;
import juxo.triephotoV2.methode.ComparatorSortMethod;
import juxo.triephotoV2.methode.SortByDayDate;
import juxo.triephotoV2.methode.SortByEvent;
import juxo.triephotoV2.methode.SortByPlace;

public class UiParametreActionListener implements ActionListener {

	public UiParametreActionListener() {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "choixSource":
			JFileChooser jfS = new JFileChooser(new File("."));
			jfS.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (jfS.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File fichierS = jfS.getSelectedFile();
				UiParametre.f.source.setText(fichierS.getPath());
				Parametrage.getInstance().setDossierSource(fichierS.getPath());
				Parametrage.getInstance().enregistrerObjet();
			}
			break;

		case "choixCible":
			JFileChooser jfC = new JFileChooser(new File("."));
			jfC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (jfC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File fichierC = jfC.getSelectedFile();
				UiParametre.f.cible.setText(fichierC.getPath());
				Parametrage.getInstance().setDossierDestination(
						fichierC.getPath());
				Parametrage.getInstance().enregistrerObjet();
			}
			break;

		case "triDate":
			if (UiParametre.f.modeDate.isSelected()) {
				Parametrage.getInstance().getTabSortMethod()
						.add(new SortByDayDate(3));
			} else {
				Parametrage.getInstance().getTabSortMethod()
						.remove(SortByDayDate.getInstance());
			}
			Parametrage.getInstance().enregistrerObjet();
			break;

		case "triEvenement":
			if (ConnexionGoogle.googleConnexion != null) {
				if (UiParametre.f.modeEvenement.isSelected()) {
					Parametrage.getInstance().getTabSortMethod()
							.add(new SortByEvent(1));
				} else {
					Parametrage.getInstance().getTabSortMethod()
							.remove(SortByEvent.getInstance());
				}
				Parametrage.getInstance().enregistrerObjet();
			} else {
				UiParametre.f.modeEvenement.setSelected(false);
				JOptionPane.showMessageDialog(null,
						"Veuillez vous connecter à Google (Onglet Suivant)");
			}
			break;

		case "triLieu":
			if (ConnexionGoogle.googleConnexion != null) {
				if (UiParametre.f.modeLieu.isSelected()) {
					Parametrage.getInstance().getTabSortMethod()
							.add(new SortByPlace(2));
				} else {
					Parametrage.getInstance().getTabSortMethod()
							.remove(SortByPlace.getInstance());
				}
				Parametrage p = Parametrage.getInstance();
				Collections.sort(p.getTabSortMethod(),
						new ComparatorSortMethod());
				Parametrage.getInstance().enregistrerObjet();
			} else {
				UiParametre.f.modeLieu.setSelected(false);
				JOptionPane.showMessageDialog(null,
						"Veuillez vous connecter à Google (Onglet Suivant)");
			}
			break;

		case "choixFicRenom":
			JFileChooser jfR = new JFileChooser(new File("."));
			jfR.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (jfR.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File fichierR = jfR.getSelectedFile();
				UiParametre.f.selectDossierRenom.setText(fichierR.getPath());
			}
			break;

		case "renomParDate":

			break;

		case "renomParLieu":

			break;

		case "renomNomSpecifie":

			break;

		case "DemandeGoogle":
			try {
				new ConnexionGoogle();
				if (ConnexionGoogle.googleConnexion != null) {
					UiParametre.f.getCodAuthent().setEnabled(false);
					UiParametre.f.getReInitCode().setEnabled(true);
					UiParametre.f.getCodAuthent().setText("Vous êtes connecté");
				}
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		case "ReinitialisationGoogle":
			XMLToolsSerialisation.DeleteFile("token");
			ConnexionGoogle.googleConnexion = null;
			UiParametre.f.getCodAuthent().setEnabled(true);
			UiParametre.f.getReInitCode().setEnabled(false);
			UiParametre.f.getCodAuthent().setText("Vous connecter...");
			break;

		case "intervalActualisation":
			ComboIntervalTemps c = (ComboIntervalTemps) UiParametre.f
					.getFrequences().getSelectedItem();
			c.parametreInterval();
			Parametrage.getInstance().enregistrerObjet();
			ProcessObservationDossier.getInstance().interrupt();
			Thread t = new ProcessObservationDossier();
			t.start();
			break;

		case "activeNotification":
			Parametrage.getInstance().setSeeNotification(true);
			Parametrage.getInstance().enregistrerObjet();
			UiParametre.f.activer.setSelected(true);
			UiParametre.f.desactiver.setSelected(false);
			break;
			
		case "desactiverNotication":
			Parametrage.getInstance().setSeeNotification(false);
			Parametrage.getInstance().enregistrerObjet();
			UiParametre.f.activer.setSelected(false);
			UiParametre.f.desactiver.setSelected(true);
			break;
		
		case"demarrage":
			if (UiParametre.f.verifDossierDem.isSelected()){
				Parametrage.getInstance().setTriDemarrage(true);
			}
			else
			{
				Parametrage.getInstance().setTriDemarrage(false);
			}
			Parametrage.getInstance().enregistrerObjet();
			break;
		}
	}

}
