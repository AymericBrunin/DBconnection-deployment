package stefan.DBconnectiondeployment.service;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderService {
	@GET
    @Path("/orders")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllOrders() throws JsonProcessingException;
	
	@GET
	@Path("/orders/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOneOrder(@PathParam("id") int id) throws JsonProcessingException;

	@PUT
	@Path("/orders/{id}/{status}")
	public void updateStatus(@PathParam("id") int id,@PathParam("status") String status);
	
	@DELETE 
	@Path("/orders/{id}")
	public void deleteOrder(@PathParam("id") int id);
}
