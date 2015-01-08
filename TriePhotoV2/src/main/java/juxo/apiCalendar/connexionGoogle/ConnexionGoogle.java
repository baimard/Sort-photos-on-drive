package juxo.apiCalendar.connexionGoogle;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import javassist.NotFoundException;

import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;

import juxo.apiCalendar.definitionClasse.MediaGroup;

import org.glassfish.jersey.client.oauth1.ConsumerCredentials;
import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;

/***
 * 
 * @author Juxo
 *Permet d'obtenir un token pour une connexion aux ressources google api
 */
public class ConnexionGoogle {
	public static ConnexionGoogle googleConnexion = null;
	//Pour obtenir un code de retour
	public static String OOB = "urn:ietf:wg:oauth:2.0:oob";
	//Lien d'accès API
	public static String CALENDAR_SCOPE = "https://www.googleapis.com/auth/calendar";
	
	public OAuth2Token token;
	//Réponse quand on demande des données
	public static MediaGroup m;
	//Identification utilisateur
	private ConsumerCredentials credentials;
	
	
	/***
	 * Si on a déjà une clef d'accès
	 * @param token
	 */
	public ConnexionGoogle(String token){
		this.token = new OAuth2Token(token);
	}
	
	/***
	 * Indiquer la clef et le secret fournit par google dans
	 * https://console.developers.google.com/
	 * @param api_key
	 * @param secret
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public ConnexionGoogle (String api_key, String secret) throws IOException, URISyntaxException{
		//Information d'authentification
		credentials = new ConsumerCredentials(api_key,secret);
		this.buildToken(this.OOB);
		//Permet d'ouvrir un lien dans un explorateur Internet
		if(Desktop.isDesktopSupported()){
		  Desktop.getDesktop().browse(new URI(token.getValidateURI()));
		}
		
		String response = JOptionPane.showInputDialog("Veuillez indiquer le code retour");
		this.initToken(token, response);
	}
	
	/***
	 * Génère un objet token qui permettra d'effectuer les requêtes http à google
	 * le callbackUri est fournit par google
	 * https://console.developers.google.com/
	 * @param callbackURI
	 * @return
	 */
	public OAuth2Token buildToken(String callbackURI) {
		ClientIdentifier clientId = new ClientIdentifier(
				credentials.getConsumerKey(), credentials.getConsumerSecret());
		token = new OAuth2Token(clientId, callbackURI, CALENDAR_SCOPE);
		return token;
	}
	
	/***
	 * Renvoie un calendrier selon le nom du calendrier
	 * Il faut avoir obtenu un token au préalable
	 * @param target
	 * @return
	 */
	public MediaGroup accessCalendrier(String target){
		m = null;
    	Feature filterFeature = OAuth2ClientSupport.feature(token.getToken());
		Client client = ClientBuilder.newBuilder().register(filterFeature).build();
		WebTarget service = null;

		try{
			
			String s = "https://www.googleapis.com/calendar/v3/calendars/"+URLEncoder.encode(target)+"/events?maxResults=2500&key="+credentials.getConsumerKey();
			service = client.target(s);
			m = service.request().get(MediaGroup.class);
		}catch(javax.ws.rs.NotFoundException e){
			System.out.println(e);
		}

		return m;
	}
	
	/***
	 * Renvoie la liste des calendriers
	 * Il faut avoir obtenu un token au préalable
	 * @param target
	 * @return
	 */
	public MediaGroup accessListCalendrier(){
		m = null;
    	Feature filterFeature = OAuth2ClientSupport.feature(token.getToken());
		Client client = ClientBuilder.newBuilder().register(filterFeature).build();
		WebTarget service = null;
		try {
			service = client.target(new URI("https://www.googleapis.com/calendar/v3/users/me/calendarList?key="+credentials.getConsumerKey()));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m = service.request().get(MediaGroup.class);
		return m;
	}
	
	/***
	 * On donne le code fournit par google lorsque que l'on a obtenu
	 * un lien pour une demande de connexion et que l'on a validé
	 * @param token
	 * @param code
	 */
	public void initToken(OAuth2Token token, String code) {
		token.doAccessTokenRequest(code);
	}
	
}
