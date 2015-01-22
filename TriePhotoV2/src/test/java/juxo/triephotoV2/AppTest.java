package juxo.triephotoV2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;

import javassist.bytecode.Descriptor.Iterator;
import junit.framework.TestCase;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.Fichiers;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase
{
	/*public void testChargementFichier() throws IOException{
		Fichier f = new Fichier("/Users/Romain/Pictures/Baseball");
		Fichiers.listFichier(f.listFiles());
		Map<Calendar, Fichiers> listFic = Fichier.listFic;
	}*/
	
	public void testRenommage() throws IOException, URISyntaxException{
		Fichier f = new Fichier("/Users/Juxo/Pictures/est");
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
			mesFichiers.renommerFichiersParLieu();
		}
		//Fichiers.renommerFichiers(f.listFiles(), "Pessac");
	}
}
