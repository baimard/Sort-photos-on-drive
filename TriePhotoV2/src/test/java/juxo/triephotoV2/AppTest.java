package juxo.triephotoV2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import org.junit.Test;
import org.junit.Ignore;
import javassist.bytecode.Descriptor.Iterator;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.Fichiers;

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
	@Test
	public void testRenommage() throws IOException, URISyntaxException{
		Fichier f = new Fichier("/Users/Romain/Pictures/Baseball2");
		//Fichiers.listFichier(f.listFiles());
		//System.out.println(f.getGPS());
		ConnexionGoogle c = ConnexionGoogle.googleConnexion;
		c = new ConnexionGoogle();
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

	@Test
	public void testChargementFichiers() throws IOException{
		Fichier f = new Fichier("/Users/Romain/Pictures/Baseball2");
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
}
