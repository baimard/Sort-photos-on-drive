package juxo.triephotoV2.apiCalendar;

import java.io.IOException;
import java.net.URISyntaxException;
import junit.framework.TestCase;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.apiCalendar.definitionClasse.Items;
import juxo.apiCalendar.definitionClasse.MediaGroup;




public class apiCalendarTest extends TestCase {

	private final String API_KEY = "125768752842-8kgilik6k7ucmbhph49kqoia3bum3pqr.apps.googleusercontent.com";
	private final String API_SECRET ="oKcIMqOmQKDIuT8_Xhw9SKBE";
	
	
	public void testAnomalieCode(){
		new ConnexionGoogle("1234",API_KEY, API_SECRET);
		try {
			ConnexionGoogle.googleConnexion.getTokenInformation();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assert ConnexionGoogle.googleConnexion.token.statut == 400;
	}
	
	/*
	public void testConnexionGoogle() throws IOException, URISyntaxException{
		ConnexionGoogle c = new ConnexionGoogle(API_KEY, API_SECRET);
		assert c.token.tokenAcess!=null;
		System.out.println("token google : " + c.token.tokenAcess);
		System.out.println("Refresh token google : " + c.token.refreshToken);
		System.out.println("token time valide : " + c.token.expirationDelay);
	}*/
	
	public void testConnexionGoogleToken(){
		new ConnexionGoogle("ya29._ABByRI_zLjcl78pu90hiuE7qRGk05F7Cmxjb7DdZQkHMXFCIcVvcYIwCghgVN_C8qB-EdKdWQNFyg", API_KEY, API_SECRET);
	}
	
	
	public void testRefreshToken(){
		ConnexionGoogle.googleConnexion.token.refreshToken=("1/1jBVZ4Sw9bxIuJtJ0wtPgRk11Smk4OWh0UbJlg0Hrap90RDknAdJa_sgfheVM0XT");
		ConnexionGoogle.googleConnexion.buildRefreshToken();
		System.out.println("new token google : " + ConnexionGoogle.googleConnexion.token.tokenAcess );
		System.out.println("Refresh token google : " + ConnexionGoogle.googleConnexion.token.refreshToken);
		System.out.println("token time valide : " + ConnexionGoogle.googleConnexion.token.expirationDelay);
	}

	
	public void testExpireDelayToken(){
		try {
			ConnexionGoogle.googleConnexion.getTokenInformation();
		} catch (URISyntaxException e) {
			System.out.println(e);
		}
		System.out.println(ConnexionGoogle.googleConnexion.token);
	}

	public void testReceptionDonnees(){
		if(ConnexionGoogle.googleConnexion.token.expirationDelay!=0){
			ConnexionGoogle c = ConnexionGoogle.googleConnexion;
			if(c!=null){
				MediaGroup m = c.accessListCalendrier();
				for(Items i : m.items){
					System.out.println(i.getSummary());
				}
			}
		}
	}
	
}
