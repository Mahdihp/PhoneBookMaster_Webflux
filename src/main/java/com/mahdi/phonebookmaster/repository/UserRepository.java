package com.mahdi.phonebookmaster.repository;

import com.mahdi.phonebookmaster.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository  extends ReactiveMongoRepository<User, ObjectId> {

    Mono<User> findUserByUsernameAndPassword(String username,String password);
    Mono<User> findUserByUsername(String username);
    Mono<User> findUserByUserId(Long id);
    Mono<User> findUserByUserId(ObjectId objectId);
    void removeByUserId(ObjectId objectId);


}
