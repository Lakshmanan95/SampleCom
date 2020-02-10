package com.cloubiot.buddyWAPI.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.cloubiot.buddWAPI.model.content.ContentData;
import com.cloubiot.buddyWAPI.model.dbentity.Content;

@Repository
public class ContentQuery {

	@Autowired
	MongoTemplate mongoTemplate;
	 
	public List<Content> findAll(){
		return mongoTemplate.findAll(Content.class);
	}
	
	public List<ContentData> getContentByChannelId(String channelId){
		LookupOperation lookupOperation = LookupOperation.newLookup()
                .from("channel")
                .localField("channelId")
                .foreignField("_id")
                .as("channel");

		Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
		List<ContentData> content = mongoTemplate.aggregate(aggregation, "Content", ContentData.class).getMappedResults();
		return content;
	}
}
