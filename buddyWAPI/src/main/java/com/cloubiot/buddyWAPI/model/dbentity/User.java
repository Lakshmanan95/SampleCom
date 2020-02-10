package com.cloubiot.buddyWAPI.model.dbentity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.bson.types.ObjectId;

@Entity
public class User {

	@Id
	@GeneratedValue
	private ObjectId id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String phoneNumber;
	private String location;
	private List<Integer> languageId;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Integer> getLanguageId() {
		return languageId;
	}
	public void setLanguageId(List<Integer> languageId) {
		this.languageId = languageId;
	}
	
	
}
