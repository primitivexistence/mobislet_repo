package com.mobislet.contact;


public class Contact {

	private Long id;
	private String name;
	private int type;
	
	
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
	public int getImage() {
		return getType();
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getType() {
		return type;
	}
}
