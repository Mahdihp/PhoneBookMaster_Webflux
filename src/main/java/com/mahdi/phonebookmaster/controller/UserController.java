package com.mahdi.phonebookmaster.controller;

import com.mahdi.phonebookmaster.constant.Constants;
import com.mahdi.phonebookmaster.model.User;
import com.mahdi.phonebookmaster.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(path = "/" + Constants.KEY_USER_CONTROLLER)
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public Flux<User> readAll() {
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody User user) {
        userRepository.save(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userRepository.save(user);
    }
}
