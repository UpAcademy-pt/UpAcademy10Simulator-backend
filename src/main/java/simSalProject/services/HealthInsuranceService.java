package simSalProject.services;

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

import simSalProject.business.HealthInsuranceBusiness;
import simSalProject.models.HealthInsurance;

@Path("healthinsurance")
public class HealthInsuranceService {
	
	@Context
	private UriInfo context;
	
	@Inject
	@Named("HealthInsBus")
	HealthInsuranceBusiness HEALTHINS_B;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}
	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHealthInsuranceVariable () {
		HealthInsurance newHealthInsuranceVariable = HEALTHINS_B.getHealthInsuranceValue();
		
		return Response.ok().entity(newHealthInsuranceVariable).build();
	}
	
	
	@POST
	@Path("newvalue")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setWorkInsuranceVariable(HealthInsurance newValue) {		
		HEALTHINS_B.setHealthInsuranceValue(newValue);
		return Response.ok().entity("Health Insurance updated").build();

	}
}
