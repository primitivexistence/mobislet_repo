package com.mobislet.mall;

import java.util.ArrayList;

import com.mobislet.data.PersistenceGateway;

public class MallManager {

	public static Long addMall(Mall mall) {
		PersistenceGateway.getPersistenceGateway().addAddress(mall.getAddress());
			return PersistenceGateway.getPersistenceGateway().addMall(mall);
	}

	public static Mall getMall(Long mallId) {
		return PersistenceGateway.getPersistenceGateway().getMall(mallId);
	}

	public static ArrayList<Long> getAllMallIds() {
		return PersistenceGateway.getPersistenceGateway().getAllMallIds();
	}
}
