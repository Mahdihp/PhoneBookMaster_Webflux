package com.mahdi.phonebookmaster.repository;

import com.mahdi.phonebookmaster.model.Privilege;
import com.mahdi.phonebookmaster.model.Role;
import com.mahdi.phonebookmaster.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface PrivilegeRepository extends ReactiveMongoRepository<Privilege, String> {

//    Mono<User> findPrivilegeByName(String username);

}
