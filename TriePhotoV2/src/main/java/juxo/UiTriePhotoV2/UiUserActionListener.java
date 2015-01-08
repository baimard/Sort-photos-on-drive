package juxo.UiTriePhotoV2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import juxo.threads.ProcessChargementCalendriers;
import juxo.threads.ProcessGlobal;

public class UiUserActionListener implements ActionListener{

	private ArrayList<String> listeCalendrier = new ArrayList<String>();
	private JTextField dossier;
	private JTextField destinationDossier;
	private JTextArea mesCalendriers;
	private JList<String> logueur;
	
	public UiUserActionListener(JTextField dossierAnalyse, JTextField destinationDossier, JTextArea calendrierEvenement, JList<String> logueur) {
		dossier = dossierAnalyse;
		mesCalendriers=calendrierEvenement;
		this.logueur = logueur;
		this.destinationDossier=destinationDossier;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand()){
		
			case "ChargementCalendrier":
				Thread tChargementCalendrier = new ProcessChargementCalendriers(logueur, mesCalendriers);
				tChargementCalendrier.start();
			break;
			
			case "Trie" :
				for(String id : mesCalendriers.getText().split(";")){
					listeCalendrier.add(id.replaceAll("[\r\n]+", ""));
				}
				Thread t = new ProcessGlobal(listeCalendrier, logueur, dossier.getText(), destinationDossier.getText());
				t.start();
			break;
			
			case "Chooser" :
				JFileChooser jf = new JFileChooser(new File("."));
				jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(jf.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
					File fichier = jf.getSelectedFile();
					dossier.setText(fichier.getPath());
				}
			break;
			
			case "Chooser2" :
				JFileChooser jf2 = new JFileChooser(new File("."));
				jf2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(jf2.showOpenDialog(null)==JFileChooser.APPROVE_OPTION){
					File fichier = jf2.getSelectedFile();
					destinationDossier.setText(fichier.getPath());
				}
			break;
		}	
	}

}
