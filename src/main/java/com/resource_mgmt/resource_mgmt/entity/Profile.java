package com.resource_mgmt.resource_mgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ITLIZE_USER_PROFILE")
public class Profile {

	@Id
	private int id;
	
	@Column
	private String type;
}

