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
import simSalProject.models.SimulationFields;

@Path("SimulationFields")
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
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createSimulationFields(SimulationFields mySimulationFields) {
		if (SIMF_B.createSimulationFields(mySimulationFields) == "Created") {
		
		}
		return Response.ok(SIMF_B.createSimulationFields(mySimulationFields)).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultSimulationFields(@PathParam("id") long id) {
		SimulationFields mySimulationFields = SIMF_B.consultSimulationFields(id);
		if (mySimulationFields == null) {
			return Response.status(400).entity("SimulationFields doesn't exist").build();
		}
		return Response.ok(mySimulationFields).build();

	}

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultSimulationField(@PathParam("name")String name) {
		SimulationFields mySimulationField = SIMF_B.consultSimulationField(name);
		if (mySimulationField == null) {
			return Response.status(400).entity("Simulation field doesn't exist").build();
		}
		return Response.ok(mySimulationField).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response editSimulationFields(@PathParam("id") long id, SimulationFields mySimulationFieldsToEdit) {
		SimulationFields mySimulationFields = SIMF_B.consultSimulationFields(id);
		if (mySimulationFields == null) {
			return Response.status(400).entity("SimulationFields doesn't exist").build();
		} else {
			mySimulationFieldsToEdit.setId(id);
			SIMF_B.editSimulationFields(id, mySimulationFieldsToEdit);
			return Response.ok("Edit successful").build();
		}

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeSimulationFields(@PathParam("id") long idToRemove) {
		SimulationFields mySimulationFields = SIMF_B.consultSimulationFields(idToRemove);
		if (mySimulationFields == null) {
			return Response.status(400).entity("SimulationFields doesn't exist").build();
		} else {
			mySimulationFields.setId(idToRemove);
			SIMF_B.removeSimulationFields(mySimulationFields);
			return Response.ok("Remove successful").build();
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
