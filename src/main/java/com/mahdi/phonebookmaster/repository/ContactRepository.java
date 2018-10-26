package com.mahdi.phonebookmaster.repository;

import com.mahdi.phonebookmaster.model.Contact;
import com.mahdi.phonebookmaster.model.Privilege;
import com.mahdi.phonebookmaster.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ContactRepository extends ReactiveMongoRepository<Contact, String> {

    Mono<Contact> findContactByContactId(String username);
    Mono<Contact> findContactByFirstName(String username);
    Mono<Contact> findContactByLastName(String username);
    Mono<Contact> findContactByMobile(String username);


}
