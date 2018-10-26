package com.mahdi.phonebookmaster.controller;

import com.mahdi.phonebookmaster.model.User;
import com.mahdi.phonebookmaster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
@RequestMapping(path = "/users", produces = { APPLICATION_JSON_UTF8_VALUE })
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/list")
    Flux<User> getAllUser() {
        return this.userRepository.findAll();
    }
}
