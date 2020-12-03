package com.resource_mgmt.resource_mgmt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "ITLIZE_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(
		name = "ITLIZE_USER_ITLIZE_USER_PROFILE",
		joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
		},
		inverseJoinColumns = {
			@JoinColumn(name = "USER_PROFILE_ID", referencedColumnName = "ID")
		}
	)
	private List<Profile> profiles;
}
