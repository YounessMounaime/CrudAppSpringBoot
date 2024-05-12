package com.crud.demo.ws.request;

import java.util.List;

import jakarta.validation.constraints.*;

public class UserRequest {

	@NotNull(message = "Le nom ne peut pas être vide")
	@Size(min = 3)
	private String nom;

	@NotNull(message = "Le prenom ne peut pas être vide")
	@Size(min = 3)
	private String prenom;
	
	@NotNull(message = "Adr  ne peut pas être vide")
	private List<AdrRequest> Adr ;
	//@NotNull(message = "contact  ne peut pas être vide")
	private ContactRequest  contact;
	
	private Boolean admin  ;
	
	
	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public ContactRequest getContact() {
		return contact;
	}

	public void setContact(ContactRequest Contact) {
		this.contact = Contact;
	}

	@NotNull
	@Email(message = "Email 9ado mzyane hhhh")
	private String email;

	@NotNull
	@Size(min = 3, max = 12)
	private String password;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AdrRequest> getAdr() {
		return Adr;
	}

	public void setAdr(List<AdrRequest> adr) {
		Adr = adr;
	}



}
