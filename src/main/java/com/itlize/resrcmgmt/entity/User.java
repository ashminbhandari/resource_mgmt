package com.itlize.resrcmgmt.entity;

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

	@Column
	private String title;

	@Column
	private String creationTime;

	@Column 
	private String updateTime;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public User(int id, String username, String password, String title, String creationTime, String updateTime,
			List<Profile> profiles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.title = title;
		this.creationTime = creationTime;
		this.updateTime = updateTime;
		this.profiles = profiles;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User [creationTime=" + creationTime + ", id=" + id + ", password=" + password + ", profiles=" + profiles
				+ ", title=" + title + ", updateTime=" + updateTime + ", username=" + username + "]";
	}
}
