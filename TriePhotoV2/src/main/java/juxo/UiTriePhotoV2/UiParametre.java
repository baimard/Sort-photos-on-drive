package juxo.UiTriePhotoV2;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class UiParametre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel panChoixDossierS = new JPanel();
	JPanel panChoixDossierC = new JPanel();
	JPanel pan1 = new JPanel();
	JPanel pan2 = new JPanel();
	JPanel pan3 = new JPanel();
	JPanel pan11 = new JPanel();
	JPanel pan21 = new JPanel();
	JPanel pan31 = new JPanel();
	JPanel panModeTri1 = new JPanel();
	JPanel panModeTri2 = new JPanel();
	JPanel panModeTri3 = new JPanel();
	JPanel panRenommage1 = new JPanel();
	JPanel panRenommage2 = new JPanel();
	JPanel panRenommage3 = new JPanel();
	JPanel panRenommage4 = new JPanel();
	JPanel panRenommage5 = new JPanel();
	JPanel pan = new JPanel();
	JPanel panbis = new JPanel();
	JPanel panter = new JPanel();
	JPanel panNotif = new JPanel();
	JPanel panApp = new JPanel();
	JPanel panTemps = new JPanel();
	JPanel panIconNotif = new JPanel();
	JPanel panIconFrequence = new JPanel();
	JPanel panRadioBtnAD = new JPanel();
	JPanel panIconAuthent = new JPanel();
	JPanel panIconReInit = new JPanel();
	JPanel panAuthentification = new JPanel();
	JPanel panReInit = new JPanel();
	JPanel panAuthentif1 = new JPanel();
	JPanel panReInit1 = new JPanel();
	
	
	JTabbedPane panelOnglet = new JTabbedPane();
	
	
	private JLabel dossierSource = new JLabel("Dossier source:");
	private JLabel dossierCible = new JLabel("Dossier cible:");
	private JLabel frequenceVerif = new JLabel("Vérification du dossier:");
	private JLabel lblAuthentif = new JLabel("<html><p>Veuillez cliquer ci-contre <br> pour obtenir  le code <br> d'authentification google</p></html> ");
	private JLabel lblReInit = new JLabel("<html><p>Veuillez cliquer ci-contre pour <br> réinitialiser la connexion google</p></html>");
	
	private JTextField source = new JTextField();
	private JTextField cible = new JTextField();
	private JTextField selectDossierRenom = new JTextField();
	private JTextField saisieNom = new JTextField();
	
	
	private JButton choixSource = new JButton("Parcourir");
	private JButton choixCible = new JButton("Parcourir");
	private JButton fichieRenom = new JButton("Parcourir");
	private JButton renommer = new JButton("Renommer");
	private JButton codAuthent = new JButton("Obtenir mon code d'authentification");
	private JButton reInitCode = new JButton("Réinitialiser la connexion google");
	
	private JRadioButtonMenuItem  modeDate = new JRadioButtonMenuItem ("Date");
	private JRadioButtonMenuItem  modeEvenement = new JRadioButtonMenuItem ("Evenement");
	private JRadioButtonMenuItem  modeLieu = new JRadioButtonMenuItem ("Lieu");
	private JRadioButtonMenuItem  renomDate = new JRadioButtonMenuItem ("Renommer par date de prise de vue");
	private JRadioButtonMenuItem  renomLieu = new JRadioButtonMenuItem ("Renommer par lieu");
	private JRadioButtonMenuItem  renomNomSpec = new JRadioButtonMenuItem ("Renommer avec le nom suivant:");
	private JRadioButtonMenuItem  activer = new JRadioButtonMenuItem ("Notification ativée");
	private JRadioButtonMenuItem  desactiver = new JRadioButtonMenuItem ("Notification désactivée");
	
	private ButtonGroup triGroupBtn = new ButtonGroup();
	private ButtonGroup renomGroupBtn = new ButtonGroup();
	private ButtonGroup notifGroupBtn = new ButtonGroup();
	
	 private JComboBox frequences;

	
	
	public UiParametre(){
		
		this.setTitle("Parametrage");
		this.setSize(600, 700);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
UiParametreActionListener UiParametreListener = new UiParametreActionListener(source, cible, modeDate, modeEvenement, modeLieu, selectDossierRenom, renomDate, renomLieu, renomNomSpec);

		// ___________________  Les icones ___________________________________________
		
		Image icone =   Toolkit.getDefaultToolkit().getImage(getClass().getResource("Resource\\pictograms-nps-services-library.png"));
        this.setIconImage(icone);
        
       
		ImageIcon icon1 = new ImageIcon(getClass().getResource("Resource\\dossier-icone.png"));
		JLabel label1 = new JLabel();
		label1.setIcon(icon1);
		pan11.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan11.add(label1);
		
		ImageIcon icon2 = new ImageIcon(getClass().getResource("Resource\\modules-icone.png"));
		JLabel label2 = new JLabel();
		label2.setIcon(icon2);
		pan21.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan21.add(label2);
		
		ImageIcon icon3 = new ImageIcon(getClass().getResource("Resource\\encre-icone.png"));
		JLabel label3 = new JLabel();
		label3.setIcon(icon3);
		pan31.setLayout(new FlowLayout(FlowLayout.LEFT));
		pan31.add(label3);
		
		
		ImageIcon iconNotif = new ImageIcon(getClass().getResource("Resource\\notification-icone.png"));
		JLabel label4 = new JLabel();
		label4.setIcon(iconNotif);
		panIconNotif.add(label4);
		
		
		ImageIcon iconFrequence = new ImageIcon(getClass().getResource("Resource\\frequence-icone.png"));
		JLabel label5 = new JLabel();
		label5.setIcon(iconFrequence);
		panIconFrequence.add(label5);
		
		ImageIcon iconAuthent = new ImageIcon(getClass().getResource("Resource\\icone-cle.png"));
		JLabel label6 = new JLabel();
		label6.setIcon(iconAuthent);
		panIconAuthent.add(label6);
		
		
		ImageIcon iconReInit = new ImageIcon(getClass().getResource("Resource\\rafraichir-icone.png"));
		JLabel label7 = new JLabel();
		label7.setIcon(iconReInit);
		panIconReInit.add(label7);
		
		ImageIcon iconOngletTri = new ImageIcon(getClass().getResource("Resource\\parametres-icone.png"));
		ImageIcon iconConnexionGoogle = new ImageIcon(getClass().getResource("Resource\\google-icone.png"));
		ImageIcon iconGenerale = new ImageIcon(getClass().getResource("Resource\\horloge-icone.png"));
		
		
		
		//______________________ les objets ______________________
		
		Object[] elements = new Object[]{"Toutes les minutes", "Tous les 5 minutes", "Tous les 10 minutes", "Tous les 15 minutes", "Tous les 30 min", "Toutes les heures"};
	    frequences= new JComboBox(elements);

	    JPanel content = new JPanel();
	    
		//JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		//______________________ Background color _______________________
		
		modeDate.setBackground(Color.WHITE);
		modeEvenement.setBackground(Color.WHITE);
		modeLieu.setBackground(Color.WHITE);
		renomDate.setBackground(Color.WHITE);
		renomLieu.setBackground(Color.WHITE);
		renomNomSpec.setBackground(Color.WHITE);
		panChoixDossierS.setBackground(Color.WHITE);
		panChoixDossierC.setBackground(Color.WHITE);
		pan11.setBackground(Color.WHITE);
		pan1.setBackground(Color.WHITE);
		panModeTri1.setBackground(Color.WHITE);
		pan2.setBackground(Color.WHITE);
		pan21.setBackground(Color.WHITE);
		panRenommage1.setBackground(Color.WHITE);
		panRenommage2.setBackground(Color.WHITE);
		panRenommage3.setBackground(Color.WHITE);
		panRenommage4.setBackground(Color.WHITE);
		panRenommage5.setBackground(Color.WHITE);
		source.setBackground(Color.WHITE);
		cible.setBackground(Color.WHITE);
		selectDossierRenom.setBackground(Color.WHITE);
		saisieNom.setBackground(Color.WHITE);
		pan3.setBackground(Color.WHITE);
		pan31.setBackground(Color.WHITE);
		pan.setBackground(Color.WHITE);
	    content.setBackground(Color.WHITE);
	    pan.setBackground(Color.WHITE);
	    panelOnglet.setBackground(Color.WHITE);
        panbis.setBackground(Color.WHITE);
	    panNotif.setBackground(Color.WHITE);
	    activer.setBackground(Color.WHITE);
	    desactiver.setBackground(Color.WHITE);
		panApp.setBackground(Color.WHITE);
		panTemps.setBackground(Color.WHITE);
		panIconNotif.setBackground(Color.WHITE);
		panIconFrequence.setBackground(Color.WHITE);
		panter.setBackground(Color.WHITE);
		panAuthentification.setBackground(Color.WHITE);
		panReInit.setBackground(Color.WHITE);
		panIconAuthent.setBackground(Color.WHITE);
		panIconReInit.setBackground(Color.WHITE);
		lblAuthentif.setBackground(Color.WHITE);
		lblReInit.setBackground(Color.WHITE);
		panAuthentif1.setBackground(Color.WHITE);
		panReInit1.setBackground(Color.WHITE);
	    
       //________________Les panels _________________________________
	    
	           //_______Layout_______
	    
		panChoixDossierS.setLayout(new FlowLayout());
		panChoixDossierC.setLayout(new FlowLayout());
		pan1.setLayout(new BoxLayout(pan1, BoxLayout.Y_AXIS));
		panModeTri1.setLayout(new GridLayout(1,3));
		pan2.setLayout(new BoxLayout(pan2, BoxLayout.Y_AXIS));
	    panRenommage1.setLayout(new FlowLayout());
	    panRenommage2.setLayout(new GridLayout(1,1));
		panRenommage3.setLayout(new GridLayout(1,1));
		panRenommage4.setLayout(new BoxLayout(panRenommage4, BoxLayout.X_AXIS));
		panRenommage5.setLayout(new FlowLayout());
		pan3.setLayout(new BoxLayout(pan3, BoxLayout.Y_AXIS));
		pan.setLayout(new FlowLayout());
		panIconNotif.setLayout(new FlowLayout(FlowLayout.LEFT));
		panIconFrequence.setLayout(new FlowLayout(FlowLayout.LEFT));
		panNotif.setLayout(new FlowLayout(FlowLayout.LEFT));
		panApp.setLayout(new FlowLayout(FlowLayout.LEFT));
		panTemps.setLayout(new GridLayout(1,2));
		panIconAuthent.setLayout(new FlowLayout(FlowLayout.LEFT));
		panIconReInit.setLayout(new FlowLayout(FlowLayout.LEFT));
		panAuthentification.setLayout(new FlowLayout(FlowLayout.LEFT));
		panReInit.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		       //_______ Taille panel_______
		content.setPreferredSize(new Dimension(600, 700));
        pan11.setPreferredSize(new Dimension(500, 50));
        pan21.setPreferredSize(new Dimension(500, 50));
        panRenommage1.setPreferredSize(new Dimension(500, 35));
        panRenommage2.setPreferredSize(new Dimension(250, 30));
        panRenommage3.setPreferredSize(new Dimension(250, 30));
        panRenommage4.setPreferredSize(new Dimension(500, 30));
        panRenommage5.setPreferredSize(new Dimension(500, 40));
        pan31.setPreferredSize(new Dimension(500,50 ));
        panNotif.setPreferredSize(new Dimension(500, 120));
        panTemps.setPreferredSize(new Dimension(300, 45));
        panAuthentification.setPreferredSize(new Dimension(500, 120));
        panReInit.setPreferredSize(new Dimension(500,120));
        
               // ___________Taille objet ____________
		source.setPreferredSize(new Dimension(300, 25));
		cible.setPreferredSize(new Dimension(300, 25));
		selectDossierRenom.setPreferredSize(new Dimension(380, 25));
		saisieNom.setPreferredSize(new Dimension(284, 25));
		renommer.setPreferredSize(new Dimension(150, 25));
		
		
    //_____Title Border___________
        TitledBorder bordureDossier = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(29,158,233),2),"<html><H3>Choix des dossiers</H3></html>"));
		pan1.setBorder(bordureDossier);
		bordureDossier.setTitleColor(new Color(29,158,233));
		
	    
	    
		TitledBorder bordureTri = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255,134,28),2),"<html><H3>Option de tri</H3></html>"));
		pan2.setBorder(bordureTri);
		bordureTri.setTitleColor(new Color(255,134,28));
		
		
		
		pan3.setBorder(BorderFactory.createTitledBorder("Renommage des fichiers"));
		TitledBorder bordureRenommage = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(76,153,0),2),"<html><H3>Renommage des fichiers</H3></html>"));
		pan3.setBorder(bordureRenommage);
		bordureRenommage.setTitleColor(new Color(76,153,0));
		
		
		
		//______ les commandes________
		choixSource.setActionCommand("choixSource");
        choixSource.addActionListener(UiParametreListener);
		choixCible.setActionCommand("choixCible");
        choixCible.addActionListener(UiParametreListener);
		fichieRenom.setActionCommand("choixFicRenom");
        fichieRenom.addActionListener(UiParametreListener);
		modeDate.setActionCommand("triDate");
		modeDate.addActionListener(UiParametreListener);
		modeEvenement.setActionCommand("triEvenement");
		modeEvenement.addActionListener(UiParametreListener);
		modeLieu.setActionCommand("triLieu");
		modeLieu.addActionListener(UiParametreListener);
		renomDate.setActionCommand("renomParDate");
		renomDate.addActionListener(UiParametreListener);
		renomLieu.setActionCommand("renomParLieu");
		renomLieu.addActionListener(UiParametreListener);
		renomNomSpec.setActionCommand("renomNomSpecifie");
		renomNomSpec.addActionListener(UiParametreListener);
		setLocationRelativeTo(this.getParent()); 
		
		

 
////////////////////_________________________ Onglet tri ___________________________	   
		
	    panChoixDossierS.add(dossierSource);
	    panChoixDossierS.add(source);
	    panChoixDossierS.add(choixSource);
	    
	    panChoixDossierC.add(dossierCible);
	    panChoixDossierC.add(cible);
	    panChoixDossierC.add(choixCible);
	    
	    pan1.add(pan11);
	    pan1.add(panChoixDossierS);
	    pan1.add(panChoixDossierC);
	    
	    
	    triGroupBtn.add(modeDate);
	    triGroupBtn.add(modeEvenement);
	    triGroupBtn.add(modeLieu);
	    
	    panModeTri1.add(modeDate);
	    panModeTri1.add(modeEvenement);
	    panModeTri1.add(modeLieu);
	    
	   
	    pan2.add(pan21);
	    pan2.add(panModeTri1);
	    
	    renomGroupBtn.add(renomDate);
	    renomGroupBtn.add(renomLieu);
	    renomGroupBtn.add(renomNomSpec);
	    
	    panRenommage1.add(selectDossierRenom);
	    panRenommage1.add(fichieRenom);
	    panRenommage2.add(renomDate);
	    panRenommage3.add(renomLieu);
	    panRenommage4.add(renomNomSpec);
	    panRenommage4.add(saisieNom);
	    panRenommage5.add(renommer);
	    
	   
	    pan3.add(pan31);
	    pan3.add(panRenommage1);
	    pan3.add(panRenommage2);
	    pan3.add(panRenommage3);
	    pan3.add(panRenommage4);
	    pan3.add(panRenommage5);
	    
	    
	    content.add(pan1);
	    content.add(pan2);
	    content.add(pan3);
	    
	    pan.add(content);
	    
        panelOnglet.addTab("Option de tri", iconOngletTri , pan);
        panelOnglet.addTab("Option générale",iconGenerale ,  panbis);
        panelOnglet.addTab("Connexion google",iconConnexionGoogle, panter);
       
        
        
      //////////////// _____________________________________ Onglet général ________________________
        

		//txtDossier.setFont(new java.awt.Font("Dialog", 0, 12));
		
                /// ___________ Border Title ________________
		
	    TitledBorder bordureNotif = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255,184,28),2),"<html><H3>Notification</H3></html>"));
		panNotif.setBorder(bordureNotif);
		bordureNotif.setTitleColor(new Color(255,184,28));
		
	    
	    panApp.setPreferredSize(new Dimension(500,120));
	    TitledBorder bordureOptionApp = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(128,128,128),2),"<html><H3>Fréquence</H3></html>"));
		panApp.setBorder(bordureOptionApp);
		bordureOptionApp.setTitleColor(new Color(128,128,128));
		
	    
                   //___________ les objets placés dans l'onglet ______________
		notifGroupBtn.add(activer);
		notifGroupBtn.add(desactiver);
		
		panNotif.add(panIconNotif);
        panNotif.add(activer);
        panNotif.add(desactiver);
		
		panApp.add(panIconFrequence);
		panApp.add(panTemps);
		panTemps.add(frequenceVerif);
		panTemps.add(frequences);
		
		
		panbis.add(panNotif);
		panbis.add(panApp);
        
		
	//////////////___________________________________ Onglet Connexion Google __________________________
		
		//_______Title Border__________
		
	    TitledBorder bordureAuth = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255,200,0),2),"<html><H3>Authentification google</H3></html>"));
	    panAuthentification.setBorder(bordureAuth);
		bordureAuth.setTitleColor(new Color(255,200,0));
		
	   
	    TitledBorder bordureReInit = (BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(255,0,240),2),"<html><H3>Réinitialisation</H3></html>"));
	    panReInit.setBorder(bordureReInit);
	    bordureReInit.setTitleColor(new Color(255,0,240));
		
	    //__________Les objets dans l'onglet ________
	    panAuthentification.add(panIconAuthent);
	    panAuthentification.add(panAuthentif1);
	    
	    panAuthentif1.add(lblAuthentif);
	    panAuthentif1.add(codAuthent);
	    
	    panReInit.add(panIconReInit);
	    panReInit.add(panReInit1);
	    
	    panReInit1.add(lblReInit);
	    panReInit1.add(reInitCode);
	    
	    panter.add(panAuthentification);
	    panter.add(panReInit);
	    
	    this.add(panelOnglet);
		this.setVisible(true);
	
}
}
