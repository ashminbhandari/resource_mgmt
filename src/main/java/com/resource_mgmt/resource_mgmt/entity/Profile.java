package com.resource_mgmt.resource_mgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ITLIZE_USER_PROFILE")
public class Profile {

	@Id
	private int id;
	
	@Column
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Profile(int id, String type) {
		this.id = id;
		this.type = type;
	}

	public Profile() {
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", type=" + type + "]";
	}
}

