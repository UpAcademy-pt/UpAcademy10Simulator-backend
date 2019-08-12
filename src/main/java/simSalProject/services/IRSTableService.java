package simSalProject.services;

import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import simSalProject.business.IRSTableBusiness;
import simSalProject.models.IRSTable;

@Path("irstable")
public class IRSTableService {
	@Context
	private UriInfo context;

	@GET
	@Path("healthCheck")
	@Produces(MediaType.TEXT_PLAIN)
	public String healthCheck() {
		return "URI " + context.getRequestUri().toString() + " is OK!";
	}

	@Inject
	@Named("IRSTableBus")
	IRSTableBusiness IRS_B;

	@GET
	@Path("alltable")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllIRSTable() {

		return Response.ok().entity(IRS_B.getAllIRSTable()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createIRSTable(Collection <IRSTable> table) {
		IRS_B.createIRSTable(table);

		return Response.ok().entity("entrou").build();
	}
}
