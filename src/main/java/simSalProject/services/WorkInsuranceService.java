package simSalProject.services;

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

import simSalProject.business.WorkInsuranceBusiness;
import simSalProject.models.WorkInsurance;

@Path("workinsurance")
public class WorkInsuranceService {

	@Context
	private UriInfo context;
	
	@Inject
	WorkInsuranceBusiness workInsuranceBusiness;
	
	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getWorkInsuranceVariable () {
		return Response.ok().entity(workInsuranceBusiness.getWorkInsuranceVariable()).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createWorkInsuranceVariable(WorkInsurance newValue) {		
		workInsuranceBusiness.createWorkInsuranceVariable(newValue);
		return Response.ok().entity("Work Insurance variable created").build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editWorkInsuranceVariable(@PathParam("id")long id, WorkInsurance newValue){
		String msg = workInsuranceBusiness.editWorkInsuranceVariable(id, newValue);
		if(msg == "Edited") {
			return Response.ok(msg).build();
		} else {
			return Response.status(304).build();
		}
		
	}
	
	
}
