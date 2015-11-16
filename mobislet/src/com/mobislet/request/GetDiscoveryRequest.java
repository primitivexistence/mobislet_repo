package com.mobislet.request;

import java.util.ArrayList;

public class GetDiscoveryRequest {
	private ArrayList<Integer> storeIdList;
	private ArrayList<Integer> mallIdList;
	private ArrayList<Integer> campaignIdList;
	
	public ArrayList<Integer> getStoreIdList() {
		return storeIdList;
	}
	public void setStoreIdList(ArrayList<Integer> storeIdList) {
		this.storeIdList = storeIdList;
	}
	public ArrayList<Integer> getMallIdList() {
		return mallIdList;
	}
	public void setMallIdList(ArrayList<Integer> mallIdList) {
		this.mallIdList = mallIdList;
	}
	public ArrayList<Integer> getCampaignIdList() {
		return campaignIdList;
	}
	public void setCampaignIdList(ArrayList<Integer> campaignIdList) {
		this.campaignIdList = campaignIdList;
	}
	
}
