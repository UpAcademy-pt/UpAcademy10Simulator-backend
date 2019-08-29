package simSalProject.services;

import java.util.List;

import javax.inject.Inject;
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
	TaxBusiness taxBusiness;
	
	
	/**
	 * Gets all taxes from database
	 * @return Response List<Tax>
	 */
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll()  {
		return Response.ok(taxBusiness.getAllTaxes()).build();

	}
	
	/**
	 * Gets Tax from database
	 * @param String name
	 * @return Response error message or Tax
	 */
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultTax(@PathParam("name")String name)  {
		if (taxBusiness.getTaxCountByName(name) == 0) {
			return Response.status(400).entity("Tax doesn't exist").build();
		}
		return Response.ok(taxBusiness.getTaxByName(name).get(0)).build();

	}

	
	/**
	 * Creates Tax
	 * @param List<Tax> taxes
	 * @return Response List<Tax>
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTax(List<Tax> taxes) {
			return Response.ok(taxBusiness.createTax(taxes)).build();
		}		
	
	/**
	 * Edits Tax
	 * @param List<Tax> taxes
	 * @return Response message
	 */
	@PUT
	@Path("edit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editTax(List<Tax> taxes) {
		for (Tax tax : taxes) {
			if (taxBusiness.getTaxCountByName(tax.getName()) == 0) {
				return Response.status(404).entity("Tax with that name doesn't exist").build();
			} else {
				Tax myTaxToEdit = taxBusiness.getTaxByName(tax.getName()).get(0);
				tax.setId(myTaxToEdit.getId());
				taxBusiness.editTax(tax);
			}
		}
		return Response.ok("Edited").build();
	}
	
	/**
	 * Removes Tax
	 * @param String nameToRemove
	 * @return Response message
	 */
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
