package com.crud.demo.ws.Entity;

import java.io.Serializable;

import com.crud.demo.ws.shared.UserDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="Adr")
public class AdrEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4341773142012904501L;
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false, length=50)
	private String AdrId;
	@Column(nullable=false, length=50)
	private String city;
	@Column(nullable=false, length=50)
	private String street;
	
	@ManyToOne
	@JoinColumn(name="UserCrud_id")
	private UserEntity user;

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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	

}
