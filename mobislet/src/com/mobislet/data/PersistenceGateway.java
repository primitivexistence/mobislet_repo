package com.mobislet.data;

import java.util.ArrayList;

import com.mobislet.address.Address;
import com.mobislet.brand.Brand;
import com.mobislet.contact.Contact;
import com.mobislet.discovery.Discovery;
import com.mobislet.mall.Mall;
import com.mobislet.request.GetDiscoveryRequest;
import com.mobislet.store.Store;

public abstract class PersistenceGateway {
	public static final String FIREBIRD = "FIREBIRD";
	public static final String ORACLE = "ORACLE";
	public static final String POSTGRESQL = "POSTGRESQL";
	public static final String MYSQL = "MYSQL";
	
	private static final String PERSISTENCE_TYPE = MYSQL; //Change To Switch Persistence Methods.
	
	public static PersistenceGateway getPersistenceGateway() {
		if(PersistenceGateway.FIREBIRD.equals(PERSISTENCE_TYPE))
			return new FirebirdPersistenceService();
		else if(PersistenceGateway.ORACLE.equals(PERSISTENCE_TYPE))
			return null;
		else if(PersistenceGateway.POSTGRESQL.equals(PERSISTENCE_TYPE))
			return new PostgreSQLPersistenceService();
		else if(PersistenceGateway.MYSQL.equals(PERSISTENCE_TYPE))
			return new MySQLPersistenceService();
		
		return null;
	}


	// Address Methods
	public abstract Long addAddress(Address address);

	public abstract void deleteAddress(Long addressId);
	
	
	// Contact Methods;
	public abstract Long addContact(Contact contact);

	public abstract void addMallContactRel(Long mallID, Long contactID);
	
	public abstract void addStoreContactRel(Long storeID, Long contactID);

	
	// Brand methods;
	public abstract Brand getBrand(Long brandId);


	// Mall methods;
	public abstract Long addMall(Mall mall);

	public abstract ArrayList<Long> getAllMallIds();

	public abstract Mall getMall(Long mallId);



	// Store Methods;

	
	// Discovery Methods
	public abstract Discovery getDiscovery(String mallIdStr, String storeIdStr, String campaignIdStr);


	public abstract Long addBrand(Brand brand);


	public abstract Long addStore(Store store);


	public abstract String getMessage();


	
}
