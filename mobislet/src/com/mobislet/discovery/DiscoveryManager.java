package com.mobislet.discovery;

import java.util.ArrayList;

import com.mobislet.data.PersistenceGateway;
import com.mobislet.request.GetDiscoveryRequest;

public class DiscoveryManager {
	public DiscoveryManager() {}

	public static Discovery getDiscovery(GetDiscoveryRequest request) {
		PersistenceGateway persistenceGateway = PersistenceGateway.getPersistenceGateway();//PersistenceService.GOOGLE_DATA_STORE
		
		String mallIdItemStr = getListedIdItemString(request.getMallIdList());
		String storeIdItemStr = getListedIdItemString(request.getStoreIdList());
		String campaignIdItemStr = getListedIdItemString(request.getCampaignIdList());
		
		return persistenceGateway.getDiscovery(mallIdItemStr, storeIdItemStr, campaignIdItemStr);
	}
	
	private static String getListedIdItemString(ArrayList<Integer> idList){
		if(idList == null || idList.isEmpty())
			return null;
		
		StringBuffer str = new StringBuffer();
		
		for(Integer id : idList){
			str.append("'");
			str.append(id);
			str.append("'");
			str.append(",");
		}
		str.deleteCharAt(str.lastIndexOf(","));
		return str.toString();
	}
}
