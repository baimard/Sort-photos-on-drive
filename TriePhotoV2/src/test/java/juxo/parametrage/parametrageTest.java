package juxo.parametrage;

import juxo.system.Parametrage;

import org.junit.Ignore;
import org.junit.Test;

public class parametrageTest {
	
	@Ignore
	@Test
	public void testInstanciationParametrage(){
		new Parametrage("/Users/Juxo/Pictures/est", "/Users/Juxo");
	}
	
	@Ignore
	@Test
	public void testSerialisationParametrage(){
		Parametrage.getInstance().enregistrerObjet();
	}
	
	@Ignore
	@Test
	public void testChargementSerialisationParametrage(){
		Parametrage.chargerObjet();
		Parametrage p = Parametrage.getInstance();
		System.out.println("Dossier source : " + p.getDossierSource() + " Dossier Destination : " + p.getDossierDestination());
	}
	
	
	@Test 
	public void testOs(){
		new Parametrage("/Users/Juxo/Pictures/est", "/Users/Juxo");
		System.out.println(Parametrage.getInstance().SEPARATOR);
			
	}
}
