package com.cloubiot.buddyWAPI.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cloubiot.buddyWAPI.common.CloubiotLogging;
import com.google.gson.JsonObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

@Service
@Repository
public class ChannelQuery {
	
	@Autowired
	private static Environment env;

	public static final MongoClient mongo = new MongoClient(env.getProperty("sp.spring.data.mongodb.host"), Integer.parseInt(env.getProperty("sp.spring.data.mongodb.port")));
	public static final DB db  = mongo.getDB(env.getProperty("sp.spring.data.mongodb.database"));
	public static final DBCollection collection =  db.getCollection("channel");
	
	public void addUpdateChannel(JsonObject channel) {
		try {
			DBObject dbObject = (DBObject) JSON.parse(channel.toString());
			collection.insert(dbObject);
		}
		catch(Exception e) {
			System.out.println(e);
			CloubiotLogging.logError(getClass(), "Add & Update Failed", e);
		}
	}
	
	public List<DBObject> getChannels() {
		List<DBObject> list = new ArrayList();
		try {
			DBCursor dbCursor = collection.find();
			while(dbCursor.hasNext()) {
				DBObject dbObject = dbCursor.next();
				list.add(dbObject);
			}
		}
		catch(Exception e) {
			System.out.println(e);
			CloubiotLogging.logError(getClass(), "Get Channels Failed", e);
		}
		return list;
	}
}
