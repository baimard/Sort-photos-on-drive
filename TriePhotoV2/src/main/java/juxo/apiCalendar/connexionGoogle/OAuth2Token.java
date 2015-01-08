package juxo.apiCalendar.connexionGoogle;

import javax.ws.rs.client.Client;

import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow.Builder;
import org.glassfish.jersey.client.oauth2.OAuth2FlowGoogleBuilder;
import org.glassfish.jersey.client.oauth2.TokenResult;

public class OAuth2Token {
	
    private OAuth2CodeGrantFlow flow;
    private String authURI;
    private String token;
    private String refreshToken;
    private String type; 
    private int expirationDelay;
    
    /***
     * Si on a déjà une clef d'accès
     * @param token
     */
    public OAuth2Token(String token) {
    	this.token = token;
    }
    /***
     * Construction d'un objet token selon les spécifications google
     * @param clientId
     * @param callbackURI
     * @param scope
     */
    public OAuth2Token(ClientIdentifier clientId, String callbackURI, String scope) {
    	Builder<OAuth2FlowGoogleBuilder> builder = OAuth2ClientSupport
				.googleFlowBuilder(clientId, callbackURI, scope);

		flow = builder
				.property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION, "readOnly","true")
				.property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION,"redirect_uri", callbackURI)
				.property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION, "state", "")
				.scope(scope).build();
    
    	authURI = flow.start();
    }
    
    /***
     * On récupère l'accès après avoir fournit le code
     * @param code
     */
    public void doAccessTokenRequest(String code) {
    	TokenResult result = flow.finish(code, ""); // we do not provide state
        
        this.token = result.getAccessToken();
        this.refreshToken = (String) result.getAllProperties().get("refresh_token");
        this.expirationDelay = (int) result.getAllProperties().get("expires_in");
        this.type = (String) result.getAllProperties().get("token_type");
    }

    //Plein d'accesseur
 
    public String getToken() {
    	return token;
    }

    public String getTokenType() {
    	return type;
    }

    public int getExpiration() {
    	return expirationDelay;
    }
    
    public String getRefreshToken() {
    	return refreshToken;
    }
    
    public Client getOAuth2Client() {
        return flow.getAuthorizedClient();
    }
    public OAuth2CodeGrantFlow getFlow() {
    	return flow;
    }
    
    public String getValidateURI() {
    	return authURI;
    }
}