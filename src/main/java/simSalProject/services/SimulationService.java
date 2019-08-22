package simSalProject.services;

import java.util.ArrayList;
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
	public Response createSimulation(@PathParam("id") long colabId, List<SimFieldsData> mySimulation ) {
		if(COLAB_B.getColabCountById(colabId) != 0) {
			Colaborator colaborator = COLAB_B.getColabById(colabId).get(0);
			SimulationDTO simulationDTO = SIM_B.createSimulation(colaborator, mySimulation);
			if (simulationDTO != null) {
				return Response.ok(simulationDTO).build();
			} else {
				return Response.status(400).entity("Simulação não criada").build();
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
	@Path("allIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> getAllIds() {
		return new ArrayList<Long>(SIM_B.getAllIds());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<SimulationDTO> getAllValues() {
		return SIM_B.getAllValues();
	}
	
	@GET
	@Path("allSimsFromColab/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public  List<SimulationDTO> getSimulationByColabId(@PathParam("id")long id) {
		Colaborator colaborator = COLAB_B.getColabById(id).get(0);
		return SIM_B.getSimulationByColab(colaborator);
	}
	
}
