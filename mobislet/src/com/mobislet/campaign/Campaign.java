package com.mobislet.campaign;

import java.util.Date;

public class Campaign {
	private Long id;
	private String name;
	private String dscr;
	private Date startDate;
	private Date endDate;
	private String image;
	private CampaignStatus cmpStatus;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDscr() {
		return dscr;
	}
	public void setDscr(String dscr) {
		this.dscr = dscr;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public CampaignStatus getCmpStatus() {
		return cmpStatus;
	}
	public void setCmpStatus(CampaignStatus cmpStatus) {
		this.cmpStatus = cmpStatus;
	}
	
	
}
