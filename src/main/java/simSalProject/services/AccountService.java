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
import simSalProject.business.AccountBusiness.CreateAccountException;
import simSalProject.business.AccountBusiness.ExistingEmailException;
import simSalProject.business.AccountBusiness.InvalidEmailException;
import simSalProject.models.Account;
import simSalProject.models.AccountDTO;

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
		if (message == "ADMIN didn't exist, ADMIN created with default credentials") {

		} else if (message == "ADMIN already exists") {
			return Response.status(400).entity(message).build();

		}
		return Response.ok().entity(message).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response createAccount(Account myAccount) {
		String msg = ACC_B.createAccount(myAccount.getEmail());
		if (msg == "The email is not well written" ) {
			return Response.status(400).entity(msg).build();
		}
		if (msg == "This Account already exists" ) {
			return Response.status(400).entity(msg).build();
		} else {
			return Response.ok(msg).build();
		}

		return Response.ok("Account created").build();
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

	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Account myAccount) {
		AccountDTO myAccountDTO = ACC_B.login(myAccount);
		String msg = myAccountDTO.getMessage();
		if (msg == "The email you've written is not an email") {
			Response.status(400).entity(msg).build();
		}
		if (msg == "That email is not registered") {
			Response.status(400).entity(msg).build();
		}
		if (msg == "Not a valid password") {
			Response.status(400).entity(msg).build();
		}

		return Response.ok(myAccountDTO).build();

	}

	@PUT
	@Path("editAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response editAccount(Account myAccountToEdit) {
		ACC_B.changePassword(myAccountToEdit);
		
		return Response.ok().build();
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
			return Response.ok("Account successfully removed").build();
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
