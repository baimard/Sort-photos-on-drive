package juxo.triephotoV2;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.junit.Test;
import org.junit.Ignore;
import juxo.apiCalendar.Calendrier;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.apiCalendar.definitionClasse.Items;
import juxo.apiCalendar.definitionClasse.MediaGroup;
import juxo.system.Parametrage;
import juxo.threads.ProcessChargementEvenements;
import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.FichierComparatorDirectoryParent;
import juxo.triephotoV2.accessFichier.Fichiers;
import juxo.triephotoV2.methode.AbstractSortMethod;
import juxo.triephotoV2.methode.SortByDayDate;
import juxo.triephotoV2.methode.SortByEvent;
import juxo.triephotoV2.methode.SortByPlace;

/**
 * Unit test for simple App.
 */
public class AppTest
{

	@Test
	public void testRenommage() throws IOException, URISyntaxException{
		ConnexionGoogle.googleConnexion = new ConnexionGoogle();
		
		Fichier f = new Fichier("/Users/Romain/Pictures/Baseball2");
		Fichiers.listFichier(f.listFiles());
		Fichiers maCollec = Fichier.listFic.getAllFichierItem();
		Collections.sort(maCollec, new FichierComparatorDirectoryParent());
		//maCollec.renommerFichiersParLieu();
		//maCollec.renommerFichiers("Lé a");
		maCollec.renommerFichiersParDate();
		/*for (Fichier fic : maCollec){
			System.out.println(fic);
		}*/
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
			Collections.sort(mesFichiers, new FichierComparatorDirectoryParent());
			for (Fichier fic : mesFichiers){
				System.out.println(fic);
			}
		}
	}
	
	@Ignore
	@Test
	public void testTrieFichier() throws IOException{
		Fichier f = new Fichier("/Users/Romain/Pictures/Baseball2");
		Fichiers.listFichier(f.listFiles());
		ArrayList<Fichier> maCollec = Fichier.listFic.getAllFichierItem();
	//	Collections.sort(maCollec, new FichierComparatorDate());
		Collections.sort(maCollec, new FichierComparatorDirectoryParent());
		for (Fichier fic : maCollec){
			System.out.println(fic);
		}
	}
	
	@Ignore
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
		
		AbstractSortMethod sortEvent = new SortByEvent(1);
		sortEvent.trie();
				
		AbstractSortMethod sort = new SortByPlace(1);
		sort.trie();

		AbstractSortMethod sortNormal = new SortByDayDate(1);
		sortNormal.trie();
		
	}
}
