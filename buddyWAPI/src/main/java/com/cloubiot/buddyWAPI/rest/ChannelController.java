package com.cloubiot.buddyWAPI.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloubiot.buddyWAPI.base.SuccessResponse;
import com.cloubiot.buddyWAPI.common.CloubiotLogging;
import com.cloubiot.buddyWAPI.dao.ChannelQuery;
import com.cloubiot.buddyWAPI.model.channel.ChannelListResponse;
import com.cloubiot.buddyWAPI.model.channel.ChannelRequest;
import com.cloubiot.buddyWAPI.model.dbentity.Channel;
import com.cloubiot.buddyWAPI.service.ChannelService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.DBObject;

@RestController
@RequestMapping("/channel")
public class ChannelController {

	@Autowired
	ChannelService channelService;
	
	@Autowired
	ChannelQuery channelQuery;
	
	@RequestMapping(method = RequestMethod.POST, value="/addUpdateChannel")
	public SuccessResponse addUpdateChannel(@RequestBody String request) {
		SuccessResponse response = new SuccessResponse();
		try {
			JsonParser parser = new JsonParser();
			JsonObject json = (JsonObject) parser.parse(request);
			JsonParser parser1 = new JsonParser();
			JsonObject json1 = (JsonObject) parser.parse(json.get("channel").toString());
			channelQuery.addUpdateChannel(json1);
			CloubiotLogging.logInfo(getClass(), "Channel Updated");
		}
		catch(Exception e) {
			CloubiotLogging.logError(getClass(), "Channel Updated failed", e);
			response.setSuccess(false);	
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="getChannels")
	public ChannelListResponse getChannels() {
		ChannelListResponse response = new ChannelListResponse();
		try {
			List<DBObject> channel = channelQuery.getChannels();
			response.setChannel(channel);
			CloubiotLogging.logInfo(getClass(), "Channel List");
		}
		catch(Exception e) {
			CloubiotLogging.logError(getClass(), "Channel List failed", e);
			response.setSuccess(false);
		}
		return response;
	}
}
