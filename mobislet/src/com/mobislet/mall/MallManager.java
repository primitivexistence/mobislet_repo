package com.mobislet.mall;

import com.mobislet.data.PersistenceGateway;

public class MallManager {

	public static void addMall(Mall mall) {
		PersistenceGateway.getPersistenceGateway().addAddress(mall.getAddress());
		try{
			PersistenceGateway.getPersistenceGateway().addMall(mall);
		}catch(Exception e){
			//remove address.
		}
	}

}
