package juxo.triephotoV2.apiCalendar;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;
import juxo.apiCalendar.definitionClasse.Items;
import juxo.apiCalendar.definitionClasse.MediaGroup;




public class apiCalendarTest extends TestCase {

	private final String API_KEY = "125768752842-8kgilik6k7ucmbhph49kqoia3bum3pqr.apps.googleusercontent.com";
	private final String API_SECRET ="oKcIMqOmQKDIuT8_Xhw9SKBE";
	
	/*
	public void testConnexionGoogle() throws IOException, URISyntaxException{
		ConnexionGoogle c = new ConnexionGoogle(API_KEY, API_SECRET);
		assert c.token.tokenAcess!=null;
		System.out.println("token google : " + c.token.tokenAcess);
		System.out.println("Refresh token google : " + c.token.refreshToken);
		System.out.println("token time valide : " + c.token.expirationDelay);
	}*/
	
	/*public void testRefreshToken(){
	ConnexionGoogle.googleConnexion.token.refreshToken();
	System.out.println("new token google : " + ConnexionGoogle.googleConnexion.token.tokenAcess );
	System.out.println("Refresh token google : " + ConnexionGoogle.googleConnexion.token.refreshToken);
	System.out.println("token time valide : " + ConnexionGoogle.googleConnexion.token.expirationDelay);
	}*/

	@Test
	public void testConnexionGoogleToken(){
		new ConnexionGoogle("ya29.-wAGmcwE_AZXyG2Q1cXXKby_-oFOtEryVT6eHILKiZFhji-e8vmB70lC5M6TvYyqJHm1pxSyG7C0oQ");
	}
	
	@Test
	public void testExpireDelayToken(){
		ConnexionGoogle.googleConnexion.getTokenInformation();
		System.out.println(ConnexionGoogle.googleConnexion.token);
	}

	public void testReceptionDonnees(){
		ConnexionGoogle c = ConnexionGoogle.googleConnexion;
		if(c!=null){
			MediaGroup m = c.accessListCalendrier();
			for(Items i : m.items){
				System.out.println(i.getSummary());
			}
		}
	}
	
}
