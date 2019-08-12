package simSalProject.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultColaborator(@PathParam("id")long id)  {
		Colaborator myColaborator = COLAB_B.consultColaborator(id);
		if (myColaborator == null) {
			return Response.status(400).entity("Colaborator doesn't exist").build();
		}
		return Response.ok(myColaborator).build();

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response editColaborator(long id, Colaborator myColaboratorToEdit) {
		Colaborator myColaborator = COLAB_B.consultColaborator(id);

		if (myColaborator == null) {
			return Response.status(404).entity("Colaborator doesn't exist").build();
		} else {
			myColaboratorToEdit.setId(id);
			COLAB_B.editColaborator(id, myColaboratorToEdit);
			return Response.ok("Colaborator successfully updated").build();
		}

	}
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_HTML)
	public Response removeColaborator(@PathParam("id")long idToRemove) {
		Colaborator myColaborator = COLAB_B.consultColaborator(idToRemove);
		if (myColaborator == null) {
			return Response.status(400).entity("Colaborator doesn't exist").build();
		} else {
			myColaborator.setId(idToRemove);
			COLAB_B.removeColaborator(myColaborator);
			return Response.ok("Colaborator successfully removed").build();
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
