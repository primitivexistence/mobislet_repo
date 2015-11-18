package com.mobislet.contact;

import com.mobislet.data.PersistenceGateway;

public class ContactManager {
	public ContactManager() {}

	public static Long addContact(Contact contact) {
		
		PersistenceGateway persistenceGateway = PersistenceGateway.getPersistenceGateway();
		return persistenceGateway.addContact(contact);
	}
	
	public static void addMallContactRel(Long mallID, Long contactID) {
		PersistenceGateway persistenceGateway = PersistenceGateway.getPersistenceGateway();
		persistenceGateway.addMallContactRel(mallID, contactID);
	}

	public static void addStoreContactRel(Long storeID,
			Long contactID) {
		PersistenceGateway persistenceGateway = PersistenceGateway.getPersistenceGateway();
		persistenceGateway.addStoreContactRel(storeID, contactID);
		
	}

}
