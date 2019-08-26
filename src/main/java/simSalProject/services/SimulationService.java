package simSalProject.services;

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

import simSalProject.business.ColaboratorBusiness;
import simSalProject.business.SimulationBusiness;
import simSalProject.models.Colaborator;
import simSalProject.models.SimFieldsData;
import simSalProject.models.Simulation;
import simSalProject.models.SimulationDTO;

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

	@Inject
	@Named("ColabBus")
	ColaboratorBusiness COLAB_B;

	@POST
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createSimulation(@PathParam("id") long colabId, List<SimFieldsData> mySimulation) {
		if (COLAB_B.getColabCountById(colabId) != 0) {
			Colaborator colaborator = COLAB_B.getColabById(colabId).get(0);
			SimulationDTO simulationDTO = SIM_B.createSimulation(colaborator, mySimulation);
			if (simulationDTO != null) {
				return Response.ok(simulationDTO).build();
			} else {
				return Response.status(400).entity("Simulation was not created").build();
			}
		} else {
			return Response.status(404).entity("Colaborator with that id doesn't exist").build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultSimulation(@PathParam("id") long id) {
		if (SIM_B.getSimulationCountById(id) == 0) {
			return Response.status(400).entity("Simulation doesn't exist").build();
		} else {
			Simulation mySimulation = SIM_B.consultSimulation(id);
			return Response.ok(mySimulation).build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response editSimulation(@PathParam("id") long id, Simulation mySimulationToEdit) {
		if (SIM_B.getSimulationCountById(id) == 0) {
			return Response.status(400).entity("Simulation doesn't exist").build();
		} else {
			mySimulationToEdit.setId(id);
			SIM_B.editSimulation(mySimulationToEdit);
			return Response.ok("Edit successful").build();
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeSimulation(@PathParam("id") long idToRemove) {
		if (SIM_B.getSimulationCountById(idToRemove) == 0) {
			return Response.status(400).entity("Simulation doesn't exist").build();
		} else {
			Simulation mySimulationToRemove = SIM_B.consultSimulation(idToRemove);
			SIM_B.removeSimulation(mySimulationToRemove);
			return Response.ok("Remove successful").build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllValues() {
		if (SIM_B.getSimCount() == 0) {
			return Response.status(400).entity("There are no simulations to search for").build();
		} else {
			return Response.ok().entity(SIM_B.getAllValues()).build();
		}
	}

	@GET
	@Path("allSimsFromColab/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSimulationByColabId(@PathParam("id") long id) {
		if (COLAB_B.getColabCount() == 0) {
			return Response.status(404).entity("Colaborator doesn't exist").build();
		} else {
			Colaborator colaborator = COLAB_B.getColabById(id).get(0);
			if (SIM_B.getSimCountByColabId(colaborator) == 0) {
				return Response.status(404).entity("There are no simulation for this colaborator").build();
			} else {
				return Response.ok().entity(SIM_B.getSimulationByColab(colaborator)).build();
			}
		}
	}

	@GET
	@Path("allSimsByDate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSimsByDate(long startDate, long endDate) {
		if (SIM_B.getCountSimByDate(startDate, endDate) == 0) {
			return Response.status(400).entity("There are no simulation between these dates").build();
		} else {
			return Response.ok().entity(SIM_B.getSimsByDate(startDate, endDate)).build();
		}
	}

}
