package com.mobislet.data;

import java.util.ArrayList;

import com.mobislet.address.Address;
import com.mobislet.brand.Brand;
import com.mobislet.contact.Contact;
import com.mobislet.discovery.Discovery;
import com.mobislet.mall.Mall;
import com.mobislet.request.GetDiscoveryRequest;

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
	public Long addAddress(Address address){return null;}

	public void deleteAddress(Long addressId){}
	
	
	// Contact Methods;
	public Long addContact(Contact contact){return null;}

	public void addMallContactRel(Long mallID, Long contactID){}
	
	public void addStoreContactRel(Long storeID, Long contactID){}

	
	// Brand methods;
	public Brand getBrand(Long brandId){return null;}


	// Mall methods;
	public Long addMall(Mall mall){return null;}

	public ArrayList<Long> getAllMallIds(){return null;}

	public Mall getMall(Long mallId){return null;}



	// Store Methods;

	
	// Discovery Methods
	public Discovery getDiscovery(String mallIdStr, String storeIdStr, String campaignIdStr){return null;}


	
	
	
}
