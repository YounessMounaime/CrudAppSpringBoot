package com.crud.demo.ws.Entity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

@Entity(name="UserCrud")

public class UserEntity {
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String userId;
	
	@Column(nullable=false, length=50)
	private String nom;
	
	@Column(nullable=false, length=50)
	private String prenom;
	
	@Column(nullable=false, length=120, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@OneToMany(mappedBy="user", cascade =CascadeType.ALL)
	private  List<AdrEntity> Adr;
	
	@OneToOne(mappedBy="user", cascade =CascadeType.ALL)
	private ContactEntity contact;
 
	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL , mappedBy="users")
	private Set<GroupsEntity> groups = new HashSet<>();
	
	@Column(nullable=true)
	private Boolean admin = false ;
	
	


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(nullable=false)
	private String encryptepassword;
	
	@Column(nullable=true)
	private String emailVerf;
	
	@Column(nullable=true)
	private Boolean emailToken = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getEncryptepassword() {
		return encryptepassword;
	}

	public void setEncryptepassword(String encryptepassword) {
		this.encryptepassword = encryptepassword;
	}

	public String getEmailVerf() {
		return emailVerf;
	}

	public void setEmailVerf(String emailVerf) {
		this.emailVerf = emailVerf;
	}

	public Boolean getEmailToken() {
		return emailToken;
	}

	public void setEmailToken(Boolean emailToken) {
		this.emailToken = emailToken;
	}

	public List<AdrEntity> getAdr() {
		return Adr;
	}

	public void setAdr(List<AdrEntity> adr) {
		Adr = adr;
	}

	public ContactEntity getContact() {
		return contact;
	}

	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}


	
}
