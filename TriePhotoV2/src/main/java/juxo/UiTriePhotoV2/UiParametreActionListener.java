package juxo.UiTriePhotoV2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JFileChooser;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.system.Parametrage;
import juxo.system.XMLToolsSerialisation;

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

			break;

		case "triEvenement":

			break;

		case "triLieu":

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
			comboElement c = (comboElement) UiParametre.f.getFrequences()
					.getSelectedItem();
			c.parametreInterval();
			Parametrage.getInstance().enregistrerObjet();
			break;
		}
	}

}
