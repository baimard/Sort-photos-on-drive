package juxo.triephotoV2;

import java.io.IOException;
import java.net.URISyntaxException;

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
		Fichier f = new Fichier("/Users/Romain/Pictures/Baseball2");
		//Fichiers.listFichier(f.listFiles());
		//System.out.println(f.getGPS());
		ConnexionGoogle c = ConnexionGoogle.googleConnexion;
		c = new ConnexionGoogle();
		//System.out.println(c.getAddress(f.getGPS().getLatitude(),f.getGPS().getLongitude()));
		//ConnexionGoogle.googleConnexion.getAddress(f.getGPS().getLatitude(),f.getGPS().getLongitude());
		Fichiers.renommerFichiersParLieu(f.listFiles());
		//Fichiers.renommerFichiers(f.listFiles());
	}
}
