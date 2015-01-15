package juxo.apiCalendar.connexionGoogle;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import javax.swing.JOptionPane;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Feature;

import juxo.apiCalendar.definitionClasse.Erreur;
import juxo.apiCalendar.definitionClasse.InfoToken;
import juxo.apiCalendar.definitionClasse.MediaGroup;

import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;

/***
 * 
 * @author benjamin AIMARD
 *Permet d'obtenir un token pour une connexion aux ressources google api
 */
public class ConnexionGoogle {
	
	public static ConnexionGoogle googleConnexion = null;
	
	public static String CALENDAR_SCOPE = "https://www.googleapis.com/auth/calendar";
	public OAuth2Token token;
	
	//Réponse quand on demande des données
	public static MediaGroup m;
	
	private String API_KEY;
	private String API_SECRET;
	
	/**
	 * Renvoie une connexion aux API GOOGLE
	 * https://console.developers.google.com/
	 * @param api_key
	 * @param secret
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public ConnexionGoogle (String api_key, String secret) throws IOException, URISyntaxException{
		
		API_KEY = api_key;
		API_SECRET = secret;
		
		buildRequestToken();
		openResquestTokenUrl();
		
		//Fenêtre pour copier le lien input
		String code = JOptionPane.showInputDialog("Veuillez indiquer le code retour");
		token.doAccessTokenRequest(code);
		
		if(googleConnexion==null){
			googleConnexion=this;
		}
		
	}
	
	/***
	 * Fournit une connexion si on a déjà un TOKEN (Jeton)
	 * @param token
	 */
	public ConnexionGoogle(String token){
		this.token = new OAuth2Token(token);
		
		if(googleConnexion==null){
			googleConnexion=this;
		}
	}
	
	/***
	 * Génère un objet token qui permettra d'effectuer les requêtes http à google
	 * le callbackUri est fournit par google
	 * https://console.developers.google.com/
	 * @param callbackURI
	 * @return
	 */
	public void buildRequestToken() {
		ClientIdentifier clientId = new ClientIdentifier(API_KEY, API_SECRET);
		token = new OAuth2Token(clientId, CALENDAR_SCOPE);
	}
	
	/**
	 * Ouvre dans le navigateur favoris de l'utilisateur le lien de valdiation
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public void openResquestTokenUrl() throws IOException, URISyntaxException{
		if(Desktop.isDesktopSupported()){
			  Desktop.getDesktop().browse(new URI(token.authURI));
			}
	}
	
	/***
	 * Renvoie un calendrier selon le nom du calendrier
	 * Il faut avoir obtenu un token au préalable
	 * @param nomCalendrier
	 * @return
	 */
	public MediaGroup accessCalendrier(String nomCalendrier){
		m = null;
    	Feature filterFeature = OAuth2ClientSupport.feature(token.tokenAcess);
		Client client = ClientBuilder.newBuilder().register(filterFeature).build();
		WebTarget service = null;

		try{
			
			String s = "https://www.googleapis.com/calendar/v3/calendars/"+URLEncoder.encode(nomCalendrier)+"/events?maxResults=2500&key="+API_KEY;
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
    	Feature filterFeature = OAuth2ClientSupport.feature(token.tokenAcess);
		Client client = ClientBuilder.newBuilder().register(filterFeature).build();
		WebTarget service = null;
		try {
			service = client.target(new URI("https://www.googleapis.com/calendar/v3/users/me/calendarList?key="+API_KEY));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m = service.request().get(MediaGroup.class);
		return m;
	}
	
	
	public void getTokenInformation() throws URISyntaxException {
		Feature filterFeature = OAuth2ClientSupport.feature(token.tokenAcess);
		Client client = ClientBuilder.newBuilder().register(filterFeature).build();
		WebTarget service = null;	
		service = client.target(new URI("https://www.googleapis.com/oauth2/v1/tokeninfo?access_token="+token.tokenAcess));
		Builder b = service.request();
		try{
			InfoToken tok = b.get(InfoToken.class);
			token.expirationDelay = tok.getExpires_in();
		}catch(BadRequestException e){
			Erreur err = b.get(Erreur.class);
			token.statut=err.getErrorDescription();
		}
		
		
	}
	
}
