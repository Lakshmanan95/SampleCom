package com.cloubiot.buddyWAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BuddyWapiApplication extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BuddyWapiApplication.class);
    }

	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(BuddyWapiApplication.class, args);
	}

}
