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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import simSalProject.business.AccountBusiness;
import simSalProject.business.ColaboratorBusiness;
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
	AccountBusiness accBusiness;

	@Inject
	ColaboratorBusiness colabBusiness;

	@GET
	@Path("initDatabase")
	@Produces(MediaType.TEXT_PLAIN)
	public Response initDataBase() {
		String message = accBusiness.initDataBase();
		if (message == "ADMIN didn't exist, ADMIN created with default credentials") {
		} else if (message == "ADMIN already exists") {
			return Response.status(400).entity(message).build();
		}
		return Response.ok().entity(message).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAccount(AccountDTO myAccountDTO) {
		if (accBusiness.getAccCountByEmail(myAccountDTO.getEmail()) == 0) {
			String msg = accBusiness.createAccount(myAccountDTO);
			if (msg == "The email is not well written") {
				return Response.status(400).entity(msg).build();
			} else if (msg == "This Account already exists") {
				return Response.status(400).entity(msg).build();
			} else {
				return Response.ok(msg).build();
			}
		} else {
			return Response.status(400).entity("Account with this email already exists").build();
		}
	}

	@GET
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultAccount(@PathParam("email") String email) {
		if (accBusiness.getAccCountByEmail(email) == 0) {
			return Response.status(400).entity("Account doesn't exist").build();
		} else {
			return Response.ok(accBusiness.getAccountByEmail(email).get(0)).build();
		}
	}

	@POST
	@Path("login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(Account myAccount) {
		AccountDTO myAccountDTO = accBusiness.login(myAccount);
		String msg = myAccountDTO.getMessage();
		if (msg == "Email not valid") {
			return Response.status(400).entity(msg).build();
		}
		if (msg == "Email is not registered") {
			return Response.status(400).entity(msg).build();
		}
		if (msg == "Invalid password") {
			return Response.status(400).entity(msg).build();
		}
		if (msg == "You have to write the password!") {
			return Response.status(400).entity(msg).build();
		}
		return Response.ok(myAccountDTO).build();
	}

	@PUT
	@Path("editAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editAccount(Account myAccountToEdit) {
		if (accBusiness.getAccCountByEmail(myAccountToEdit.getEmail()) == 0) {
			return Response.status(404).entity("Account with that email doesn't exist").build();
		} else {
			String msg = accBusiness.changePassword(myAccountToEdit);
			if (msg == "Welcome user with new Password") {
				return Response.ok(msg).build();
			} else {
				return Response.ok(msg).build();
			}
		}
	}

	@DELETE
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeAccount(@PathParam("email") String emailToRemove) {
		if (accBusiness.getAccCountByEmail(emailToRemove) == 0) {
			return Response.status(400).entity("Account doesn't exist").build();
		} else {
			List<Account> accounts = accBusiness.getAccountByEmail(emailToRemove);
			Account myAccount = accounts.get(0);
			myAccount.setId(myAccount.getId());
			String msg = accBusiness.removeAccount(myAccount);
			if (msg == "Account Removed") {
				return Response.ok(msg).build();
			} else {
				return Response.status(400).entity(msg).build();
			}
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllValues() {
		if (accBusiness.getAccCount() == 0) {
			return Response.status(404).entity("There are no accounts").build();
		} else {
			return Response.ok().entity(accBusiness.getAllValues()).build();
		}
	}

	@GET
	@Path("allSimsFromAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSimsFromAccount(@QueryParam("email") String email) {
		if (accBusiness.getAccCountByEmail(email) == 0) {
			return Response.status(400).entity("Account with this email doesn't exist").build();
		} else {
			return Response.ok(colabBusiness.getColabsByAccount(accBusiness.getAccountByEmail(email).get(0))).build();
		}
	}

}
