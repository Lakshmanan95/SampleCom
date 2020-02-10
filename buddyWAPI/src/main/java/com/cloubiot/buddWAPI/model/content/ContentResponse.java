package com.cloubiot.buddWAPI.model.content;

import java.util.List;

import com.cloubiot.buddyWAPI.base.BaseResponse;
import com.cloubiot.buddyWAPI.model.dbentity.Content;

public class ContentResponse extends BaseResponse {

	List<Content> content;

	public List<Content> getContent() {
		return content;
	}

	public void setContent(List<Content> content) {
		this.content = content;
	}
	
	
}
