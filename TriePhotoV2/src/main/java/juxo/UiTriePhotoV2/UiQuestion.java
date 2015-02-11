package juxo.UiTriePhotoV2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import juxo.apiCalendar.Evenement;
import juxo.apiCalendar.Evenements;
import juxo.triephotoV2.accessFichier.Fichiers;

public class UiQuestion extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JList<Evenement> listEve;
	private DefaultListModel<Evenement> listEvenement = null;
	
	public UiQuestion(JFrame parent, String title, boolean modal, Evenements l, Fichiers fs){
		super(parent, title, modal);
	    this.setSize(800, 700);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	    Image icone =   Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pictograms-nps-services-library.png"));
        this.setIconImage(icone);
        this.setBackground(Color.white);
	    listEvenement = new DefaultListModel<Evenement>();
	    
	    @SuppressWarnings("deprecation")
		Evenement nullEv = new Evenement("aucun", new Date(1,1,1960), new Date(1,1,1960));
	    listEvenement.addElement(nullEv);
	    
	    for(Evenement e : l){
	    	listEvenement.addElement(e);
	    }
	   
	    this.initComponent(fs);
	}

	private void initComponent(Fichiers fs) {
		JPanel listpan = new JPanel();
		JPanel panTitre = new JPanel();
		JPanel panEvent = new JPanel(); 
		JPanel panEvent11 = new JPanel(); 
		JPanel panEvent12 = new JPanel(); 
		JPanel panPhotos = new JPanel(); 
		JPanel panPhotos11 = new JPanel(); 
		JPanel panPhotos12 = new JPanel(); 

		JPanel panBtn = new JPanel();
		JLabel txtTitre = new JLabel("<html><h1><u><em>Gestion des evenements</em></u></h1></html> ");
		JLabel txtEvent = new JLabel("<html><strong>Voici la liste des évènements de vos calendriers. Veuillez sélectionner l'évènement <br> correspondant à vos images :</strong></html> ");
        JLabel txtPhotos = new JLabel("<html><strong>Attention, des images peuvent ne pas être affichées en raison de leu format</strong></html>");
        JButton valideButton = new JButton("Déplacer les images");
     
		listEve = new JList<Evenement>(listEvenement);
	    
		
		  TitledBorder bordureEvent = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(29, 158, 233),3),"<html><H3>Evenements</H3></html>"));
		  panEvent.setBorder(bordureEvent);
		  bordureEvent.setTitleColor(new Color(29, 158, 233));
		  
		
		  TitledBorder bordurePhotos = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255,200,0),3),"<html><H3>Photos</H3></html>"));
		  panPhotos.setBorder(bordurePhotos);
		  bordurePhotos.setTitleColor(new Color(255,200,0));

		   ImageIcon iconEvent = new ImageIcon(getClass().getResource("/evenements-icone.png"));
		   JLabel lbl1 = new JLabel();
		   lbl1.setIcon(iconEvent);
		   panEvent11.add(lbl1);
		   
		   ImageIcon iconPhotos = new ImageIcon(getClass().getResource("/photos-icone.png"));
		   JLabel lbl2 = new JLabel();
		   lbl2.setIcon(iconPhotos);
		   panPhotos11.add(lbl2);
		   
		
		listpan.setPreferredSize(new Dimension(700, 750));
		panTitre.setPreferredSize(new Dimension(650, 45));
		panEvent.setPreferredSize(new Dimension(650, 300));
		panPhotos.setPreferredSize(new Dimension(650, 270));
		panBtn.setPreferredSize(new Dimension(600, 40));
		panEvent11.setPreferredSize(new Dimension(600, 50));
		panEvent12.setPreferredSize(new Dimension(600, 190));
		panPhotos11.setPreferredSize(new Dimension(600, 50));
		panPhotos12.setPreferredSize(new Dimension(600, 150));
		listEve.setPreferredSize(new Dimension(560, 175));
	
	
		txtEvent.setForeground(Color.white);
	    txtPhotos.setForeground(Color.white);
	    txtTitre.setForeground(Color.GRAY);
		listpan.setBackground(Color.white);
		panTitre.setBackground(Color.white);
		panEvent.setBackground(Color.white);
		panEvent11.setBackground(new Color(29, 158, 233));
		panEvent12.setBackground(new Color(255,200,0 ));//191,188,192
		listEve.setBackground(Color.white);
	    panPhotos.setBackground(Color.white);
		panPhotos11.setBackground(new Color(255,200,0));
		panPhotos12.setBackground(Color.white);
		panBtn.setBackground(Color.white);	
		
	    panTitre.add(txtTitre);
		panEvent11.add(txtEvent);
		panEvent12.add(listEve);
		
		panEvent.add(panEvent11);
		panEvent.add(panEvent12);
		
		
		panPhotos11.add(txtPhotos);


		
		if(fs.size()>3){
			Random randomGenerator = new Random();
		    int nbaleatoire;
		    int i = 0;
		    int sizeListe = fs.size();
		    int tab_i[] = new int[3];

 while (i < 3 - 1) {

			nbaleatoire = randomGenerator.nextInt(sizeListe);
			if (rechercheTableau(tab_i, nbaleatoire)) {
				tab_i[i] = nbaleatoire;
				i++;
			}
		}
		
		for (int z : tab_i) {
                     
		    		 BufferedImage bimg1 = fs.get(z).getImage(180);
		    		 JLabel image1 = null;
					    if(bimg1!=null){
							image1 = new JLabel(new ImageIcon(bimg1));
							image1.setMaximumSize(new Dimension(100, 100));
							panPhotos12.add(image1);
					      
					    }
		    	}
		    	
		    }
		
		
		    
		  	else{
					BufferedImage bimg1 = fs.get(0).getImage(180);
				    JLabel image1 = null;
				    if(bimg1!=null){
						image1 = new JLabel(new ImageIcon(bimg1));
						image1.setMaximumSize(new Dimension(200, 200));
						panPhotos12.add(image1);
				    }
				}
		    
		   panBtn.add(valideButton);
		   panPhotos.add(panPhotos11); 
		   panPhotos.add(panPhotos12);
		   listpan.add(panTitre);
		   listpan.add(panEvent);
		   listpan.add(panPhotos);
		   listpan.add(panBtn);
		   
				valideButton.addActionListener(new UiQuestionActionListener(this));
				this.getContentPane().add(listpan);
		
				
			}

			public Evenement showUiQuestion(){
				this.setVisible(true);
				return listEve.getSelectedValue();
			}
			
			public static boolean rechercheTableau(int tab[], int i){
				boolean retour = true;
				for(int x : tab){
					if(x==i){
						retour = false;
						break;
					}
				}
				return retour;
		    }
			
		}	
				
		


	
