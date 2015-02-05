package juxo.UiTriePhotoV2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

public class UiParametreActionListener implements ActionListener {
	
	
	private JTextField dossierAnalyser;
	private JTextField dossierClassement;
	private JTextField ficRenom;
	private JRadioButtonMenuItem triD;
	private JRadioButtonMenuItem triE;
	private JRadioButtonMenuItem triL;
	private JRadioButtonMenuItem renomD;
	private JRadioButtonMenuItem renomL;
	private JRadioButtonMenuItem renomNS;
	
	public UiParametreActionListener(JTextField dossierSource, JTextField dossierCible, JRadioButtonMenuItem modeDate, JRadioButtonMenuItem modeEvenement, JRadioButtonMenuItem modeLieu, JTextField fichierRenommer, JRadioButtonMenuItem renomDate, JRadioButtonMenuItem renomLieu, JRadioButtonMenuItem renomNomSpec){
		this.dossierAnalyser = dossierSource ;
		this.dossierClassement = dossierCible;
		ficRenom = fichierRenommer;
		triD = modeDate;
		triE = modeEvenement;
		triL = modeLieu;
		renomD = renomDate; 
		renomL = renomLieu; 
		renomNS = renomNomSpec;
		
	
		
		}
	

	@Override
	public void actionPerformed(ActionEvent e) {
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
			

			case "choixFicRenom":
				JFileChooser jfR = new JFileChooser(new File("."));
				jfR.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(jfR.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
			    File fichierR = jfR.getSelectedFile();
				dossierClassement.setText(fichierR.getPath());
				}				
			break;
			
			case "renomParDate":
				
			break;
			
			case "renomParLieu":
				
			break;
			
			case "renomNomSpecifie":
				
			break;
			
			
			
				
		}
			
	}

	

}
