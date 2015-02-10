package juxo.UiTriePhotoV2;

import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.system.Parametrage;
import juxo.system.XMLToolsSerialisation;
import juxo.triephotoV2.methode.SortByDayDate;

public class UiPremierDemarrageActionListener implements ActionListener {

	private JTextField dossierAnalyser;
	private JTextField dossierClassement;

	private JRadioButton triD;
	private JRadioButton triE;
	private JRadioButton triL;

	private JButton authenButton;

	public UiPremierDemarrageActionListener(JTextField dossierSource,
			JTextField dossierCible, JRadioButton jour, JRadioButton evenement,
			JRadioButton lieu, JButton authentif) {

		this.dossierAnalyser = dossierSource;
		this.dossierClassement = dossierCible;

		triD = jour;
		triE = evenement;
		triL = lieu;

		authenButton = authentif;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "choixSource":
			JFileChooser jfS = new JFileChooser(new File("."));
			jfS.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (jfS.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File fichierS = jfS.getSelectedFile();
				dossierAnalyser.setText(fichierS.getPath());
				Parametrage.getInstance().setDossierSource(fichierS.getPath());
				Parametrage.getInstance().enregistrerObjet();
			}
			break;

		case "choixCible":
			JFileChooser jfC = new JFileChooser(new File("."));
			jfC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if (jfC.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File fichierC = jfC.getSelectedFile();
				dossierClassement.setText(fichierC.getPath());
				Parametrage.getInstance().setDossierDestination(
						fichierC.getPath());
				Parametrage.getInstance().enregistrerObjet();
			}
			break;

		case "trieJourRadio":
			if (UiPremierDemarrage.f.trieJourRadio.isSelected()) {
				Parametrage.getInstance().addSortByDay();
			} else {
				Parametrage.getInstance().delSortByDay();
			}
			break;

		case "triEvenement":

			if (ConnexionGoogle.googleConnexion != null) {
				if (UiPremierDemarrage.f.trieEvenementRadio.isSelected()) {
					Parametrage.getInstance().addSortByEvent();
				} else {
					Parametrage.getInstance().delSortByEvent();
				}
			} else {
				UiPremierDemarrage.f.trieEvenementRadio.setSelected(false);
				JOptionPane.showMessageDialog(null,
						"Veuillez vous connecter à Google (Onglet Suivant)");
			}

			break;

		case "triLieu":
			if (ConnexionGoogle.googleConnexion != null) {
				if (UiPremierDemarrage.f.trieLieuRadio.isSelected()) {
					Parametrage.getInstance().addSortByPlace();
				} else {
					Parametrage.getInstance().delSortByPlace();
				}
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
		
		}
	}
}
