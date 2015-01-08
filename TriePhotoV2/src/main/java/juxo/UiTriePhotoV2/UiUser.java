package juxo.UiTriePhotoV2;

import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

public class UiUser extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel pan = new JPanel();
	private JButton bouton = new JButton("Lancer le trie");
	private JButton boutonChooser = new JButton("Choisir");
	private JButton boutonChooser2 = new JButton("Choisir");
	private JButton boutonCalendriers = new JButton("ChargementCalendrier");
	
	private JLabel labelTrieDossier = new JLabel("Le dossier à trier : ");
	private JTextField trieDossier = new JTextField("/Users/Juxo/hubiC/Projet jav/TriePhotoV2/test2/2014");
	
	private JLabel labelDestinationDossier = new JLabel("Le dossier de destination des fichiers : ");
	private JTextField destinationDossier = new JTextField("/Users/Juxo/hubiC/Projet jav/TriePhotoV2/test2/test");

	private JList<String> logueur = new JList<String>();
	private DefaultListModel<String> logModel = new DefaultListModel<String>();
	

	
	private JTextArea calendrierEvenement = new JTextArea("juxorevo@gmail.com;ojne85k2q1g382oq9u4pmua8vvpb6kp2@import.calendar.google.com");
	private JLabel labelcalendrierEvenement = new JLabel("Les calendriers à utiliser (séparer par \";\" ) :");
	private JScrollPane scrollJ1;
	
	
	
	public UiUser(){
		   this.setTitle("Trie Photo Juxo Corps V2");
		    this.setSize(600, 600);
		    this.setLocationRelativeTo(null);
		    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
		    this.setVisible(true);
		    
		    UiUserActionListener UiUserListener = new UiUserActionListener(trieDossier, destinationDossier, calendrierEvenement, logueur);
		    
		    logueur.setModel(logModel);
		    
		    logueur.setPreferredSize(new Dimension(500,200));
		    trieDossier.setPreferredSize(new Dimension(500, 30));
		    destinationDossier.setPreferredSize(new Dimension(500, 30));
		    calendrierEvenement.setPreferredSize(new Dimension(500,1000));

		    DefaultCaret caret = (DefaultCaret)calendrierEvenement.getCaret();
		    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		    
		    scrollJ1 = new JScrollPane(calendrierEvenement, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		    scrollJ1.setPreferredSize(new Dimension(500,150));
		    scrollJ1.setBounds(5, 5, 500, 150);
		    
		    boutonChooser.setActionCommand("Chooser");
		    boutonChooser.addActionListener(UiUserListener);
		    boutonChooser2.setActionCommand("Chooser2");
		    boutonChooser2.addActionListener(UiUserListener);
		    bouton.setActionCommand("Trie");
		    bouton.addActionListener(UiUserListener);
		    boutonCalendriers.setActionCommand("ChargementCalendrier");
		    boutonCalendriers.addActionListener(UiUserListener);
		    
		    pan.add(labelTrieDossier);
		    pan.add(trieDossier);
		    pan.add(boutonChooser);
		    
		    pan.add(labelDestinationDossier);
		    pan.add(destinationDossier);
		    pan.add(boutonChooser2);
		    pan.add(boutonCalendriers);
		    
		    pan.add(labelcalendrierEvenement);
		    pan.add(scrollJ1);

		    pan.add(logueur);
		    pan.add(bouton);
		    this.setContentPane(pan);
		    this.setVisible(true);
	}
	
}
