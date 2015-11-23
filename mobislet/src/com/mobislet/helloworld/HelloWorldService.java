package com.mobislet.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.mobislet.mall.MallManager;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;

@Path("/service/helloworld")
public class HelloWorldService {

	@GET
	@Path("/message")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessage(){
		ResponseBuilder builder = new ResponseBuilderImpl();
		try {
			builder.entity(HelloWorldManager.getMessage());
			builder.status(Status.OK);
		} catch (Exception e) {
			builder.status(Status.BAD_REQUEST);
		}
		
		return builder.build();
	}
}
