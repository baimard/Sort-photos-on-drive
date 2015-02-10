package juxo.ui;

import java.io.IOException;
import java.util.Date;

import javax.swing.JFrame;

import juxo.UiTriePhotoV2.UiParametre;
import juxo.UiTriePhotoV2.UiPremierDemarrage;
import juxo.UiTriePhotoV2.UiQuestion;
import juxo.UiTriePhotoV2.UiUser;
import juxo.apiCalendar.Evenement;
import juxo.apiCalendar.Evenements;
import juxo.triephotoV2.accessFichier.Fichier;
import juxo.triephotoV2.accessFichier.Fichiers;

import org.junit.Ignore;
import org.junit.Test;

public class UiTest {
	
	@Ignore
	
	@Test
    public void testUiQuestion() throws InterruptedException {
		
		Evenement e1 = new Evenement("testEv", new Date(1,1,2015), new Date(2,1,2015));
		Evenements evenements = new Evenements();
		evenements.add(e1);
		
		Fichier f1 = new Fichier("C:\\Users\\RAKOTOMALALA\\Documents\\Projet Image Test\\dossier-icone.png");
		Fichier f2 = new Fichier("C:\\Users\\RAKOTOMALALA\\Documents\\Projet Image Test\\encre-icone.png");
		Fichier f3 = new Fichier("C:\\Users\\RAKOTOMALALA\\Documents\\Projet Image Test\\google-icone.png");
		Fichier f4 = new Fichier("C:\\Users\\RAKOTOMALALA\\Documents\\Projet Image Test\\horloge-icone.png");
		Fichier f5 = new Fichier("C:\\Users\\RAKOTOMALALA\\Documents\\Projet Image Test\\icone-pioupiou.jpg");

		Fichier f6 = new Fichier("C:\\Users\\RAKOTOMALALA\\Documents\\Projet Image Test\\modules-icone.png");
		Fichier f7 = new Fichier("C:\\Users\\RAKOTOMALALA\\Documents\\Projet Image Test\\parametres-icone.png");
		Fichier f8 = new Fichier("C:\\Users\\RAKOTOMALALA\\Documents\\Projet Image Test\\pictograms-nps-services-library.png");
		Fichiers fichiers = new Fichiers();

	//	Fichier f6 = new Fichier("C:\\Users\\RAKOTOMALALA\\Documents\\Projet Image Test\\modules-icone.png");
	//	Fichier f7 = new Fichier("C:\\Users\\RAKOTOMALALA\\Documents\\Projet Image Test\\parametres-icone.png");
	//	Fichier f8 = new Fichier("C:\\Users\\RAKOTOMALALA\\Documents\\Projet Image Test\\pictograms-nps-services-library.png");
		
//Fichiers fichiers = new Fichiers();
                 

		fichiers.add(f1);
		fichiers.add(f2);
		fichiers.add(f3);
		fichiers.add(f4);
		fichiers.add(f5);
		fichiers.add(f6);
		fichiers.add(f7);
		fichiers.add(f8);
		
		UiQuestion quest = new UiQuestion(null, "Test", true, evenements, fichiers);
		quest.showUiQuestion();
		//Thread.sleep(5000);
	}
	
	@Ignore
	@Test
	public void testUiParametre() throws InterruptedException  {
		UiParametre param = new UiParametre();
		Thread.sleep(50000);
	}
	
	
	@Test
	public void testUiPremierDemarrage() throws InterruptedException  {
		UiPremierDemarrage param = new UiPremierDemarrage();
		Thread.sleep(50000);
	}
	
	@Ignore
	@Test
	public void testUiUser() throws InterruptedException {
		UiUser gui = new UiUser();
		Thread.sleep(10000);
	
}

}

