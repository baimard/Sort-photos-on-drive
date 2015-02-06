package juxo.UiTriePhotoV2;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class UiPremierDemarrageActionListener implements ActionListener {

	private JTextField dossierAnalyser;
	private JTextField dossierClassement;

	private JRadioButton triD;
	private JRadioButton triE;
	private JRadioButton triL;

	
	public UiPremierDemarrageActionListener (JTextField dossierSource, JTextField dossierCible, JRadioButton jour, JRadioButton evenement, JRadioButton lieu){
		
		this.dossierAnalyser = dossierSource ;
		this.dossierClassement = dossierCible;
		
		triD = jour;
		triE = evenement;
		triL = lieu;

		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "choixSource":
			JFileChooser jfS = new JFileChooser(new File("."));
			jfS.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if(jfS.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
		    File fichierS = jfS.getSelectedFile();
		    dossierAnalyser.setText(fichierS.getPath());
			}				
		break;

		
		case "choixCible":
			JFileChooser jfC = new JFileChooser(new File("."));
			jfC.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			if(jfC.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
		    File fichierC = jfC.getSelectedFile();
			dossierClassement.setText(fichierC.getPath());
			}				
		break;
		
		
		case "triDate":

		break;
		
		
		case "triEvenement":
			
		break;
			
		
		case "triLieu":
			
		break;
		
		
		
			
	}
	}
}
