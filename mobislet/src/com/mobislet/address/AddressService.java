package com.mobislet.address;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.mobislet.request.AddAddressRequest;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;

@Path("/service/address")
public class AddressService {

	@POST
	@Path("/addAddress")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAddress(AddAddressRequest request){
		ResponseBuilder builder = new ResponseBuilderImpl();
		try {
			builder.entity(AddressManager.addAddress(request.getAddress()));
			builder.status(Status.OK);
		} catch (Exception e) {
			e.printStackTrace();
			builder.status(Status.BAD_REQUEST);
		}
		
		return builder.build();
	}
}
