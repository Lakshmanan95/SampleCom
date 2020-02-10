package com.cloubiot.buddyWAPI.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloubiot.buddWAPI.model.content.ContentResponse;
import com.cloubiot.buddyWAPI.base.SuccessResponse;
import com.cloubiot.buddyWAPI.common.CloubiotLogging;
import com.cloubiot.buddyWAPI.model.dbentity.Content;
import com.cloubiot.buddyWAPI.model.request.ContactRequest;
import com.cloubiot.buddyWAPI.service.ContentService;
import com.cloubiot.buddyWAPI.util.JSONUtil;

@RestController
@RequestMapping("/contact")
public class ContentController {
	
	@Autowired
	ContentService contentService;

	@RequestMapping(method = RequestMethod.GET, value="/get")
	public String getString() {
		return "Hello World";
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/saveContact")
	public SuccessResponse saveContact(@RequestBody ContactRequest request) {
		SuccessResponse response = new SuccessResponse();
		try {
			System.out.println("Contact "+JSONUtil.toJson(request.getContact()));
			SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
		    String strDate = formatter.format(new Date());  
			if(request.getContact().get_id() == null)
				request.getContact().setCreatedDate(strDate);
			contentService.saveContact(request.getContact());
		}
		catch(Exception e) {
			CloubiotLogging.logError(getClass(), "Save Contact failed", e);
			response.setSuccess(true);
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/getContent")
	public ContentResponse getContent(@RequestParam (value="channelId", defaultValue="") String channelId){
		ContentResponse response = new ContentResponse();
		try {
			List<Content> content = new ArrayList<Content>();
			System.out.println("Id "+channelId);
			if(channelId != null && !channelId.isEmpty())
				content = contentService.getContentByChannelId(channelId);
			else
				content = contentService.getAllContent();
			response.setContent(content);
		}
		catch(Exception e) {
			CloubiotLogging.logError(getClass(), "Get Contact failed", e);
			response.setSuccess(true);
		}
		return response;
	}
}
