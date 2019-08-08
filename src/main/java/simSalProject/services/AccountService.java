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

import simSalProject.business.AccountBusiness;
import simSalProject.models.Account;

@Path("accounts")
public class AccountService {

	@Context
	private UriInfo context;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}

	
	
	@Inject
	@Named("AccBus")
	AccountBusiness ACC_B;

	
	@GET
	@Path("initDatabase")
	@Produces(MediaType.TEXT_PLAIN)
	public Response initDataBase() {
		String message = ACC_B.initDataBase();
		if(message == "ADMIN didn't exist, ADMIN created with default credentials") {
			
		} else if (message == "ADMIN already exists") {
			return Response.status(400).entity(message).build();
			
		}
		return Response.ok().entity(message).build();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createAccount(Account myAccount) {
		if (ACC_B.createAccount(myAccount) == "Account created") {
		} else if (ACC_B.createAccount(myAccount) == "Only 1 admin can exist") {
			return Response.status(304).entity(ACC_B.createAccount(myAccount)).build();
		}
		return Response.ok(ACC_B.createAccount(myAccount)).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultAccount(@PathParam("id") long id) {
		Account myAccount = ACC_B.consultAccount(id);
		if (myAccount == null) {
			return Response.status(400).entity("Account doesn't exist").build();
		}
		return Response.ok(myAccount).build();

	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response editAccount(@PathParam("id") long id, Account myAccountToEdit) {
		Account myAccount = ACC_B.consultAccount(id);
		if (myAccount == null) {
			return Response.status(400).entity("Account doesn't exist").build();
		} else {
			myAccountToEdit.setId(id);
			ACC_B.editAccount(id, myAccountToEdit);
			return Response.ok("Edit successful").build();
		}

	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response removeAccount(@PathParam("id") long idToRemove) {
		Account myAccount = ACC_B.consultAccount(idToRemove);
		if (myAccount == null) {
			return Response.status(400).entity("Account doesn't exist").build();
		} else {
			myAccount.setId(idToRemove);
			ACC_B.removeAccount(myAccount);
			return Response.ok("Remove successful").build();
		}
	}

	@GET
	@Path("allIds")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Long> getAllIds() {
		return new ArrayList<Long>(ACC_B.getAllIds());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Account> getAllValues() {
		return ACC_B.getAllValues();
	}
	
}