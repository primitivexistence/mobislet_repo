package com.mobislet.data;

import com.mobislet.address.Address;
import com.mobislet.brand.Brand;
import com.mobislet.mall.Mall;

public abstract class PersistenceGateway {
	public static final String FIREBIRD = "FIREBIRD";
	public static final String ORACLE = "ORACLE";
	private static final String PERSISTENCE_TYPE = FIREBIRD; //Change To Switch Persistence Methods.
	
	public static PersistenceGateway getPersistenceGateway() {
		if(PersistenceGateway.FIREBIRD.equals(PERSISTENCE_TYPE))
			return new FirebirdPersistenceService();
		else if(PersistenceGateway.ORACLE.equals(PERSISTENCE_TYPE))
			return new FirebirdPersistenceService();
		
		return null;
	}

	public Brand getBrand(Long brandId) {
		return null;
	}

	public void addMall(Mall mall) {}

	public Long addAddress(Address address) {
		return null;
	}
	
	
}
