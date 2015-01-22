package juxo.triephotoV2;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;
import org.junit.Ignore;

import juxo.apiCalendar.Calendrier;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.apiCalendar.definitionClasse.Items;
import juxo.apiCalendar.definitionClasse.MediaGroup;
import juxo.system.Parametrage;
import juxo.threads.ProcessChargementEvenements;
import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.Fichiers;
import juxo.triephotoV2.accessFichier.MapDateFichiers;
import juxo.triephotoV2.methode.AbstractSortMethod;
import juxo.triephotoV2.methode.SortByDayDate;
import juxo.triephotoV2.methode.SortByEvent;
import juxo.triephotoV2.methode.SortByPlace;
import juxo.triephotoV2.methode.SortNormal;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	/*public void testChargementFichier() throws IOException{
		Fichier f = new Fichier("/Users/Romain/Pictures/Baseball");
		Fichiers.listFichier(f.listFiles());
		Map<Calendar, Fichiers> listFic = Fichier.listFic;
	}*/
	@Ignore
	@Test
	public void testRenommage() throws IOException, URISyntaxException{
		Fichier f = new Fichier("/Users/Juxo/Pictures/est");
		//Fichiers.listFichier(f.listFiles());
		//System.out.println(f.getGPS());
		ConnexionGoogle.googleConnexion = new ConnexionGoogle();
		//System.out.println(c.getAddress(f.getGPS().getLatitude(),f.getGPS().getLongitude()));
		//ConnexionGoogle.googleConnexion.getAddress(f.getGPS().getLatitude(),f.getGPS().getLongitude());
		Fichiers.listFichier(f.listFiles());
		java.util.Iterator<Calendar> i = Fichier.listFic.keySet().iterator();
		while(i.hasNext()){
			Calendar cal = i.next();
			Fichiers mesFichiers = Fichier.listFic.get(cal);
			//mesFichiers.renommerFichiersParLieu();
			mesFichiers.renommerFichiers("Pessac");
			
		}
	}
	@Ignore
	@Test
	public void testChargementFichiers() throws IOException{
		Fichier f = new Fichier("/Users/Juxo/Pictures/est");
		Fichiers.listFichier(f.listFiles());
		java.util.Iterator<Calendar> i = Fichier.listFic.keySet().iterator();
		while(i.hasNext()){
			Calendar cal = i.next();
			Fichiers mesFichiers = Fichier.listFic.get(cal);
			for (Fichier fic : mesFichiers){
				System.out.println(fic);
			}
		}
	}
	
	@Test
	public void testTrieFichiersDepuisLaMap() throws IOException, URISyntaxException, InterruptedException{
		new ConnexionGoogle();
		ArrayList<String> s = new ArrayList<String>();
		if(ConnexionGoogle.googleConnexion.getToken().getExpirationDelay()!=0){
			ConnexionGoogle c = ConnexionGoogle.googleConnexion;
			if(c!=null){
				MediaGroup m = c.accessListCalendrier();
				for(Items i : m.items){
					System.out.println(i.getSummary());
					new Calendrier(i.summary);
					s.add(i.getId());
				}
			}
		}
		

		Thread tConnexionGoogle = new ProcessChargementEvenements(s);
		tConnexionGoogle.start();
		tConnexionGoogle.join();
		
		new Parametrage("/Users/Juxo/Pictures/est", "/Users/Juxo/Pictures/est/trie");
		Fichiers.listFichier(new File(Parametrage.getInstance().getDossierSource()).listFiles());
		
		MapDateFichiers map = Fichier.listFic;
		
		AbstractSortMethod sortEvent = new SortByEvent(1);
		sortEvent.trie();
		
		map = Fichier.listFic;
		
		AbstractSortMethod sort = new SortByPlace(1);
		sort.trie();
		
		map = Fichier.listFic;
		
		AbstractSortMethod sortNormal = new SortByDayDate(1);
		sortNormal.trie();
		
	}
}
