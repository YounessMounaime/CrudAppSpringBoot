package com.crud.demo.ws.shared;

import java.io.Serializable;

public class AdrDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8762852450876547790L;
	private Long id;
	private String AdrId;
	private String city;
	private String street;
	private UserDto user;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdrId() {
		return AdrId;
	}
	public void setAdrId(String adrId) {
		AdrId = adrId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	

}
