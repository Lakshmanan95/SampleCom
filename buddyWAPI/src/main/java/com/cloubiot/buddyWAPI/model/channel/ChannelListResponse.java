package com.cloubiot.buddyWAPI.model.channel;

import java.util.List;

import com.cloubiot.buddyWAPI.base.BaseResponse;
import com.cloubiot.buddyWAPI.model.dbentity.Channel;

public class ChannelListResponse extends BaseResponse{

	List<Channel> channel;

	public List<Channel> getChannel() {
		return channel;
	}

	public void setChannel(List<Channel> channel) {
		this.channel = channel;
	}
	
	
}
