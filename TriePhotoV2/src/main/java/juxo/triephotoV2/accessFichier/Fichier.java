package juxo.triephotoV2.accessFichier;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;

public class Fichier extends File {

	private static final long serialVersionUID = 1L;
	
	public static Map<Calendar, Fichiers> listFic = new HashMap<Calendar, Fichiers>();
	public static Fichiers listDossier = new Fichiers();
	
	private Calendar ladatefic;
	private Boolean deplacable;
	/***
	 * Création d'un fichier à partir de son path
	 * @param pathname
	 */
	public Fichier(String pathname) {
		//On hérite de fichier donc on appelle le constructeur père
		super(pathname);
		//On initialise les variables de travail
		deplacable = true;
		ladatefic = Calendar.getInstance();
		
		//Recherche si le fichier à une date de prise de vue
		if (this.getPriseVue() != null){
			ladatefic.setTime(this.getPriseVue());
			ladatefic.set(Calendar.HOUR_OF_DAY, 0);
			ladatefic.set(Calendar.MINUTE, 0);
			ladatefic.set(Calendar.SECOND, 0);
			ladatefic.set(Calendar.MILLISECOND, 0);	
		}else
			ladatefic.set(1960, 1, 1);
		
		Fichiers l = null;
		//Séparation des dossiers et des fichiers
		if(this.isFile()){
			l = searchExistDate(ladatefic);
			if(l!=null)
				l.add(this);
			else{
				l = new Fichiers();
				l.add(this);
				listFic.put(ladatefic, l);
			}
				
		}else{
			listDossier.add(this);
		}

	}
	
	public Fichiers searchExistDate(Calendar d){
		Iterator<Calendar> it = listFic.keySet().iterator();
		boolean trouve = false;
		Fichiers ficList = null;
		
		while(it.hasNext() && !trouve){
			
			Calendar key = it.next();
			//System.out.println(d.get(Calendar.DAY_OF_MONTH)+"/"+d.get(Calendar.MONTH)+"/"+d.get(Calendar.YEAR));
			//System.out.println(key.get(Calendar.DAY_OF_MONTH)+"/"+key.get(Calendar.MONTH)+"/"+key.get(Calendar.YEAR));

			if(d.get(Calendar.DAY_OF_MONTH) == key.get(Calendar.DAY_OF_MONTH) &&
					d.get(Calendar.MONTH) == key.get(Calendar.MONTH) &&
							d.get(Calendar.YEAR)==key.get(Calendar.YEAR)){
				trouve = true;
				ficList = listFic.get(key);
			}
		}
		return ficList;
	}

	/***
	 * Recherche de la date de prise de vue de notre fichier à partir d'une librairie externe
	 * retourne null si pas de date de prise de vue ou s'il y a une erreur
	 * @return
	 */
	public Date getPriseVue() {
		//Initialisation de la variable date
		Date date = null;
		
		//On vérifie qu'on est pas à faire à un dossier
		if (this.isFile()) {
			try {
				//On lit les meta
				Metadata mesexifs = ImageMetadataReader.readMetadata(this);
				//Recherche dans l'arborescence du dossier contenant la date de prise de vue
				ExifSubIFDDirectory directory = mesexifs.getDirectory(ExifSubIFDDirectory.class);
				if (directory != null) {
					//La date de prise de vue dans l'exif
					date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
				}
				//Si erreur on ne déplace pas le fichier
			} catch (ImageProcessingException e) {
				deplacable = false;
				System.out.println(e);
			} catch (IOException ex) {
				deplacable = false;
				System.out.println(ex);
			}
		}
		return date;
	}
	
	public GeoLocation getGPS() {
		//Initialisation de la variable date
		GeoLocation coordinates = null;
		
		//On vérifie qu'on est pas à faire à un dossier
		if (this.isFile()) {
			try {
				//On lit les meta
				Metadata mesexifs = ImageMetadataReader.readMetadata(this);
				//Recherche dans l'arborescence du dossier contenant les coordonnées de la photo
				GpsDirectory directory = mesexifs.getDirectory(GpsDirectory.class);
				if (directory != null) {
					//Les coordonnées dans l'exif
					coordinates = directory.getGeoLocation();
				}
				//Si erreur on ne déplace pas le fichier
			} catch (ImageProcessingException e) {
				deplacable = false;
				System.out.println(e);
			} catch (IOException ex) {
				deplacable = false;
				System.out.println(ex);
			}
		}
		return coordinates;
	}
	

	/*** 
	 * Permet de déplacer le fichier (uniquement si pas dossier)
	 * @param Nwxdossier
	 */
	public void Deplacer(String Nwxdossier) {
		

		//Si la date du fichier n'est pas null
		if (this.isFile() 
				&& this.deplacable 
				&& this.ladatefic != null) {
			File ledossier = new File(Nwxdossier + "/" + this.getyearfic() + "/" + this.getmoisfic());
			rangerFichier(ledossier);
		} else if(this.isFile() 
				&& this.deplacable ){
			this.isolerFichier(Nwxdossier);
		}
	}
	
	/***
	 * On déplace dans le dossier de destination
	 * et on force le nom du dossier
	 * @param Nwxdossier
	 * @param nomDossier
	 */
	public void Deplacer(String Nwxdossier, String nomDossier) {
		//Si la date du fichier n'est pas null
		if (this.isFile() 
				&& this.deplacable 
				&& this.ladatefic != null) {
			File ledossier = new File(Nwxdossier + "/" + this.getyearfic() + "/" + this.getmoisfic()+ "/" + nomDossier);
			rangerFichier(ledossier);
		} else if(this.isFile() 
				&& this.deplacable ){
			this.isolerFichier(Nwxdossier);
		}
	}
	
	/***
	 * On range le fichier dans le dossier déterminé
	 * le dossier est crée si inexistant
	 * @param ledossier
	 */
	private void rangerFichier(File ledossier){
		File adeplacer = new File(ledossier + "/" + this.getName());
		if ((!ledossier.exists()) && (deplacable)) {
			ledossier.mkdirs();
			this.renameTo(adeplacer);
		} else if (deplacable) {
			this.renameTo(adeplacer);
		}
	}
	
	/***
	 * On isole le fichier en cas de problème
	 * @param Nwxdossier
	 */
	private void isolerFichier(String Nwxdossier){
		File ledossier = new File(Nwxdossier + "/impossibleadeplacer");
		File adeplacer = new File(ledossier + "/" + this.getName());
		if ((!ledossier.exists()) && (deplacable)) {
			ledossier.mkdirs();
			this.renameTo(adeplacer);
		} else if (deplacable) {
			this.renameTo(adeplacer);
		}
	}
	
	/**
	 * Récupérer une instance d'une image
	 * au bonne dimension
	 * @int largueur voulue
	 */
	public BufferedImage getImage(int Largeur){
		BufferedImage img = null;
		BufferedImage dimg = null;
		try {
		    img = ImageIO.read(this);
			int longueur = img.getHeight();
			int larg = img.getWidth();
			dimg = convertToBufferedImage(img, Largeur, Largeur*longueur/larg);
		} catch (IOException e) {
		    System.out.println(e);
		}catch (NullPointerException e){
			
		}

		return dimg;
	}
	
	public BufferedImage convertToBufferedImage(Image image, int Largeur, int Longueur)
	{
	    BufferedImage bi = new BufferedImage(Largeur, Longueur, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(image, 0, 0, Largeur, Longueur, null);
	    g2d.dispose();
	    return bi;
	}
	
	public String toString(){
		return this.getPath();
	}

	/**
	 * Renvoie l'extension du fichier
	 * @return
	 */
	public String getFileExtension() {
        String fileName = this.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        	return fileName.substring(fileName.lastIndexOf("."));
        else 
        	return "";
	}
	
	/**
	 * Renomme un fichier avec la date de prise de vue
	 * @param iterator
	 */
	public void renommerFichierParDate(int iterator){
		String mois = Integer.toString(this.getmoisfic());
		String jour = Integer.toString(this.getdayfic());
		if (this.getmoisfic() < 10){
			mois = "0" + mois;
		}
		if (this.getdayfic() < 10){
			jour = "0" + jour;
		}
		if (this.getPriseVue() != null){
			Fichier destination = new Fichier(this.getParentFile() + "/" + this.getyearfic() + "-" + mois + "-" + jour + " - " + iterator + this.getFileExtension());
			this.renameTo(destination);
		}
		else {
			System.out.println("Le fichier " + this.getName() + " ne possède pas de date de prise de vue.");
		}
	}
	
	/**
	 * Renomme un fichier avec le choix du nom par l'utilisateur
	 * @param iterator
	 */
	public void renommerFichier(String nom, int iterator) {
		if (this.getPriseVue() != null){
			Fichier destination = new Fichier(this.getParentFile() + "/" + nom + " - " + iterator + this.getFileExtension());
			this.renameTo(destination);
		}
		else {
			System.out.println("Le fichier " + this.getName() + " ne possède pas de date de prise de vue.");
		}	
	}
	
	//plein d'accesseurs qui servent à rien
	public int getheurefic() {
		return ladatefic.get(Calendar.HOUR);
	}

	public int getminutefic() {
		return ladatefic.get(Calendar.MINUTE);
	}

	public int getmoisfic() {
		return ladatefic.get(Calendar.MONTH) + 1;
	}

	public int getdayfic() {
		return ladatefic.get(Calendar.DAY_OF_MONTH);
	}

	public int getyearfic() {
		return ladatefic.get(Calendar.YEAR);
	}

	public Calendar getLadatefic() {
		return ladatefic;
	}

	public void setLadatefic(Calendar ladatefic) {
		this.ladatefic = ladatefic;
	}

	public boolean getdeplacable() {
		return deplacable;
	}

}
