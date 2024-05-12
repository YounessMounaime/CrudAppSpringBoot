package com.crud.demo.ws.response;

import java.util.List;

public class UserResponse {

	private String userId;
	private String nom;
	private String prenom;
	private List<AdrResponse> Adr;
	private  ContactResonse contact;
	private Boolean admin  ;


	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public List<AdrResponse> getAdr() {
		return Adr;
	}

	public void setAdr(List<AdrResponse> adr) {
		Adr = adr;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String email;



	public ContactResonse getContact() {
		return contact;
	}

	public void setContact(ContactResonse contact) {
		this.contact = contact;
	}


}
