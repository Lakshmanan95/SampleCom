package com.cloubiot.buddyWAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
@ComponentScan(basePackages = "com.cloubiot.*")
public class ApplicationConfig {

	@Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        UserCredentials userCredentials = new UserCredentials("", "");
        return new SimpleMongoDbFactory(mongoClient, "buddy");
    }
 
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
}
