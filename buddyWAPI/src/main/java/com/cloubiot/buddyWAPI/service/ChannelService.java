package com.cloubiot.buddyWAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloubiot.buddyWAPI.dao.ChannelRepository;
import com.cloubiot.buddyWAPI.model.dbentity.Channel;

@Service
public class ChannelService {

	@Autowired
	ChannelRepository channelRepository;
	
	public Channel saveChannel(Channel channel) {
		return channelRepository.save(channel);
	}
	
	public List<Channel> getAllChannels() {
		return (List<Channel>) channelRepository.findAll();
	}
}
