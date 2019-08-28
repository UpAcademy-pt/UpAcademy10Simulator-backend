package simSalProject.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	@Produces(MediaType.APPLICATION_JSON)
	public Response createMarginValues(Margin newValue) {
		return Response.ok(marginBusiness.createMarginValue(newValue)).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editMarginValues(@PathParam("id")long id, Margin newValue) {
		String msg = marginBusiness.editMarginValue(id, newValue);
		if(msg == "Edited") {
			return Response.ok(msg).build();
		} else {
			return Response.status(304).entity(msg).build();
		}
		
	}
}
