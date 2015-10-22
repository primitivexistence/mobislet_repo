package com.mobislet.brand;

import com.mobislet.data.PersistenceGateway;


public class BrandManager {
	public BrandManager() {}

	public static Brand getBrand(Long brandId) {
		PersistenceGateway persistenceGateway = PersistenceGateway.getPersistenceGateway();//PersistenceService.GOOGLE_DATA_STORE
		return persistenceGateway.getBrand(brandId);
	}
}
