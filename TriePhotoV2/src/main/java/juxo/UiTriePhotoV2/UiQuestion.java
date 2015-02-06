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

		listEve = new JList<Evenement>(listEvenement);
		listEve.setPreferredSize(new Dimension(500, 200));
		
		JLabel j1 = new JLabel("Veuillez sélectionner l'événement correspondant à vos images :");
		listpan.add(j1);
		listpan.add(listEve);
		

		JLabel j2 = new JLabel("Des images peuvent ne pas être affichées en raison de leur format :");
		listpan.add(j2);

		
		if(fs.size()>3){
			Random randomGenerator = new Random();
		    int nbaleatoire;
		    int i = 0;
		    int sizeListe = fs.size();
		    int tab_i[] = new int[sizeListe];
	
		    
		    
		    while(i < sizeListe-1){
		    	nbaleatoire = randomGenerator.nextInt(sizeListe);
		    	System.out.println(nbaleatoire);
		  
		    	if(rechercheTableau(tab_i, nbaleatoire)){
		    		tab_i[i]= nbaleatoire;
		    		i++;
		    
		    		BufferedImage bimg1 = fs.get(nbaleatoire).getImage(180);
		    		 JLabel image1 = null;
					    if(bimg1!=null){
							image1 = new JLabel(new ImageIcon(bimg1));
							image1.setMaximumSize(new Dimension(200, 200));
							listpan.add(image1);
					      
					    }
		    	}
		    	
		    }
		}
		
		    
		  	else{
					BufferedImage bimg1 = fs.get(0).getImage(180);
				    JLabel image1 = null;
				    if(bimg1!=null){
						image1 = new JLabel(new ImageIcon(bimg1));
						image1.setMaximumSize(new Dimension(200, 200));
						listpan.add(image1);
				    }
				}
		    
				JButton valideButton = new JButton("Déplacer les images");
				valideButton.addActionListener(new UiQuestionActionListener(this));
				this.getContentPane().add(listpan);
				listpan.add(valideButton);
			}

			public Evenement showUiQuestion(){
				this.setVisible(true);
				return listEve.getSelectedValue();
			}
			
			public static boolean rechercheTableau(int tab[], int i){
				boolean retour = true;
				for(int x : tab){
					System.out.println(x);
					if(x==i){
						retour = false;
						break;
					}
				}
				return retour;
		    }
			
		}	
				
		


	
