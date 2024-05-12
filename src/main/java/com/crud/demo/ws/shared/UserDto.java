package com.crud.demo.ws.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.demo.ws.request.AdrRequest;

public class UserDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private long id;
    private String userId;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String encryptepassword;
    private String emailToken;
    private Boolean emailVerf;
	private List<AdrDto> Adr;
	private ContactDto contact;
	private Boolean admin ;



	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptepassword() {
        return encryptepassword;
    }

    public void setEncryptepassword(String encryptepassword) {
        this.encryptepassword = encryptepassword;
    }

    public Boolean getEmailVerf() {
        return emailVerf;
    }

    public void setEmailVerf(Boolean emailVerf) {
        this.emailVerf = emailVerf;
    }

    public String getEmailToken() {
        return emailToken;
    }

    public void setEmailToken(String emailToken) {
        this.emailToken = emailToken;
    }

	public List<AdrDto> getAdr() {
		return Adr;
	}

	public void setAdr(List<AdrDto> adr) {
		Adr = adr;
	}

	public ContactDto getContact() {
		return contact;
	}

	public void setContact(ContactDto contact) {
		this.contact = contact;
	}


	
}
