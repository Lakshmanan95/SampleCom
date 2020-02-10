package com.cloubiot.buddyWAPI.rest;

import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloubiot.buddyWAPI.base.SuccessResponse;
import com.cloubiot.buddyWAPI.common.CloubiotLogging;
import com.cloubiot.buddyWAPI.dao.ContentQuery;
import com.cloubiot.buddyWAPI.model.channel.ChannelListResponse;
import com.cloubiot.buddyWAPI.model.channel.ChannelRequest;
import com.cloubiot.buddyWAPI.model.dbentity.Channel;
import com.cloubiot.buddyWAPI.service.ChannelService;
import com.cloubiot.buddyWAPI.util.JSONUtil;


@RestController
@RequestMapping("/channel")
@CrossOrigin(origins = "*")
public class ChannelController {

	@Autowired
	ChannelService channelService;
	
	@Autowired
	ContentQuery contentQuery;
	
	@RequestMapping(method = RequestMethod.POST, value="/addUpdateChannel")
	public SuccessResponse addUpdateChannel(@RequestBody String request) {
		SuccessResponse response = new SuccessResponse();
		try {
			System.out.println("in ");
//			channelService.saveChannel(request.getChannel());
			JSONParser parser = new JSONParser();
			JSONObject json = (JSONObject) parser.parse(request);
//			JSONObject jsonObject = new JSONObject(request);
			System.out.println("jsonObject "+JSONUtil.toJson(json.get("request")));
			JSONParser parser1 = new JSONParser();
			JSONObject json1 = (JSONObject) parser.parse(json.get("request").toString());
		System.out.println("2 value "+json1.toString());
//			String value = contentQuery.addUpdateChannel(json1.toString());
			String record = contentQuery.getChannel();
			System.out.println("record "+JSONUtil.toJson(record));
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
			List<Channel> channel = channelService.getAllChannels();
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
