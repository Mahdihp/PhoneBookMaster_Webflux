package com.mahdi.phonebookmaster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class PhoneBookMasterApplication  {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PhoneBookMasterApplication.class);
        app.setWebApplicationType(WebApplicationType.REACTIVE);
        app.run(args);

    }
}
