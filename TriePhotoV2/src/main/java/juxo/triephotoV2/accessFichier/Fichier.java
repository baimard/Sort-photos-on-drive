package juxo.triephotoV2.accessFichier;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.lang.GeoLocation;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.drew.metadata.exif.GpsDirectory;

/**
 * Surcharge de la classe fichier pour ajouter des fonctionnalités
 * @author Juxo
 *
 */
public class Fichier extends File{
	

	private static final long serialVersionUID = 1L;
	public static MapDateFichiers listFic = new MapDateFichiers();
	public static final String SEPARATOR = "" + separatorChar;
	private Calendar ladatefic;
	private Boolean deplacable;
	private double lat;
	private double lon;
	
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
		
		//Recherche si le fichier à des coordonnées GPS
		if(getGPS()!=null){
			lat = this.getGPS().getLatitude();
			lon = this.getGPS().getLongitude();
		}

		ajoutList();

	}
	
	/**
	 *Ajout d'un fichier à la liste de fichiers en cours de traitement 
	 */
	public void ajoutList(){
		Fichiers l = null;
		//Séparation des dossiers et des fichiers
		if(this.isFile()){
			l = listFic.searchExistDate(ladatefic);
			if(l!=null)
				l.add(this);
			else{
				l = new Fichiers();
				l.add(this);
				listFic.put(ladatefic, l);
			}
				
		}
	}

	/***
	 * Recherche de la date de prise de vue de notre fichier à partir d'une librairie externe
	 * retourne null si pas de date de prise de vue ou s'il y a une erreur
	 * @return
	 */
	public Date getPriseVue() {
		Date date = null;
		if (this.isFile()) {
			try {
				Metadata mesexifs = ImageMetadataReader.readMetadata(this);
				ExifSubIFDDirectory directory = mesexifs.getDirectory(ExifSubIFDDirectory.class);
				if (directory != null) {
					date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
				}
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
	
	/**
	 * Recherche des coordonnées GPS de notre fichier à partir d'une librairie externe
	 * retourne null si pas de coordonnées GPS ou s'il y a une erreur
	 * @return
	 */
	public GeoLocation getGPS() {
		GeoLocation coordinates = null;
		if (this.isFile()) {
			try {
				Metadata mesexifs = ImageMetadataReader.readMetadata(this);
				GpsDirectory directory = mesexifs.getDirectory(GpsDirectory.class);
				if (directory != null) {
					coordinates = directory.getGeoLocation();
				}
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
	

	/**
	 * Permet de déplacer le fichier (uniquement si pas dossier)
	 * @param Nwxdossier
	 */
	public void Deplacer(String nomDossierDestination) {
		//Si la date du fichier n'est pas null
		if (this.isFile() 
				&& this.deplacable 
				&& this.ladatefic != null) {
			File ledossier = new File(nomDossierDestination + SEPARATOR + this.getYearFile() + SEPARATOR + this.getMonthFile());
			rangerFichier(ledossier);
		} else if(this.isFile() 
				&& this.deplacable ){
			this.isolerFichier(nomDossierDestination);
		}
	}
	
	/**
	 * On déplace dans le dossier de destination
	 * et on force le nom du dossier
	 * @param Nwxdossier
	 * @param nomDossier
	 */
	public void Deplacer(String nomDossierDestination, String nomDossier) {
		//Si la date du fichier n'est pas null
		if (this.isFile() 
				&& this.deplacable 
				&& this.ladatefic != null) {
			File ledossier = new File(nomDossierDestination + SEPARATOR + this.getYearFile() + SEPARATOR + this.getMonthFile() + SEPARATOR + nomDossier);
			rangerFichier(ledossier);
		} else if(this.isFile() 
				&& this.deplacable ){
			this.isolerFichier(nomDossierDestination);
		}
	}
	
	/**
	 * Déplace un fichier en fonction de ses coordonées GPS.
	 * @param Nwxdossier
	 * @return
	 */
	public boolean DeplacerParLieu(String Nwxdossier){
		String laVille = null;
		if(getGPS() != null)
			laVille = ConnexionGoogle.googleConnexion.getAddress(lat, lon);
		boolean retour = false;
		if(laVille!=null){
			Deplacer(Nwxdossier, laVille);
			retour=true;
		}
		return retour;
	}
	
	/**
	 * On range le fichier dans le dossier déterminé
	 * le dossier est crée si inexistant
	 * @param ledossier
	 */
	private void rangerFichier(File ledossier){
		File adeplacer = new File(ledossier + SEPARATOR + this.getName());
		if ((!ledossier.exists()) && (deplacable)) {
			ledossier.mkdirs();
			this.renameTo(adeplacer);
		} else if (deplacable) {
			this.renameTo(adeplacer);
		}
	}
	
	/**
	 * On isole le fichier en cas de problème
	 * @param Nwxdossier
	 */
	private void isolerFichier(String Nwxdossier){
		File ledossier = new File(Nwxdossier + SEPARATOR + "impossibleadeplacer");
		File adeplacer = new File(ledossier + SEPARATOR + this.getName());
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
	
	/**
	 * On met une image en cache avec une certaine hauteur et largeur
	 * Pour pouvoir l'afficher dans une interface graphique par exemple
	 * @param image
	 * @param Largeur
	 * @param Longueur
	 * @return
	 */
	public BufferedImage convertToBufferedImage(Image image, int Largeur, int Longueur)
	{
	    BufferedImage bi = new BufferedImage(Largeur, Longueur, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(image, 0, 0, Largeur, Longueur, null);
	    g2d.dispose();
	    return bi;
	}
	
	/**
	 * Renvoie le path du fichier
	 */
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
		String mois = Integer.toString(this.getMonthFile());
		String jour = Integer.toString(this.getDayFile());
		if (this.getMonthFile() < 10){
			mois = "0" + mois;
		}
		if (this.getDayFile() < 10){
			jour = "0" + jour;
		}
		if (this.getPriseVue() != null){
			Fichier destination = new Fichier(this.getParentFile() + SEPARATOR + this.getYearFile() + "-" + mois + "-" + jour + " - " + iterator + this.getFileExtension());
			this.renameTo(destination);
		}else{
			System.out.println("Le fichier " + this.getName() + " ne possède pas de date de prise de vue.");
		}
	}
	
	/**
	 * Renommer un fichier avec le lieu de prise de vue
	 * @param iterator
	 */
	public void renommerFichierParLieu(int iterator) {
		if (this.getGPS() != null){
			ConnexionGoogle c = ConnexionGoogle.googleConnexion;
			String ville = c.getAddress(lat, lon);
			Fichier destination = new Fichier(this.getParentFile() + SEPARATOR + ville + " - " + iterator + this.getFileExtension());
			this.renameTo(destination);
			iterator++;
		}else {
			System.out.println("Le fichier " + this.getName() + " ne possède pas de coordonnées GPS.");
		}	
	}
	
	/**
	 * Renommer un fichier avec le choix du nom par l'utilisateur
	 * @param iterator
	 */
	public void renommerFichier(String nom, int iterator){

		File destination = new File(this.getParentFile() + SEPARATOR + nom + " - " + iterator + this.getFileExtension());
		if(!(destination.exists())){
			this.renameTo(destination);
		}else
			System.out.println("Le fichier " + this.getName() + " existe déjà.");
		
	}
	
	//plein d'accesseurs qui servent à rien
	public int getHourFile() {
		return ladatefic.get(Calendar.HOUR);
	}

	public int getMinuteFile() {
		return ladatefic.get(Calendar.MINUTE);
	}

	public int getMonthFile() {
		return ladatefic.get(Calendar.MONTH) + 1;
	}

	public int getDayFile() {
		return ladatefic.get(Calendar.DAY_OF_MONTH);
	}

	public int getYearFile() {
		return ladatefic.get(Calendar.YEAR);
	}

	public Calendar getCalendarFile() {
		return ladatefic;
	}

	public void setCalendarFile(Calendar ladatefic) {
		this.ladatefic = ladatefic;
	}

	public boolean isMovable() {
		return deplacable;
	}

	public String getParentDirectory(){		
		String[] mesRepertoires = this.getParent().toString().split(SEPARATOR);
		int derniereOccurence = mesRepertoires.length - 1;
		return mesRepertoires[derniereOccurence];
	}

	
}
