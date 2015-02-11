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
import juxo.triephotoV2.methode.ComparatorSortMethod;
import juxo.triephotoV2.methode.SortByDayDate;
import juxo.triephotoV2.methode.SortByEvent;
import juxo.triephotoV2.methode.SortByPlace;

public class UiPremierDemarrageActionListener implements ActionListener {

	public UiPremierDemarrageActionListener() {}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "choixSource":
			JFileChooser jfS = new JFileChooser(new File("."));
			jfS.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (jfS.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File fichierS = jfS.getSelectedFile();
				UiPremierDemarrage.f.SourceField.setText(fichierS.getPath());
				Parametrage.getInstance().setDossierSource(fichierS.getPath());
				Parametrage.getInstance().enregistrerObjet();
				
			}
			break;

		case "choixCible":
			JFileChooser jfC = new JFileChooser(new File("."));
			jfC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (jfC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File fichierC = jfC.getSelectedFile();
				UiPremierDemarrage.f.DestField.setText(fichierC.getPath());
				Parametrage.getInstance().setDossierDestination(
						fichierC.getPath());
				Parametrage.getInstance().enregistrerObjet();
			}
			break;
			
		case "trieJourRadio":
			if (UiPremierDemarrage.f.trieJourRadio.isSelected()) {
				Parametrage.getInstance().getTabSortMethod().add(new SortByDayDate(3));
			} else {
				Parametrage.getInstance().getTabSortMethod().remove(SortByDayDate.getInstance());
			}
			Parametrage.getInstance().enregistrerObjet();
			break;

		case "triEvenement":
			if (ConnexionGoogle.googleConnexion != null) {
				if (UiPremierDemarrage.f.trieEvenementRadio.isSelected()) {
					Parametrage.getInstance().getTabSortMethod().add(new SortByEvent(1));
				} else {
					Parametrage.getInstance().getTabSortMethod().remove(SortByEvent.getInstance());
				}
				Parametrage.getInstance().enregistrerObjet();
			} else {
				UiPremierDemarrage.f.trieEvenementRadio.setSelected(false);
				JOptionPane.showMessageDialog(null,
						"Veuillez vous connecter à Google (Onglet Suivant)");
			}

			break;

		case "triLieu":
			if (ConnexionGoogle.googleConnexion != null) {
				if (UiPremierDemarrage.f.trieLieuRadio.isSelected()) {
					Parametrage.getInstance().getTabSortMethod().add(new SortByPlace(2));
				} else {
					Parametrage.getInstance().getTabSortMethod().remove(SortByPlace.getInstance());
				}
				Parametrage p = Parametrage.getInstance();
				Collections.sort(p.getTabSortMethod(), new ComparatorSortMethod());
				Parametrage.getInstance().enregistrerObjet();
			} else {
				UiPremierDemarrage.f.trieLieuRadio.setSelected(false);
				JOptionPane.showMessageDialog(null,
						"Veuillez vous connecter à Google (Onglet Suivant)");
			}
			break;

		case "authentification":
			try {
				new ConnexionGoogle();
				if (ConnexionGoogle.googleConnexion != null) {
					UiPremierDemarrage.f.boutonAuthentif.setEnabled(false);
					UiPremierDemarrage.f.boutonReinitial.setEnabled(true);
					UiPremierDemarrage.f.boutonAuthentif
							.setText("Vous êtes connecté");
				}
			} catch (IOException | URISyntaxException e1) {
				System.out.println(e1);
			}
			break;

		case "reinitialisation":
			XMLToolsSerialisation.DeleteFile("token");
			ConnexionGoogle.googleConnexion=null;
			UiPremierDemarrage.f.boutonAuthentif.setEnabled(true);
			UiPremierDemarrage.f.boutonReinitial.setEnabled(false);
			UiPremierDemarrage.f.boutonAuthentif.setText("Vous connecter...");
			break;
			
		case "intervalTime":
			Parametrage p = Parametrage.getInstance();
			comboElement c = (comboElement) UiPremierDemarrage.f.chxFrequence.getSelectedItem();
			p.setIntervalObservation(c.interval);
			p.enregistrerObjet();
			break;
	
			
		case "demarrage":
			if (UiPremierDemarrage.f.triDemarrage.isSelected()) {
				Parametrage.getInstance().setTriDemarrage(true);
		
			} else {
				//UiPremierDemarrage.f.triDemarrage.setSelected(false);
				Parametrage.getInstance().setTriDemarrage(false);
				System.out.println("non");
			}
			Parametrage.getInstance().enregistrerObjet();
		break;	
		}
	}
}
