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
	@Produces(MediaType.APPLICATION_JSON)
	public Response manageSimulationFields(SimulationFields mySimulationField) {
		if (SIMF_B.getSimFieldsCount(mySimulationField.getName()) == 0) {
			if (SIMF_B.createSimulationFields(mySimulationField) == "Created") {
				return Response.ok("Created").build();
			}
		} else {
			if (SIMF_B.editSimulationFields(mySimulationField) == "Edited") {
				return Response.ok("Edited").build();
			}
		}
		return Response.status(400).entity("Something went wrong").build();
	}

//	@GET
//	@Path("/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response consultSimulationFields(@PathParam("id") long id) {
//		SimulationFields mySimulationField = SIMF_B.consultSimulationField(id);
//		if (mySimulationField == null) {
//			return Response.status(400).entity("SimulationFields doesn't exist").build();
//		}
//		return Response.ok(mySimulationField).build();
//
//	}

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultSimulationField(@PathParam("name") String name) {
		if (SIMF_B.getSimFieldsCount(name) == 0) {
			return Response.status(400).entity("Simulation field with that name doesn't exist").build();
		} else {
			List<SimulationFields> mySimulationField = SIMF_B.getSimulationFieldsByName(name);
			return Response.ok(mySimulationField.get(0)).build();
		}
	}

//	@PUT
//	@Path("/{name}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response editSimulationFields(@PathParam("name") String name, SimulationFields mySimulationFieldsToEdit) {
//		List<SimulationFields> mySimulationField = SIMF_B.consultSimulationField(name);
//		if (mySimulationField.size() == 0) {
//			return Response.status(400).entity("SimulationFields doesn't exist").build();
//		} else {
//			mySimulationFieldsToEdit.setName(name);
//			SIMF_B.editSimulationFields(mySimulationFieldsToEdit);
//			return Response.ok("Edit successful").build();
//		}
//
//	}

	@DELETE
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeSimulationFields(@PathParam("name") String nameToRemove) {
		if (SIMF_B.getSimFieldsCount(nameToRemove) == 0) {
			return Response.status(400).entity("SimulationFields doesn't exist").build();
		} else {
			List<SimulationFields >mySimulationField = SIMF_B.getSimulationFieldsByName(nameToRemove);
			SIMF_B.removeSimulationFields(mySimulationField.get(0));
			return Response.ok("Removed successful").build();
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
