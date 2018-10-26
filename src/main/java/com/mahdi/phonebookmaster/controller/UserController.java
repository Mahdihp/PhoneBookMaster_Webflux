package com.mahdi.phonebookmaster.controller;

import com.mahdi.phonebookmaster.constant.Constants;
import com.mahdi.phonebookmaster.model.User;
import com.mahdi.phonebookmaster.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/" + Constants.KEY_USER_CONTROLLER)
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/item/{id}")
    public Mono<ResponseEntity<User>> read(@PathVariable("id") String id) {
//        return userRepository.findUserByUserId(new ObjectId(id));
        return userRepository.findById(id)
                .map(savedTweet -> ResponseEntity.ok(savedTweet))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @GetMapping("/users")
    public Flux<User> readAll() {
        return userRepository.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody User user) {
        userRepository.save(user);
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<User>> update(@PathVariable(value = "id") String tweetId,@Valid @RequestBody User user) {
//        userRepository.save(user);
        return userRepository.findById(tweetId)
                .flatMap(existingTweet -> {
                    return userRepository.save(existingTweet);
                })
                .map(updateTweet -> new ResponseEntity<>(updateTweet, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("id") String id){
//        userRepository.removeByUserId(new ObjectId(id));
        return userRepository.findById(id)
                .flatMap(existingTweet ->
                        userRepository.delete(existingTweet)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
