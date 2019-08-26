package simSalProject.services;

import java.util.List;

import javax.inject.Inject;
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
import simSalProject.models.ColaboratorDTO;

@Path("colaborators")
public class ColaboratorService {

	
	
	@Context
	private UriInfo context;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}

	
	@Inject
	ColaboratorBusiness colabBusiness;
	
	@Inject
	SimulationBusiness simBusiness;
	
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultColaborator(@PathParam("id")long  id)  {
		if (colabBusiness.getColabCountById(id) == 0) {
			return Response.status(400).entity("Colaborator doesn't exist").build();
		}
		List<Colaborator> myColaborator = colabBusiness.getColabById(id);
		return Response.ok(colabBusiness.ColaboratorToColaboratorDTO(myColaborator.get(0))).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createColaborator(Colaborator myColaborator) {
		if(colabBusiness.createColaborator(myColaborator) == null) {
			return Response.status(400).entity("Colaborator wasn't created").build();
		} else {
			ColaboratorDTO myColaboratorDTO = new ColaboratorDTO();
			myColaboratorDTO.setId(myColaborator.getId());
			myColaboratorDTO.setName(myColaborator.getName());
			return Response.ok(myColaboratorDTO).build();
		}
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editColaborator(@PathParam("id") long id, ColaboratorDTO myColaboratorDTOToEdit) {
		if (colabBusiness.getColabCountById(myColaboratorDTOToEdit.getId()) == 0) {
			return Response.status(404).entity("Colaborator with that name doesn't exist").build();
		} else {
			myColaboratorDTOToEdit.setId(id);
			return Response.ok(colabBusiness.editColaborator(myColaboratorDTOToEdit)).build();
		}
	}
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeColaborator(@PathParam("id")long idToRemove) {
		if (colabBusiness.getColabCountById(idToRemove) == 0) {
			return Response.status(400).entity("Colaborator doesn't exist").build();
		} else {
			List<Colaborator> colaborators = colabBusiness.getColabById(idToRemove);
			Colaborator myColaborator = colaborators.get(0);
			myColaborator.setId(idToRemove);
			return Response.ok(colabBusiness.removeColaborator(myColaborator)).build();
		}
	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllValues() {
		if(colabBusiness.getColabCount() == 0){
			return Response.status(404).entity("There are no colaborators").build();
		} else {
			return Response.ok().entity(colabBusiness.getAllValues()).build();
		}
	}
	
	
}
