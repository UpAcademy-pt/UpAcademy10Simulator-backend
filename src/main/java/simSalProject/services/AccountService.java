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

	/**
	 * This method is used to initialize the database, persisting the admin with
	 * default credentials.
	 * @return Response message.
	 */
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

	/**
	 * Creates an account.
	 * @param AccountDTO myAccountDTO
	 * @return Response message.
	 */
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

	/**
	 * Gets an Account from database.
	 * @param String email
	 * @return Response error message or Account.
	 */
	@GET
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response consultAccount(@PathParam("email") String email) {
		if (accBusiness.getAccCountByEmail(email) == 0) {
			return Response.status(404).entity("Account doesn't exist").build();
		} else {
			return Response.ok(accBusiness.getAccountByEmail(email).get(0)).build();
		}

	}

	/**
	 * Verifies login credentials.
	 * @param Account myAccount
	 * @return Response error message or AccountDTO.
	 */
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

	/**
	 * Edits Account password
	 * @param Account myAccountToEdit
	 * @return Response message.
	 */
	@PUT
	@Path("editAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response editAccount(Account myAccountToEdit) {
		if (accBusiness.getAccCountByEmail(myAccountToEdit.getEmail()) == 0) {
			return Response.status(404).entity("Account with that email doesn't exist").build();
		} else {
			String msg = accBusiness.changePassword(myAccountToEdit);
			if (msg == "New Password has been set") {
				return Response.ok(msg).build();
			} else {
				return Response.ok(msg).build();
			}
		}
	}

	
	/**
	 * Deletes an account from database
	 * @param String emailToRemove
	 * @return Response message.
	 */
	@DELETE
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeAccount(@PathParam("email") String emailToRemove) {
		if (accBusiness.getAccCountByEmail(emailToRemove) == 0) {
			return Response.status(404).entity("Account doesn't exist").build();
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

	/**
	 * Get all accounts from database
	 * @return Response error message or List<AccountDTO>
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllValues() {
		if (accBusiness.getAccCount() == 0) {
			return Response.status(400).entity("There are no accounts").build();
		} else {
			return Response.ok().entity(accBusiness.getAllValues()).build();
		}
	}

	/**
	 * Gets all Accounts with Simulations
	 * @param String email
	 * @return Response error message or List<AccountDTO>
	 */
	@GET
	@Path("allSimsFromAccount")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSimsFromAccount(@QueryParam("email") String email) {
		if (accBusiness.getAccCountByEmail(email) == 0) {
			return Response.status(404).entity("Account with this email doesn't exist").build();
		} else {
			return Response.ok(colabBusiness.getColabsByAccount(accBusiness.getAccountByEmail(email).get(0))).build();
		}
	}
	
	/**
	 * Gets all Simulations from an Account
	 * @param String email
	 * @return Response error message or AccountDTO
	 */
	@GET
	@Path("allSimsFromAccountWithDate")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSimsFromAccountWithDate(@QueryParam("email") String email) {
		if (accBusiness.getAccCountByEmail(email) == 0) {
			return Response.status(404).entity("Account with this email doesn't exist").build();
		} else {
			return Response.ok(colabBusiness.getColabsByAccount(accBusiness.getAccountByEmail(email).get(0))).build();
		}
	}
	
	/**
	 * Gets all Simulations between dates for an Account
	 * @param String email
	 * @param long startDate
	 * @param long endDate
	 * @return Response AccountDTO 
	 */
	@GET
	@Path("accWithFilterSimsBetweenDates")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccWithFilterSimsBetweenDates(@QueryParam("email")String email, @QueryParam("startDate") long startDate, @QueryParam("endDate") long endDate) {
		return Response.ok().entity(accBusiness.getAccWithFilterSimsBetweenDates(email, startDate, endDate)).build();
				
	}
	
	/**
	 * Gets all Simulations between dates for all Accounts
	 * @param long startDate
	 * @param long endDate
	 * @return Response List<AccountDTO>
	 */
	@GET
	@Path("accsWithFilterSimsBetweenDates")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccsWithFilterSimsBetweenDates(@QueryParam("startDate")long startDate, @QueryParam("endDate") long endDate) {
		return Response.ok().entity(accBusiness.getAccsWithFilterSimsBetweenDates(startDate, endDate)).build();	
	}
	
	/**
	 * Gets all Simulations for all Accounts
	 * @return Response List<AccountDTO>
	 */
	@GET
	@Path("allSimsForAccounts")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSimsForAllAccs() {
		return Response.ok().entity(accBusiness.getSimsForAllAccs()).build();
	}


}
