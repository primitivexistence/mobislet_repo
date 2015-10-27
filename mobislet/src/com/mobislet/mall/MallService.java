package com.mobislet.mall;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.mobislet.request.AddMallRequest;
import com.mobislet.request.GetMallRequest;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;

@Path("/service/mall")
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
	
	@GET
	@Path("/getMall")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMall(GetMallRequest request){
		ResponseBuilder builder = new ResponseBuilderImpl();
		try {
			builder.entity(MallManager.getMall(request.getMallId()));
			builder.status(Status.OK);
		} catch (Exception e) {
			builder.status(Status.BAD_REQUEST);
		}
		
		return builder.build();
	}
	
	@GET
	@Path("/getAllMallIds")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllMallIds(){
		ResponseBuilder builder = new ResponseBuilderImpl();
		try {
			builder.entity(MallManager.getAllMallIds());
			builder.status(Status.OK);
		} catch (Exception e) {
			builder.status(Status.BAD_REQUEST);
		}
		
		return builder.build();
	}
}
