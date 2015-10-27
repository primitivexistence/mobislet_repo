package com.mobislet.address;

import com.mobislet.data.PersistenceGateway;


public class AddressManager {
	public AddressManager() {}

	public static Long addAddress(Address address) {
		PersistenceGateway persistenceGateway = PersistenceGateway.getPersistenceGateway();//PersistenceService.GOOGLE_DATA_STORE
		return persistenceGateway.addAddress(address);
	}
	
	public static void deleteAddress(Long addressId) {
		PersistenceGateway persistenceGateway = PersistenceGateway.getPersistenceGateway();//PersistenceService.GOOGLE_DATA_STORE
		persistenceGateway.deleteAddress(addressId);
	}
}
