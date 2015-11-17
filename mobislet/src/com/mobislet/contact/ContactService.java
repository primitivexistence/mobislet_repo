package com.mobislet.contact;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import com.mobislet.request.AddAddressRequest;
import com.mobislet.request.AddContactRequest;
import com.sun.jersey.core.spi.factory.ResponseBuilderImpl;

@Path("/service/contact")
public class ContactService {

	@POST
	@Path("/addContact")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addContact(AddContactRequest request){
		ResponseBuilder builder = new ResponseBuilderImpl();
		try {
			builder.entity(ContactManager.addContact(request.getContact()));
			builder.status(Status.OK);
		} catch (Exception e) {
			e.printStackTrace();
			builder.status(Status.BAD_REQUEST);
		}
		
		return builder.build();
	}
}
