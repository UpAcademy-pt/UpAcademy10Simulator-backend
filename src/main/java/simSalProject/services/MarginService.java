package simSalProject.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import simSalProject.business.MarginBusiness;
import simSalProject.models.Margin;

@Path("margin")
public class MarginService {
	@Context
	private UriInfo context;
	
	@Inject
	@Named("MarginBus")
	MarginBusiness marginBusiness;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}
	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMarginValues () {
		List<Margin> newValues = marginBusiness.getMarginValues();
		
		return Response.ok().entity(newValues).build();
	}
	
	
	@POST
	@Path("newvalue")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setMarginValues(Margin newValue) {		
		marginBusiness.setMarginValue(newValue);	
		return Response.ok().entity("Margin value updated").build();

	}
}
