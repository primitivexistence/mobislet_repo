package com.mobislet.mall;

import java.util.ArrayList;

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

	public static ArrayList<Long> getAllMallIds() {
		return PersistenceGateway.getPersistenceGateway().getAllMallIds();
	}

	public static Mall getMall(Long mallId) {
		return PersistenceGateway.getPersistenceGateway().getMall(mallId);
	}

}
