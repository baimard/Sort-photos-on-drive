package juxo.apiCalendar.definitionClasse;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class ResponseCorsFilter implements ContainerResponseFilter{

	@Override
	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "*");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
		responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

	}

}
