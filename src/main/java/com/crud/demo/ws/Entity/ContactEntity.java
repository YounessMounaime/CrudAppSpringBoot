package com.crud.demo.ws.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name="Contact")
public class ContactEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -830562320250349333L;

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String contactId;
	@Column(nullable=false, length=50)
	private String mobile;
	@Column(nullable=false, length=50)
	private String emailPro;
	@OneToOne()
	@JoinColumn(name="UserCrud_id")
	private UserEntity user;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmailPro() {
		return emailPro;
	}
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	
	

}
