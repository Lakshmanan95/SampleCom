package com.cloubiot.buddyWAPI.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cloubiot.buddyWAPI.model.dbentity.Content;

public interface ContentRepository extends MongoRepository<Content, String>{

	List<Content> findByChannelId(String channelId);
}
