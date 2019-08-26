package simSalProject.services;

import java.util.Collection;

import javax.inject.Inject;
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
import simSalProject.models.Colaborator;
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
	IRSTableBusiness irsBusiness;

	@GET
	@Path("alltable")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllIRSTable() {

		return Response.ok().entity(irsBusiness.getAllIRSTable()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createIRSTable(Collection <IRSTable> table) {
		irsBusiness.createIRSTable(table);

		return Response.ok().entity("Table uploaded").build();
	}
	
	@POST
	@Path("filtertable")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response filterIRSTable(Colaborator colaborator) {
		Collection<Object[]> filteredTable= irsBusiness.filterIRSTable(colaborator);
		
		return Response.ok().entity(filteredTable).build();
	}
}
