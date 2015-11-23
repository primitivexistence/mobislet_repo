package com.mobislet.helloworld;

import com.mobislet.data.PersistenceGateway;


public class HelloWorldManager {
	public HelloWorldManager() {}

	public static String getMessage() {
		PersistenceGateway persistenceGateway = PersistenceGateway.getPersistenceGateway();
		return persistenceGateway.getMessage();
	}
	
}
