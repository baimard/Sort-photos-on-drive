package juxo.triephotoV2.accessFichier;
import java.util.ArrayList;
import juxo.notification.AfficherNotification;

/**
 * Surcharge de la class Arraylist
 * Pour adapter nos méthodes à utiliser sur la liste de fichiers
 * @author Juxo
 *
 */
public class Fichiers extends ArrayList<Fichier>{
	private static final long serialVersionUID = 1L;
	

	/**
	 * Déplace les fichiers de la liste dans le nouveau nom de dossier
	 * @param Nwxdossier
	 * @param nomDossier
	 */
	public void deplacerTousLesFichier(String nomDossierDestination, String nomDossier){
		for(Fichier f : this){
			f.Deplacer(nomDossierDestination, nomDossier);
		}
	}
	
	/**
	 * Déplace tous les fichiers sans indiquer de nouveau dossier
	 * Donc par ANNEES ET PAR MOIS
	 * @param Nwxdossier
	 */
	public void deplacerTousLesFichier(String nomDossierDestination){
		for(Fichier f : this){
			f.Deplacer(nomDossierDestination);
		}
	}
	
	/**
	 * Déplace les fichier dans un dossier avec la date du jour de prise de vue
	 * @param nomDossierDestination
	 */
	public void deplacerTousLesFichierDateJour(String nomDossierDestination){
		for(Fichier f: this){
			f.Deplacer(nomDossierDestination, Integer.toString(f.getDayFile()));
		}
	}
	
	/**
	 * Déplace par lieu de prise de vue
	 * Puis efface le fichier de la liste pour pouvoir effectuer une nouvelle itération
	 * @param Nwxdossier
	 */
	public void deplacerTousLesFichiersParLieu(String nomDossierDestination){
		
		ArrayList<Fichier> faSupprimer = new ArrayList<Fichier>();
		for(Fichier f : this){
			if(f.DeplacerParLieu(nomDossierDestination)){
				faSupprimer.add(f);
			}
		}
		supprimerFichier(faSupprimer);
	}

	/**
	 * Supprimer un fichier d'une liste de fichiers
	 * @param f
	 */
	public void supprimerFichier(ArrayList<Fichier> f){
		for(Fichier fic : f){
			this.remove(fic);
		}
	}
	
	/**
	 * Fontion de renommage des fichiers par date
	 * @param listeFichiers
	 */
	public void renommerFichiersParDate(){
		int it=1;
		//On parcours tous les fichiers
		for (Fichier fichierCourant : this) {
			int index = this.indexOf(fichierCourant);
			if (fichierCourant.isFile()) {
				if(index+1 < this.size()){
					if(fichierCourant.getParentFile().compareTo(this.get(index+1).getParentFile()) == 0){
						fichierCourant.renommerFichierParDate(it++);
					}
					else{
						fichierCourant.renommerFichierParDate(it++);
						it=1;
					}
				}
				else{
					fichierCourant.renommerFichierParDate(it++);
				}
			}	
		}
	}
	
	/**
	 * Fontion de renommage des fichiers en fonction du lieu de prise de vue
	 * @param listeFichiers
	 */
	public void renommerFichiersParLieu(){
		int it=1;
		//On parcours tous les fichiers
		for (Fichier fichierCourant : this) {
			int index = this.indexOf(fichierCourant);
			if (fichierCourant.isFile()) {
				if(index+1 < this.size()){
					if(fichierCourant.getParentFile().compareTo(this.get(index+1).getParentFile()) == 0){
						fichierCourant.renommerFichierParLieu(it);
					}
					else{
						fichierCourant.renommerFichierParLieu(it);
						it=1;
					}
				}
				else{
					fichierCourant.renommerFichierParLieu(it);
				}
			}	
		}
	}
	
	/**
	 * Fontion de renommage des fichiers simple
	 * @param listeFichiers
	 * @param nom
	 */
	public void renommerFichiers(String nom){
		int it=1;
		if(nom != null && nom.isEmpty() || nom.trim().length() <= 0){
			AfficherNotification.AfficherMsgNotification("Attention, le nom de vos fichiers ne doit pas être nul");
		}
		else if (isThisStringValid(nom)){
			for (Fichier fichierCourant : this) {
				int index = this.indexOf(fichierCourant);
				if (fichierCourant.isFile()) {
					if(index+1 < this.size()){
						if(fichierCourant.getParentFile().compareTo(this.get(index+1).getParentFile()) == 0){
							fichierCourant.renommerFichier(nom, it++);
						}
						else{
							fichierCourant.renommerFichier(nom, it++);
							it=1;
						}
					}
					else{
						fichierCourant.renommerFichier(nom, it++);
					}
				}	
			}				
		}else{
			AfficherNotification.AfficherMsgNotification("Attention, le nom " + nom + " contient un ou plusieurs caractères interdits. Les caractères interdits sont / \\ : * ? \" < > |");
		}
	}
	
	/**
	 * Vérifie la validité d'une string pour renommer un fichier
	 * (Modifier pour utiliser une REGEX)
	 * @param s
	 * @return
	 */
	public boolean isThisStringValid(String s)
    {
        for (int i=0 ; i<s.length() ; i++)
        {
            if (s.charAt(i) == '/' || s.charAt(i) == '\\' ||
                s.charAt(i) == ':' || s.charAt(i) == '*' ||
                s.charAt(i) == '?' || s.charAt(i) == '"' ||
                s.charAt(i) == '<' || s.charAt(i) == '>' ||
                s.charAt(i) == '|' || s.length()>254)
                return false;
        }
        return true;
    }
	
}
