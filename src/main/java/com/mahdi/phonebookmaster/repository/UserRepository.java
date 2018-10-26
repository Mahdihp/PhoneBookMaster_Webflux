package com.mahdi.phonebookmaster.repository;

import com.mahdi.phonebookmaster.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository  extends ReactiveMongoRepository<User, String> {

    Mono<User> findByUsername(String username);
    Mono<User> findUserByUsername(String username);

}
