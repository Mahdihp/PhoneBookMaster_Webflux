package com.mahdi.phonebookmaster.controller;

import com.mahdi.phonebookmaster.constant.Constants;
import com.mahdi.phonebookmaster.dto.user.UserDto;
import com.mahdi.phonebookmaster.dto.user.UserDtoList;
import com.mahdi.phonebookmaster.dto.user.UserDtoResponse;
import com.mahdi.phonebookmaster.model.User;
import com.mahdi.phonebookmaster.repository.UserRepository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping(path = "/" + Constants.KEY_USER_CONTROLLER)
public class UserController {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/item/{id}")
    public Mono<ResponseEntity<UserDtoList>> read(@PathVariable("id") String userId) {
        logger.info("user id " + userId);
        return new UserDtoResponse(userRepository.
                findById(userId).cache()).getUserDto();

    }

    @GetMapping("/users")
    public Mono<UserDtoList> readAll() {
        return new UserDtoResponse(userRepository.findAll().cache()).getUserList();
    }

    @PostMapping("/create")
    public void create(@RequestBody User user) {
        System.out.println("create----------- "+user.toString());
        userRepository.save(user);
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<User>> update(@PathVariable("id") String userId, @RequestBody User user) {
//        System.out.println(userId);
//        System.out.println(user.toString());
        return userRepository.findById(userId)
                .flatMap(existingUser -> {
                    existingUser = user;
                    return userRepository.save(existingUser);
                })
                .map(updateTweet -> new ResponseEntity<>(updateTweet, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("id") String id) {
        return userRepository.findById(id)
                .flatMap(existingTweet ->
                        userRepository.delete(existingTweet)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
