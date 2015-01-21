package juxo.apiCalendar.connexionGoogle;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.ProcessingException;

import org.glassfish.jersey.client.oauth2.ClientIdentifier;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow.Builder;
import org.glassfish.jersey.client.oauth2.OAuth2FlowGoogleBuilder;
import org.glassfish.jersey.client.oauth2.TokenResult;

public class OAuth2Token implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2L;

    private String authURI;
    private String tokenAcess;
    private String refreshToken;
    private String type; 
    private String OOB = "urn:ietf:wg:oauth:2.0:oob";
    private int statut;
    private int expirationDelay;
	
	public OAuth2Token(){
		
	}
	
	
	/***
     * Construction d'un objet token selon les spécifications google
     * @param clientId
     * @param callbackURI
     * @param scope
     */
    public OAuth2Token(ClientIdentifier clientId, String scope) {
    	Builder<OAuth2FlowGoogleBuilder> builder = 
    			OAuth2ClientSupport.googleFlowBuilder(clientId, OOB, scope);
		ConnexionGoogle.flow = builder
				.property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION, "readOnly","true")
				.property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION,"redirect_uri", OOB)
				.property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION, "state", "")
				.scope(scope).build();
    	authURI = ConnexionGoogle.flow.start();
    }
    
    /**
     * Permet d'actualiser le token pour avoir accès aux données
     * Dans le cas où l'utilisateur a déjà accepté que l'application utilise les données
     * (C'est à dire qu'on a déjà obtenu un token) 
     * @param clientId
     * @param scope
     */
    public void refreshToken(ClientIdentifier clientId, String scope){
    	try{
        	Builder<OAuth2FlowGoogleBuilder> builder = 
        			OAuth2ClientSupport.googleFlowBuilder(clientId, OOB, scope);
        	ConnexionGoogle.flow = builder.build();
        	TokenResult result = ConnexionGoogle.flow.refreshAccessToken(refreshToken);
            this.tokenAcess = result.getAccessToken();
            String refreshtok = (String) result.getAllProperties().get("refresh_token");
            if(refreshtok!=null)
            	this.refreshToken = refreshtok; 
            this.expirationDelay = (int) result.getAllProperties().get("expires_in");
            this.type = (String) result.getAllProperties().get("token_type");
    	}catch(ProcessingException e){
    		this.statut=400;
    	}

       
    }
    
    /***
     * Si on a déjà une clef d'accès
     * @param token
     */
    public OAuth2Token(String token) {
    	this.tokenAcess = token;
    }
    
    /***
     * On récupère l'accès après avoir fournit le code
     * @param code
     */
    public void doAccessTokenRequest(String code) {
    	TokenResult result = ConnexionGoogle.flow.finish(code, "");// we do not provide state
        this.tokenAcess = result.getAccessToken();
        this.refreshToken = (String) result.getAllProperties().get("refresh_token");
        this.expirationDelay = (int) result.getAllProperties().get("expires_in");
        this.type = (String) result.getAllProperties().get("token_type");
    }

    public String toString(){
    	String s = "";
    	s += "Token Access : " + tokenAcess + "\n";
    	s += "Refresh Access : " + refreshToken + "\n";
    	s += "Expire in : " + expirationDelay + "\n";
    	s += "Statut code : " + statut + "\n";
		return s;	
    }
    

	public String getAuthURI() {
		return authURI;
	}


	public void setAuthURI(String authURI) {
		this.authURI = authURI;
	}


	public String getTokenAcess() {
		return tokenAcess;
	}


	public void setTokenAcess(String tokenAcess) {
		this.tokenAcess = tokenAcess;
	}


	public String getRefreshToken() {
		return refreshToken;
	}


	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getOOB() {
		return OOB;
	}


	public void setOOB(String oOB) {
		OOB = oOB;
	}


	public int getStatut() {
		return statut;
	}


	public void setStatut(int statut) {
		this.statut = statut;
	}


	public int getExpirationDelay() {
		return expirationDelay;
	}


	public void setExpirationDelay(int expirationDelay) {
		this.expirationDelay = expirationDelay;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}