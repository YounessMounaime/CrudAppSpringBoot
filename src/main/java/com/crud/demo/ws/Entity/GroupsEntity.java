package com.crud.demo.ws.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;



@Entity(name="Groups")
public class GroupsEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6533375461538353065L;
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String groupsId;
	@Column(nullable=false)
	private String name;
	

	@ManyToMany(fetch = FetchType.LAZY , cascade = CascadeType.ALL)	
	@JoinTable(name = "groups_users" , joinColumns = {@JoinColumn(name = "Groups_id")} , inverseJoinColumns = {@JoinColumn(name = "UserCrud_id")} )
	private Set<UserEntity> users = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroupsId() {
		return groupsId;
	}

	public void setGroupsId(String groupsId) {
		this.groupsId = groupsId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
	
	
	

}
