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

import simSalProject.business.AccountBusiness;
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
	
	@Inject
	AccountBusiness accBusiness;
	
	
	/**
	 * Gets a Colaborator from database
	 * @param long id
	 * @return Response error message or ColaboratorDTO
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultColaborator(@PathParam("id")long  id)  {
		if (colabBusiness.getColabCountById(id) == 0) {
			return Response.status(404).entity("Colaborator doesn't exist").build();
		} else {
			List<Colaborator> myColaborator = colabBusiness.getColabById(id);
			return Response.ok(colabBusiness.ColaboratorToColaboratorDTO(myColaborator.get(0))).build();
		}
	}

	
	/**
	 * Creates a Colaborator
	 * @param Colaborator myColaborator
	 * @return Response error message or ColaboratorDTO
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createColaborator(Colaborator myColaborator) {
		if(accBusiness.getAccCountById(myColaborator.getAccount().getId()) == 0) {
			return Response.status(404).entity("Account with this email doesn't exist").build();
		} else {
			Colaborator colaborator = colabBusiness.createColaborator(myColaborator);
			ColaboratorDTO colaboratorDTO = colabBusiness.ColaboratorToColaboratorDTO(colaborator);
			return Response.ok(colaboratorDTO).build();
		}
	}
	
	/**
	 * Edits a Colaborator
	 * @param long id
	 * @param ColaboratorDTO myColaboratorDTOToEdit
	 * @return Response error message or ColaboratorDTO
	 */
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editColaborator(@PathParam("id") long id, ColaboratorDTO myColaboratorDTOToEdit) {
		if (colabBusiness.getColabCountById(id) == 0) {
			return Response.status(404).entity("Colaborator with that name doesn't exist").build();
		} else {
			myColaboratorDTOToEdit.setId(id);
			return Response.ok(colabBusiness.editColaborator(myColaboratorDTOToEdit)).build();
		}
	}
	
	/**
	 * Removes Colaborator
	 * @param idToRemove
	 * @return Response message
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeColaborator(@PathParam("id")long idToRemove) {
		if (colabBusiness.getColabCountById(idToRemove) == 0) {
			return Response.status(404).entity("Colaborator doesn't exist").build();
		} else {
			List<Colaborator> colaborators = colabBusiness.getColabById(idToRemove);
			Colaborator myColaborator = colaborators.get(0);
			myColaborator.setId(idToRemove);
			return Response.ok(colabBusiness.removeColaborator(myColaborator)).build();
		}
	}
	

	/**
	 * Gets all Colaborators from database
	 * @return Response error message or List<ColaboratorDTO>
	 */
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
