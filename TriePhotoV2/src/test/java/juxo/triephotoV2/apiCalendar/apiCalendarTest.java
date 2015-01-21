package juxo.triephotoV2.apiCalendar;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Ignore;
import org.junit.Test;

import juxo.apiCalendar.Calendrier;
import juxo.apiCalendar.Calendriers;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.apiCalendar.definitionClasse.Items;
import juxo.apiCalendar.definitionClasse.MediaGroup;

public class apiCalendarTest{
	
	@Ignore
	@Test
	public void testAnomalieCode(){
		new ConnexionGoogle("1234");
		try {
			ConnexionGoogle.googleConnexion.getTokenInformation();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		assert ConnexionGoogle.googleConnexion.getToken().getStatut() == 400;
	}
	
	@Test
	public void testConnexionGoogle() throws IOException, URISyntaxException{
		ConnexionGoogle c = new ConnexionGoogle();
		assert c.getToken().getTokenAcess()!=null;
		System.out.println("token google : " + c.getToken().getTokenAcess());
		System.out.println("Refresh token google : " + c.getToken().getRefreshToken());
		System.out.println("token time valide : " + c.getToken().getExpirationDelay());
	}
	
	@Test
	public void testGetAddress(){
		ConnexionGoogle c = ConnexionGoogle.googleConnexion;
		System.out.println(c.getAdrress(48.8588589,2.3470599));
		System.out.println(c.getAdrress(44.8688317,-0.6803284));
		System.out.println(c.getAdrress(45.0472061,-0.43125));
		System.out.println(c.getAdrress(31.2243489,121.4767528));
	}
	
	
	@Ignore
	@Test
	public void testSerialisationNouvelleConnexion() throws IOException, URISyntaxException{
		ConnexionGoogle c = new ConnexionGoogle();
		assert c.getToken().getTokenAcess()!=null;
		c.enregistrerObjet();
	}
	
	@Ignore
	@Test
	public void testConnexionGoogleToken(){
		new ConnexionGoogle("ya29._ABByRI_zLjcl78pu90hiuE7qRGk05F7Cmxjb7DdZQkHMXFCIcVvcYIwCghgVN_C8qB-EdKdWQNFyg");
	}
	
	@Ignore
	@Test
	public void testRefreshToken(){
		ConnexionGoogle.googleConnexion.getToken().setRefreshToken("1/1jBVZ4Sw9bxIuJtJ0wtPgRk11Smk4OWh0UbJlg0Hrap90RDknAdJa_sgfheVM0XT");
		ConnexionGoogle.googleConnexion.buildRefreshToken();
		System.out.println("new token google : " + ConnexionGoogle.googleConnexion.getToken().getTokenAcess());
		System.out.println("Refresh token google : " + ConnexionGoogle.googleConnexion.getToken().getRefreshToken());
		System.out.println("token time valide : " + ConnexionGoogle.googleConnexion.getToken().getExpirationDelay());
	}

	@Ignore
	@Test
	public void testExpireDelayToken(){
		try {
			ConnexionGoogle.googleConnexion.getTokenInformation();
		} catch (URISyntaxException e) {
			System.out.println(e);
		}

		System.out.println(ConnexionGoogle.googleConnexion.getToken());

	}

	@Ignore
	@Test
	public void testReceptionDonnees(){
		if(ConnexionGoogle.googleConnexion.getToken().getExpirationDelay()!=0){
			ConnexionGoogle c = ConnexionGoogle.googleConnexion;
			if(c!=null){
				MediaGroup m = c.accessListCalendrier();
				for(Items i : m.items){
					System.out.println(i.getSummary());
					new Calendrier(i.summary);
				}
			}
		}
	}
	@Ignore
	@Test
	public void testSerialisationCalendrier(){
		Calendrier.getCalendriers().enregistrerObjet();
	}
	
	@Ignore
	@Test
	public void deserialisationCalendrier(){
		Calendriers.chargerCalendrier();
		for(Calendrier i : Calendrier.getCalendriers()){
			System.out.println(i.getNomCalendrier());
		}
	}
	
}
