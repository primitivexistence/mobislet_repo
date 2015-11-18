package com.mobislet.mall;

import java.math.BigDecimal;

import com.mobislet.address.Address;

public class Mall {

	private Long id;
	private String name;
	private String dscr;
	private Address address;
	private String addressDscr;
	private BigDecimal latitude;
	private BigDecimal longitude;
	private BigDecimal altitude;
	private String image;
	private String cinema;
	private String carParking;
	private int mallType;
	
	public String getCinema() {
		return cinema;
	}
	public void setCinema(String cinema) {
		this.cinema = cinema;
	}
	public String getCarParking() {
		return carParking;
	}
	public void setCarParking(String carParking) {
		this.carParking = carParking;
	}
	public int getMallType() {
		return mallType;
	}
	public void setMallType(int mallType) {
		this.mallType = mallType;
	}
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
	
}
