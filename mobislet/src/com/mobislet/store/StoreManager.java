package com.mobislet.store;

import com.mobislet.data.PersistenceGateway;

public class StoreManager {

	public static Long addStore(Store store) {
		PersistenceGateway persistenceGateway = PersistenceGateway.getPersistenceGateway();
		return persistenceGateway.addStore(store);
	}

	
}
