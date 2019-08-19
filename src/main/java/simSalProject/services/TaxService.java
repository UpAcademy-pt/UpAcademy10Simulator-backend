package simSalProject.services;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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

import simSalProject.business.TaxBusiness;
import simSalProject.models.Tax;

@Path("taxes")
public class TaxService {

	
	@Context
	private UriInfo context;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}

	@Inject
	@Named("TaxBus")
	TaxBusiness TAX_B;
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultTax()  {
		return Response.ok(TAX_B.getAllTaxes()).build();

	}
	
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultTax(@PathParam("name")String name)  {
		if (TAX_B.getTaxCountByName(name) == 0) {
			return Response.status(400).entity("Tax doesn't exist").build();
		}
		return Response.ok(TAX_B.getTaxByName(name).get(0)).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTax(Tax myTax) {
		if(TAX_B.createTax(myTax).size() > 0) {
			return Response.ok(myTax).build();
		} else {
			return Response.status(400).entity("Tax wasn't created").build();
		}
	}
	
	@PUT
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editTax(@PathParam("name") String name) {
		
		if (TAX_B.getTaxCountByName(name) == 0) {
			return Response.status(404).entity("Tax with that name doesn't exist").build();
		} else {
			Tax myTaxToEdit = TAX_B.getTaxByName(name).get(0);
			myTaxToEdit.setId(myTaxToEdit.getId());
			return Response.ok(TAX_B.editTax(myTaxToEdit)).build();
		}
	}
	
	
	@DELETE
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeTax(@PathParam("name")String nameToRemove) {
		if (TAX_B.getTaxCountByName(nameToRemove) == 0) {
			return Response.status(400).entity("Tax doesn't exist").build();
		} else {
			Tax myTax = TAX_B.getTaxByName(nameToRemove).get(0);
			myTax.setId(myTax.getId());
			return Response.ok(TAX_B.removeTax(myTax)).build();
		}
	}
}
