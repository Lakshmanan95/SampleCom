package com.cloubiot.buddyWAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloubiot.buddWAPI.model.content.ContentData;
import com.cloubiot.buddyWAPI.dao.ContentQuery;
import com.cloubiot.buddyWAPI.dao.ContentRepository;
import com.cloubiot.buddyWAPI.model.dbentity.Content;
import com.cloubiot.buddyWAPI.util.JSONUtil;

@Service
public class ContentService {

	@Autowired
	ContentRepository contactRepository;
	
	@Autowired
	ContentQuery contactQuery;
	
	public Content saveContact(Content contact) {
		return contactRepository.save(contact);
	}
	
	public List<Content> getAllContent(){
		return contactRepository.findAll();
	}
	
	public List<Content> getContentByChannelId(String channelId){
		List<ContentData> data =  contactQuery.getContentByChannelId(channelId);
		System.out.println(JSONUtil.toJson("Data "+JSONUtil.toJson(data)));
		return contactRepository.findByChannelId(channelId);
	}
}
