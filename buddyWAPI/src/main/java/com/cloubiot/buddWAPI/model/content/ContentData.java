package com.cloubiot.buddWAPI.model.content;

import com.cloubiot.buddyWAPI.model.dbentity.Content;

public class ContentData extends Content{

	private String channel;
	private String id;
	private String channelName;
	private String location;
	private String language;
	private String formJson;
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
