package com.cloubiot.buddyWAPI.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.cloubiot.buddWAPI.model.content.ContentData;
import com.cloubiot.buddyWAPI.model.dbentity.Content;
import com.cloubiot.buddyWAPI.util.JSONUtil;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;

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
	
	public String addUpdateChannel(String jsonValue){
		String value = null;
		 MongoClient mongoClient = null;
		  try {
		   mongoClient = new MongoClient( "localhost" , 27017 );
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		DB db = mongoClient.getDB( "buddy" );
		 DBCollection json = db.getCollection("channel");
		  DBObject dbObject = (DBObject)JSON.parse(jsonValue);
		  json.insert(dbObject);
		return value;
	}
	
	public String getChannel(){
		String Channel = null;
		 MongoClient mongoClient = null;
		  try {
		   mongoClient = new MongoClient( "localhost" , 27017 );
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  DB db = mongoClient.getDB( "buddy" );
//		List<Document> value = (List<Document>) mongoTemplate.getCollection("channel");
//		System.out.println("Value "+value);
		  final List<Document> results = new ArrayList<>();
		  DBCollection collection = db.getCollection("channel");
		  DBCursor cursor = collection.find();
		  System.out.println(cursor);
		return Channel;
	}
}
