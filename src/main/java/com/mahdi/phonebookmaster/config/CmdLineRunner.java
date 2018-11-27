package com.mahdi.phonebookmaster.config;

import com.mahdi.phonebookmaster.model.Contact;
import com.mahdi.phonebookmaster.model.Privilege;
import com.mahdi.phonebookmaster.model.Role;
import com.mahdi.phonebookmaster.model.User;
import com.mahdi.phonebookmaster.repository.ContactRepository;
import com.mahdi.phonebookmaster.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Component
public class CmdLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final ContactRepository contactRepository;

    @Autowired
    public CmdLineRunner(UserRepository userRepository, ContactRepository contactRepository) {
        this.userRepository = userRepository;
        this.contactRepository = contactRepository;
    }


    @Override
    public void run(String... args) throws Exception {
//        initUser();
//        contactInit();
        System.out.println("Finished CmdLineRunner");
    }

    private void initUser() {
        Flux<User> people = Flux.just(
                new User(new ObjectId(), "ali", "110",
                        "Mahdi Hosseinpour")
        );

        this.userRepository.deleteAll().thenMany(userRepository.saveAll(people)).blockLast();
    }
    private void contactInit() {
        Flux<Contact> contactFlux = Flux.just(
                new Contact(new ObjectId(), "mahdi",
                        "hp",
                        "88477474",
                        "09339466943",
                        "mahdihp@gmail.com")
        );
        this.contactRepository.deleteAll()
                .thenMany(contactRepository.saveAll(contactFlux)).blockLast();
    }

}