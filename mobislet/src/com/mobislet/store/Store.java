package com.mobislet.store;

import java.math.BigDecimal;

import com.mobislet.address.Address;
import com.mobislet.brand.Brand;
import com.mobislet.mall.Mall;

public class Store {
	private Long id;
	private String name;
	private String dscr;
	private Address address;
	private String addressDscr;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private BigDecimal altitude;
	private String image;
	private Brand brand;
	private Mall mall;
	
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
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getAddressDscr() {
		return addressDscr;
	}
	public void setAddressDscr(String addressDscr) {
		this.addressDscr = addressDscr;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public BigDecimal getAltitude() {
		return altitude;
	}
	public void setAltitude(BigDecimal altitude) {
		this.altitude = altitude;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public Mall getMall() {
		return mall;
	}
	public void setMall(Mall mall) {
		this.mall = mall;
	}
	
}
