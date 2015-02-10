package juxo.UiTriePhotoV2;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.system.Parametrage;
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
				Parametrage.getInstance().setDossierDestination(fichierC.getPath());
				Parametrage.getInstance().enregistrerObjet();
			}
			break;

		case "trieJourRadio":
			if(UiPremierDemarrage.f.trieJourRadio.isSelected()){
				Parametrage.getInstance().addSortByDay();
			}else{
				Parametrage.getInstance().delSortByDay();
			}
			break;

		case "triEvenement":

			break;

		case "triLieu":

			break;

		case "authentification":
			try {
				ConnexionGoogle CG = new ConnexionGoogle();
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;

		}
	}
}
