package com.qa.data;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Users {
	String name;
	String job;
	String id;
	String createdAt;
	@JsonIgnore
	String updatedAt;
	public String getUpdatedAt() {
		return updatedAt;
	}
	Users(){}
	public Users(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
public String getJob() {
		return job;
	}
	public String getId() {
		return id;
	}
	public String getCreatedAt() {
		return createdAt;
	}
}
