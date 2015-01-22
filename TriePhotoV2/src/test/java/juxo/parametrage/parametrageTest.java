package juxo.parametrage;

import juxo.system.Parametrage;
import org.junit.Test;

public class parametrageTest {
	
	@Test
	public void testInstanciationParametrage(){
		new Parametrage("/Users/Juxo/Pictures/est", "/Users/Juxo");
	}
	
	@Test
	public void testSerialisationParametrage(){
		Parametrage.getInstance().enregistrerObjet();
	}
	
	@Test
	public void testChargementSerialisationParametrage(){
		Parametrage.chargerObjet();
		Parametrage p = Parametrage.getInstance();
		System.out.println("Dossier source : " + p.getDossierSource() + " Dossier Destination : " + p.getDossierDestination());
	}
}
