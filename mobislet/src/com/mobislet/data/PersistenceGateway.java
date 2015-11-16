package com.mobislet.data;

import java.util.ArrayList;

import com.mobislet.address.Address;
import com.mobislet.brand.Brand;
import com.mobislet.discovery.Discovery;
import com.mobislet.mall.Mall;
import com.mobislet.request.GetDiscoveryRequest;

public abstract class PersistenceGateway {
	public static final String FIREBIRD = "FIREBIRD";
	public static final String ORACLE = "ORACLE";
	public static final String POSTGRESQL = "POSTGRESQL";
	private static final String PERSISTENCE_TYPE = POSTGRESQL; //Change To Switch Persistence Methods.
	
	public static PersistenceGateway getPersistenceGateway() {
		if(PersistenceGateway.FIREBIRD.equals(PERSISTENCE_TYPE))
			return new FirebirdPersistenceService();
		else if(PersistenceGateway.ORACLE.equals(PERSISTENCE_TYPE))
			return null;
		else if(PersistenceGateway.POSTGRESQL.equals(PERSISTENCE_TYPE))
			return new PostgreSQLPersistenceService();
		
		return null;
	}

	public Brand getBrand(Long brandId) {
		return null;
	}

	public void addMall(Mall mall) {}

	public Long addAddress(Address address) {
		return null;
	}

	public void deleteAddress(Long addressId) {}

	public ArrayList<Long> getAllMallIds() {
		return null;
	}

	public Mall getMall(Long mallId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Discovery getDiscovery(String mallIdStr, String storeIdStr, String campaignIdStr) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
