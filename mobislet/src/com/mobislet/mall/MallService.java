package com.mobislet.mall;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.mobislet.request.AddMallRequest;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;

@Path("/service")
public class MallService {
	@POST
	@Path("/addMall")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMall(AddMallRequest request){
		ResponseBuilder builder = new ResponseBuilderImpl();
		try {
			MallManager.addMall(request.getMall());
			builder.status(Status.OK);
		} catch (Exception e) {
			builder.status(Status.BAD_REQUEST);
		}
		
		return builder.build();
	}
}
