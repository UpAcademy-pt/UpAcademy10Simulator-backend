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
import simSalProject.models.SimulationFields;

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
	@Named("SimFieldsDataBus")
	SimFieldsDataBusiness SIMFD_B;
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response manageSimFieldsData(SimFieldsData mySimFieldsData) {
		if (SIMFD_B.getSimFieldsCount(mySimFieldsData.getName()) == 0) {
		return Response.ok(SIMFD_B.createSimFieldsData(mySimFieldsData)).build();
		} else {
			SimFieldsData mySimFieldsDataToEdit = SIMFD_B.getSimFieldsDataByName(mySimFieldsData.getName()).get(0);
			mySimFieldsData.setId(mySimFieldsDataToEdit.getId());
		return Response.ok(SIMFD_B.editSimFieldsData(mySimFieldsData)).build();
		}
	}

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultSimFieldsData(@PathParam("name") String name) {
		if (SIMFD_B.getSimFieldsCount(name) == 0) {
			return Response.status(400).entity("SimFieldsData doesn't exist").build();
		} else {
			return Response.ok(SIMFD_B.getSimFieldsDataByName(name).get(0)).build();
		}
	}

	@DELETE
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeSimFieldsData(@PathParam("name") String nameToRemove) {
		if (SIMFD_B.getSimFieldsCount(nameToRemove) == 0) {
			return Response.status(400).entity("SimFieldsData doesn't exist").build();
		} else {
			List<SimFieldsData> simFieldsData = SIMFD_B.getSimFieldsDataByName(nameToRemove);
			System.out.println(simFieldsData.get(0));
			SimFieldsData mySimFieldsData = simFieldsData.get(0);
			System.out.println(mySimFieldsData);
			return Response.ok(SIMFD_B.removeSimFieldsData(mySimFieldsData)).build();
		}
	}
	
	
}
