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

import simSalProject.business.UserBusiness;
import simSalProject.models.User_;

@Path("users")
public class UserService {

	@Context
	private UriInfo context;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}

	@Inject
	@Named("UserBus")
	UserBusiness USER_B;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createUser(User_ myUser) {
		USER_B.createUser(myUser);
		return Response.ok("User created").build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultUser(@PathParam("id") long id) {
		User_ myUser = USER_B.consultUser(id);
		if (myUser == null) {
			return Response.status(400).entity("User doesn't exist").build();
		}
		return Response.ok(myUser).build();

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response editUser(@PathParam("id") long id, User_ myUserToEdit) {
		User_ myUser = USER_B.consultUser(id);
		if (myUser == null) {
			return Response.status(400).entity("User doesn't exist").build();
		} else {
			myUserToEdit.setId(id);
			USER_B.editUser(id, myUserToEdit);
			return Response.ok("editUser return").build();
		}

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeUser(@PathParam("id") long idToRemove) {
		User_ myUser = USER_B.consultUser(idToRemove);
		if (myUser == null) {
			return Response.status(400).entity("User doesn't exist").build();
		} else {
			myUser.setId(idToRemove);
			USER_B.removeUser(myUser);
			return Response.ok("remove User return").build();
		}
	}

	@GET
	@Path("allIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> getAllIds() {
		return new ArrayList<Long>(USER_B.getAllIds());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User_> getAllValues() {
		return USER_B.getAllValues();
	}
	
}
