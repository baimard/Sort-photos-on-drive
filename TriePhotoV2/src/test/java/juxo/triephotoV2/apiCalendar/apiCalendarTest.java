package juxo.triephotoV2.apiCalendar;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Ignore;
import org.junit.Test;

import juxo.apiCalendar.Calendrier;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.apiCalendar.definitionClasse.Items;
import juxo.apiCalendar.definitionClasse.MediaGroup;

public class apiCalendarTest{

	private final String API_KEY = "125768752842-8kgilik6k7ucmbhph49kqoia3bum3pqr.apps.googleusercontent.com";
	private final String API_SECRET ="oKcIMqOmQKDIuT8_Xhw9SKBE";
	
	@Ignore
	@Test
	public void testAnomalieCode(){
		new ConnexionGoogle("1234",API_KEY, API_SECRET);
		try {
			ConnexionGoogle.googleConnexion.getTokenInformation();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		assert ConnexionGoogle.googleConnexion.getToken().getStatut() == 400;
	}
	
	@Ignore
	@Test
	public void testConnexionGoogle() throws IOException, URISyntaxException{
		ConnexionGoogle c = new ConnexionGoogle(API_KEY, API_SECRET);
		assert c.getToken().getTokenAcess()!=null;
		System.out.println("token google : " + c.getToken().getTokenAcess());
		System.out.println("Refresh token google : " + c.getToken().getRefreshToken());
		System.out.println("token time valide : " + c.getToken().getExpirationDelay());
	}
	
	@Test
	public void testSerialisationNouvelleConnexion() throws IOException, URISyntaxException{
		ConnexionGoogle c = new ConnexionGoogle(API_KEY, API_SECRET);
		assert c.getToken().getTokenAcess()!=null;
		c.getToken().enregistrerObjet();
	}
	
	/*	
	public void testConnexionGoogleToken(){
		new ConnexionGoogle("ya29._ABByRI_zLjcl78pu90hiuE7qRGk05F7Cmxjb7DdZQkHMXFCIcVvcYIwCghgVN_C8qB-EdKdWQNFyg", API_KEY, API_SECRET);
	}
	
	public void testRefreshToken(){
		ConnexionGoogle.googleConnexion.getToken().setRefreshToken("1/1jBVZ4Sw9bxIuJtJ0wtPgRk11Smk4OWh0UbJlg0Hrap90RDknAdJa_sgfheVM0XT");
		ConnexionGoogle.googleConnexion.buildRefreshToken();
		System.out.println("new token google : " + ConnexionGoogle.googleConnexion.getToken().getTokenAcess());
		System.out.println("Refresh token google : " + ConnexionGoogle.googleConnexion.getToken().getRefreshToken());
		System.out.println("token time valide : " + ConnexionGoogle.googleConnexion.getToken().getExpirationDelay());
	}*/

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
		
		Calendrier.getCalendriers().enregistrerObjet();
	}
	
}
