package simSalProject.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import simSalProject.business.ColaboratorBusiness;

@Path("colaborators")
public class ColaboratorService {

	
	
	@Context
	private UriInfo context;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}

	
	
	@Inject
	@Named("ColabBus")
	ColaboratorBusiness COLAB_B;
	
}
