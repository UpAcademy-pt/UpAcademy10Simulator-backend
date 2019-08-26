package simSalProject.services;

import java.util.List;

import javax.inject.Inject;
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

import simSalProject.business.SimulationsFieldsBusiness;
import simSalProject.models.SimulationFields;

@Path("simulationfields")
public class SimulationFieldsService {

	
	@Context
	private UriInfo context;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}

	
	@Inject
	SimulationsFieldsBusiness simFieldsBusiness;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response manageSimulationFields(SimulationFields mySimulationField) {
		if (simFieldsBusiness.getSimFieldsCount(mySimulationField.getName()) == 0) {
			String msg = simFieldsBusiness.createSimulationFields(mySimulationField);
			return Response.ok(msg).build();
		} else {
			List<SimulationFields> simulationField = simFieldsBusiness.getSimulationFieldsByName(mySimulationField.getName());
			SimulationFields mySimulationFieldToEdit = simulationField.get(0);
			mySimulationField.setId(mySimulationFieldToEdit.getId());

			return Response.ok(simFieldsBusiness.editSimulationFields(mySimulationField)).build();
		}
	}

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultSimulationField(@PathParam("name") String name) {
		if (simFieldsBusiness.getSimFieldsCount(name) == 0) {
			return Response.status(400).entity("Simulation field with that name doesn't exist").build();
		} else {
			List<SimulationFields> mySimulationField = simFieldsBusiness.getSimulationFieldsByName(name);
			return Response.ok(mySimulationField.get(0)).build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSimFields() {
		List<SimulationFields> thisSimFields = simFieldsBusiness.getAllSimValues();
		return Response.ok().entity(thisSimFields).build();
	}

	@DELETE
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeSimulationFields(@PathParam("name") String nameToRemove) {
		if (simFieldsBusiness.getSimFieldsCount(nameToRemove) == 0) {
			return Response.status(400).entity("SimulationFields doesn't exist").build();
		} else {
			List<SimulationFields> mySimulationField = simFieldsBusiness.getSimulationFieldsByName(nameToRemove);
			simFieldsBusiness.removeSimulationFields(mySimulationField.get(0));
			return Response.ok("Removed successful").build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SimulationFields> getAllValues() {
		return simFieldsBusiness.getAllValues();
	}
}
