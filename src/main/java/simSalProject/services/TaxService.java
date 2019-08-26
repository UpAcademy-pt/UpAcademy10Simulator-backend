package simSalProject.services;

import java.util.List;

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
	TaxBusiness taxBusiness;
	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultTax()  {
		return Response.ok(taxBusiness.getAllTaxes()).build();

	}
	
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultTax(@PathParam("name")String name)  {
		if (taxBusiness.getTaxCountByName(name) == 0) {
			return Response.status(400).entity("Tax doesn't exist").build();
		}
		return Response.ok(taxBusiness.getTaxByName(name).get(0)).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTax(List<Tax> taxes) {
		for (Tax tax : taxes) {
			if(taxBusiness.createTax(tax).size() > 0) {
				return Response.ok(tax).build();
			} else {
				return Response.status(400).entity("Tax wasn't created").build();
			}	
		}
		return null;
	}
	
	@PUT
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editTax(@PathParam("name") String name) {
		if (taxBusiness.getTaxCountByName(name) == 0) {
			return Response.status(404).entity("Tax with that name doesn't exist").build();
		} else {
			Tax myTaxToEdit = taxBusiness.getTaxByName(name).get(0);
			myTaxToEdit.setId(myTaxToEdit.getId());
			return Response.ok(taxBusiness.editTax(myTaxToEdit)).build();
		}
	}
	
	
	@DELETE
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeTax(@PathParam("name")String nameToRemove) {
		if (taxBusiness.getTaxCountByName(nameToRemove) == 0) {
			return Response.status(400).entity("Tax doesn't exist").build();
		} else {
			Tax myTax = taxBusiness.getTaxByName(nameToRemove).get(0);
			myTax.setId(myTax.getId());
			return Response.ok(taxBusiness.removeTax(myTax)).build();
		}
	}
}
