package juxo.triephotoV2.apiCalendar;

import java.io.IOException;
import java.net.URISyntaxException;

import junit.framework.TestCase;
import juxo.apiCalendar.connexionGoogle.ConnexionGoogle;




public class apiCalendarTest extends TestCase {

	private final String API_KEY = "125768752842-8kgilik6k7ucmbhph49kqoia3bum3pqr.apps.googleusercontent.com";
	private final String API_SECRET ="oKcIMqOmQKDIuT8_Xhw9SKBE";
	
	public void testConnexionGoogle() throws IOException, URISyntaxException{
		ConnexionGoogle c = new ConnexionGoogle(API_KEY, API_SECRET);
		assert c.token.tokenAcess!=null;
	}
	
}
