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

import simSalProject.business.WorkInsuranceBusiness;
import simSalProject.models.WorkInsurance;

@Path("workinsurance")
public class WorkInsuranceService {

	@Context
	private UriInfo context;
	
	@Inject
	@Named("WorkInsuranceBus")
	WorkInsuranceBusiness WORKINS_B;
	
	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkInsuranceVariable () {
		WorkInsurance newWorkInsuranceVariable = WORKINS_B.getWorkInsuranceVariable();
		
		return Response.ok().entity(newWorkInsuranceVariable).build();
	}
	
	
	@POST
	@Path("newvalue")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setWorkInsuranceVariable(WorkInsurance newValue) {		
		WORKINS_B.setWorkInsuranceVariable(newValue);
		return Response.ok().entity("Work Insurance variable updated").build();

	}
	
}
