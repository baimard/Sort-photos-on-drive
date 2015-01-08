package juxo.UiTriePhotoV2;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import juxo.apiCalendar.EvenementCalendrier;
import juxo.apiCalendar.Evenements;
import juxo.triephotoV2.accessFichier.Fichiers;

public class UiQuestion extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JList<EvenementCalendrier> listEve;
	private DefaultListModel<EvenementCalendrier> listEvenement = null;
	
	public UiQuestion(JFrame parent, String title, boolean modal, Evenements l, Fichiers fs){
		super(parent, title, modal);
	    this.setSize(800, 700);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	    
	    listEvenement = new DefaultListModel<EvenementCalendrier>();
	    
	    EvenementCalendrier nullEv = new EvenementCalendrier("aucun", new Date(1,1,1960), new Date(1,1,1960));
	    listEvenement.addElement(nullEv);
	    
	    for(EvenementCalendrier e : l){
	    	listEvenement.addElement(e);
	    }
	   
	    this.initComponent(fs);
	}

	private void initComponent(Fichiers fs) {
		JPanel listpan = new JPanel();

		listEve = new JList<EvenementCalendrier>(listEvenement);
		listEve.setPreferredSize(new Dimension(500, 200));
		
		JLabel j1 = new JLabel("Veuillez sélectionner l'événement correspondant à vos images :");
		listpan.add(j1);
		listpan.add(listEve);
		

		JLabel j2 = new JLabel("Des images peuvent ne pas être affichées en raison de leur format :");
		listpan.add(j2);
		
		if(fs.size()>3){
		  Random randomGenerator = new Random();
		    int nbaleatoire;
		    for (int idx = 0; idx <= 2; idx++){
		    	nbaleatoire = randomGenerator.nextInt(fs.size() - 1);
		    	BufferedImage bimg1 = fs.get(nbaleatoire).getImage(180);
		  	    //String simg1 = fs.get(nbaleatoire).getName();
			    JLabel image1 = null;
			    if(bimg1!=null){
					image1 = new JLabel(new ImageIcon(bimg1));
					image1.setMaximumSize(new Dimension(200, 200));
					//image1.setText(simg1);
					listpan.add(image1);
			    }
		    }
		}else{
			BufferedImage bimg1 = fs.get(0).getImage(180);
	  	    //String simg1 = fs.get(nbaleatoire).getName();
		    JLabel image1 = null;
		    if(bimg1!=null){
				image1 = new JLabel(new ImageIcon(bimg1));
				image1.setMaximumSize(new Dimension(200, 200));
				//image1.setText(simg1);
				listpan.add(image1);
		    }
		}
	
		JButton valideButton = new JButton("Déplacer les images");
		valideButton.addActionListener(new UiQuestionActionListener(this));
		this.getContentPane().add(listpan);
		listpan.add(valideButton);
	}

	public EvenementCalendrier showUiQuestion(){
		this.setVisible(true);
		return listEve.getSelectedValue();
	}
	
}
