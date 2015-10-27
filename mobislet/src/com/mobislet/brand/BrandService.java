package com.mobislet.brand;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.mobislet.request.GetBrandRequest;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;

@Path("/service/brand")
public class BrandService {
	@POST
	@Path("/getBrand")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBrand(GetBrandRequest request){
		ResponseBuilder builder = new ResponseBuilderImpl();
		try {
			builder.entity(BrandManager.getBrand(request.getBrandId()));
			builder.status(Status.OK);
		} catch (Exception e) {
			builder.status(Status.BAD_REQUEST);
		}
		
		return builder.build();
	}
}
