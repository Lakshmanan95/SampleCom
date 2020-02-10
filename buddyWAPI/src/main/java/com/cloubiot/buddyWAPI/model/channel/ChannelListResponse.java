package com.cloubiot.buddyWAPI.model.channel;

import java.util.List;
import java.util.Map;

import com.cloubiot.buddyWAPI.base.BaseResponse;
import com.cloubiot.buddyWAPI.model.dbentity.Channel;
import com.mongodb.DBObject;

public class ChannelListResponse extends BaseResponse{

	List<DBObject> channel;

	public List<DBObject> getChannel() {
		return channel;
	}

	public void setChannel(List<DBObject> channel) {
		this.channel = channel;
	}
	
	
}
