package com.cloubiot.buddyWAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloubiot.buddyWAPI.dao.ChannelQuery;
import com.cloubiot.buddyWAPI.dao.ChannelRepository;
import com.cloubiot.buddyWAPI.model.dbentity.Channel;
import com.google.gson.JsonObject;
import com.mongodb.DBObject;

@Service
public class ChannelService {

	@Autowired
	ChannelRepository channelRepository;
	
	@Autowired
	ChannelQuery channelQuery;
	
	public Channel saveChannel(Channel channel) {
		return channelRepository.save(channel);
	}
	
	public void addAndUpdateChannel(JsonObject jsonObject) {
		channelQuery.addUpdateChannel(jsonObject);
	}
	
	public List<DBObject> getAllChannels() {
		return (List<DBObject>) channelQuery.getChannels();
	}
}
