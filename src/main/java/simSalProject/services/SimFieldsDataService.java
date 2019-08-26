package simSalProject.services;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import simSalProject.business.SimFieldsDataBusiness;
import simSalProject.models.SimFieldsData;
import simSalProject.models.SimFieldsDataDTO;

@Path("simulationfieldsdataservice")
public class SimFieldsDataService {

	@Context
	private UriInfo context;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}
	
	
	@Inject
	SimFieldsDataBusiness simFieldsDataBusiness;
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response manageSimFieldsData(SimFieldsData mySimFieldsData) {
		if (simFieldsDataBusiness.getSimFieldsDataCountById(mySimFieldsData.getId()) == 0) {
		return Response.ok(simFieldsDataBusiness.createSimFieldsData(mySimFieldsData)).build();
		} else {
			mySimFieldsData.setId(mySimFieldsData.getId());
		return Response.ok(simFieldsDataBusiness.editSimFieldsData(mySimFieldsData)).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultSimFieldsData(@PathParam("id") long id) {
		if (simFieldsDataBusiness.getSimFieldsDataCountById(id) == 0) {
			return Response.status(400).entity("SimFieldsData doesn't exist").build();
		} else {
			return Response.ok(simFieldsDataBusiness.getSimFieldsDataById(id).get(0)).build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeSimFieldsData(@PathParam("id") long idToRemove) {
		if (simFieldsDataBusiness.getSimFieldsDataCountById(idToRemove) == 0) {
			return Response.status(400).entity("SimFieldsData doesn't exist").build();
		} else {
			List<SimFieldsData> simFieldsData = simFieldsDataBusiness.getSimFieldsDataById(idToRemove);
			SimFieldsData mySimFieldsData = simFieldsData.get(0);
			return Response.ok(simFieldsDataBusiness.removeSimFieldsData(mySimFieldsData)).build();
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SimFieldsDataDTO> getAllValues() {
		return simFieldsDataBusiness.getAllValues();
	}
	
	
}
