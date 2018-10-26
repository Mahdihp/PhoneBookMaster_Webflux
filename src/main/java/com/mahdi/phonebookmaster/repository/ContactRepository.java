package com.mahdi.phonebookmaster.repository;

import com.mahdi.phonebookmaster.model.Contact;
import com.mahdi.phonebookmaster.model.Privilege;
import com.mahdi.phonebookmaster.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ContactRepository extends ReactiveMongoRepository<Contact, String> {

//    Mono<User> findContactByContactId(String username);
//    Mono<User> findContactByFirstName(String username);
//    Mono<User> findContactByLastName(String username);
//    Mono<User> findContactByMobile(String username);

}
