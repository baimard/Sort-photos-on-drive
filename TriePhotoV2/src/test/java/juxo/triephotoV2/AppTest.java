package juxo.triephotoV2;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import juxo.threads.ProcessChargementFichier;
import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.Fichiers;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	/*public void testChargementFichier() throws IOException{
		Fichier f = new Fichier("/Users/Romain/Pictures/Baseball");
		Fichiers.listFichier(f.listFiles());
		Map<Calendar, Fichiers> listFic = Fichier.listFic;
	}*/
	
	public void testRenommage() throws IOException{
		Fichier f = new Fichier("/Users/Romain/Pictures/Baseball2");
		Fichiers.renommerFichiers(f.listFiles());
		//Fichiers.listFichier(f.listFiles());
		//f.renommerFichier(f);
	}
}
