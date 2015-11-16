package com.mobislet.discovery;

import java.util.ArrayList;

import com.mobislet.campaign.Campaign;
import com.mobislet.mall.Mall;
import com.mobislet.store.Store;


public class Discovery {
	private ArrayList<Store> storeList;
	private ArrayList<Mall> mallList;
	private ArrayList<Campaign> campaignList;
	
	public ArrayList<Store> getStoreList() {
		return storeList;
	}
	public void setStoreList(ArrayList<Store> storeList) {
		this.storeList = storeList;
	}
	public ArrayList<Mall> getMallList() {
		return mallList;
	}
	public void setMallList(ArrayList<Mall> mallList) {
		this.mallList = mallList;
	}
	public ArrayList<Campaign> getCampaignList() {
		return campaignList;
	}
	public void setCampaignList(ArrayList<Campaign> campaignList) {
		this.campaignList = campaignList;
	}
	
	
}
