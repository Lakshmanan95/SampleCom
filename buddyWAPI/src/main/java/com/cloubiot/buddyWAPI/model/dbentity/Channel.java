package com.cloubiot.buddyWAPI.model.dbentity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.bson.types.ObjectId;

@Entity
public class Channel {

	@Id
	private ObjectId _id;
	private String channelName;
	private String location;
	private String language;
	private String formJson;
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getFormJson() {
		return formJson;
	}
	public void setFormJson(String formJson) {
		this.formJson = formJson;
	}
	
	
	
}
