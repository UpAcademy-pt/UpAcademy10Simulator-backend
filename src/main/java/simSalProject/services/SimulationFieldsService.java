package simSalProject.services;

import java.util.ArrayList;
import java.util.Collection;
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

import simSalProject.business.SimulationsFieldsBusiness;
import simSalProject.models.Simulation;
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
	@Named("SimFieldsBus")
	SimulationsFieldsBusiness SIMF_B;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultSimulationField(@PathParam("id")long id) {
		SimulationFields mySimulationField = SIMF_B.consultSimulationField(id);
		if (mySimulationField == null) {
			return Response.status(400).entity("Simulation field doesn't exist").build();
		}
		return Response.ok(mySimulationField).build();
	}
	
	
	@GET
	@Path("name")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultSimulationField(@PathParam("name")String name) {
		SimulationFields mySimulationField = SIMF_B.consultSimulationField(name);
		if (mySimulationField == null) {
			return Response.status(400).entity("Simulation field doesn't exist").build();
		}
		return Response.ok(mySimulationField).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createSimulationField(SimulationFields mySimulationField) {
		if (SIMF_B.createSimulationField(mySimulationField) == "Simulation field created") {
		}
			return Response.ok(SIMF_B.createSimulationField(mySimulationField)).build();
	}
	
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public Response editSimulationField (long id, SimulationFields mySimulationFieldtoEdit) {
		SimulationFields mySimulationField = SIMF_B.consultSimulationField(id);
		
		if (mySimulationField == null) {
			SIMF_B.editSimulationField(mySimulationField);
			return Response.status(404).entity("Simulation field doesn't exist").build();
		}
		return Response.ok("Simulation field successfully updated").build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public Response RemoveSimulationField(@PathParam("id")long idToRemove) {
		SimulationFields mySimulationField = SIMF_B.consultSimulationField(idToRemove);
		if (mySimulationField == null) {
			return Response.status(400).entity("Simulation field doesn't exist").build();
		} else {
			mySimulationField.setId(idToRemove);
			SIMF_B.removeSimulationField(mySimulationField);
			return Response.ok("Simulation field successfully removed").build();
		}
	}
	
	@GET
	@Path("allIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> getAllIds() {
		return new ArrayList<Long>(SIMF_B.getAllIds());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<SimulationFields> getAllValues() {
		return SIMF_B.getAllValues();
	}
	
	
}
