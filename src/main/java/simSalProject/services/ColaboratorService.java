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

import simSalProject.business.ColaboratorBusiness;
import simSalProject.models.Colaborator;

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
	@Named("ColabBus")
	ColaboratorBusiness COLAB_B;
	
	
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultColaborator(@PathParam("name")String name)  {
		if (COLAB_B.getColabCountByName(name) == 0) {
			return Response.status(400).entity("Colaborator doesn't exist").build();
		}
		List<Colaborator> myColaborator = COLAB_B.getColabByName(name);
		return Response.ok(myColaborator.get(0)).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createColaborator(Colaborator myColaborator) {
		if(COLAB_B.createColaborator(myColaborator).size() > 0) {
			return Response.ok(myColaborator).build();
		} else {
			return Response.status(400).entity("Colaborator wasn't created").build();
		}
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response editColaborator(@PathParam("id") long id, Colaborator myColaboratorToEdit) {
		if (COLAB_B.getColabCountByName(myColaboratorToEdit.getName()) == 0) {
			return Response.status(404).entity("Colaborator with that name doesn't exist").build();
		} else {
			myColaboratorToEdit.setId(id);
			return Response.ok(COLAB_B.editColaborator(myColaboratorToEdit)).build();
		}
	}
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeColaborator(@PathParam("id")long idToRemove) {
		if (COLAB_B.getColabCountById(idToRemove) == 0) {
			return Response.status(400).entity("Colaborator doesn't exist").build();
		} else {
			List<Colaborator> colaborators = COLAB_B.getColabById(idToRemove);
			Colaborator myColaborator = colaborators.get(0);
			myColaborator.setId(idToRemove);
			return Response.ok(COLAB_B.removeColaborator(myColaborator)).build();
		}
	}
	
	
	@GET
	@Path("allIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> getAllIds() {
		return new ArrayList<Long>(COLAB_B.getAllIds());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Colaborator> getAllValues() {
		return COLAB_B.getAllValues();
	}
	
	
}
