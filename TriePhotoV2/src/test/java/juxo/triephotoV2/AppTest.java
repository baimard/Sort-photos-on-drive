package juxo.triephotoV2;

import java.io.IOException;
import junit.framework.TestCase;
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
	
	public void testRenommage() throws IOException{
		Fichier f = new Fichier("/Users/Romain/Pictures/Baseball2");
		//Fichiers.renommerFichiersParDate(f.listFiles());
		Fichiers.renommerFichiers(f.listFiles());
	}
}
