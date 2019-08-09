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

import simSalProject.business.SimulationBusiness;
import simSalProject.models.Simulation;

@Path("simulations")
public class SimulationService {
	
	@Context
	private UriInfo context;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}

	@Inject
	@Named("SimBus")
	SimulationBusiness SIM_B;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createSimulation(Simulation mySimulation) {
		if (SIM_B.createSimulation(mySimulation) == "Created") {
		
		}
		return Response.ok(SIM_B.createSimulation(mySimulation)).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultSimulation(@PathParam("id") long id) {
		Simulation mySimulation = SIM_B.consultSimulation(id);
		if (mySimulation == null) {
			return Response.status(400).entity("Simulation doesn't exist").build();
		}
		return Response.ok(mySimulation).build();

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response editSimulation(@PathParam("id") long id, Simulation mySimulationToEdit) {
		Simulation mySimulation = SIM_B.consultSimulation(id);
		if (mySimulation == null) {
			return Response.status(400).entity("Simulation doesn't exist").build();
		} else {
			mySimulationToEdit.setId(id);
			SIM_B.editSimulation(id, mySimulationToEdit);
			return Response.ok("Edit successful").build();
		}

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeSimulation(@PathParam("id") long idToRemove) {
		Simulation mySimulation = SIM_B.consultSimulation(idToRemove);
		if (mySimulation == null) {
			return Response.status(400).entity("Simulation doesn't exist").build();
		} else {
			mySimulation.setId(idToRemove);
			SIM_B.removeSimulation(mySimulation);
			return Response.ok("Remove successful").build();
		}
	}

	@GET
	@Path("allIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> getAllIds() {
		return new ArrayList<Long>(SIM_B.getAllIds());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Simulation> getAllValues() {
		return SIM_B.getAllValues();
	}
	
}
