package simSalProject.services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import simSalProject.business.FoodSubsidyBusiness;
import simSalProject.models.FoodSubsidy;

@Path("foodsubsidy")
public class FoodSubsidyService {
	
	@Context
	private UriInfo context;
	
	@Inject
	FoodSubsidyBusiness foodSubBusiness;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}
	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFoodSubsidyVariable () {
		FoodSubsidy newFoodSubsidyVariable = foodSubBusiness.getFoodSubsidyValue();
		return Response.ok().entity(newFoodSubsidyVariable).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createFoodSubsidy (FoodSubsidy foodSubsidy) {
		foodSubBusiness.createFoodSubsidy(foodSubsidy);
		return Response.ok("Created").build();
	}
	
	
	@PUT
	@Path("newvalue")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setFoodSubsidyVariable(FoodSubsidy foodSubsidy) {		
		foodSubBusiness.setFoodSubsidyValue(foodSubsidy);
		return Response.ok().entity("Food Subsidy updated").build();

	}
}
