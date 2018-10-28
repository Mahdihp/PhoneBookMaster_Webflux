package com.mahdi.phonebookmaster.controller;

import com.mahdi.phonebookmaster.constant.Constants;
import com.mahdi.phonebookmaster.dto.contact.ContactDtoList;
import com.mahdi.phonebookmaster.dto.contact.ContactDtoResponse;
import com.mahdi.phonebookmaster.model.Contact;
import com.mahdi.phonebookmaster.repository.ContactRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/" + Constants.KEY_CONTACT_CONTROLLER)
public class ContactController {

    Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private ContactRepository contactRepository;

    @Autowired
    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }



    @GetMapping("/item/{id}")
    public Mono<ResponseEntity<ContactDtoList>> read(@PathVariable("id") String userId) {
        logger.info("user id "+ userId);
        return new ContactDtoResponse(contactRepository.
                findById(userId).cache()).getContactDto();

    }

    @GetMapping("/contacts")
    public Flux<ContactDtoList> readAll() {
       return new ContactDtoResponse(contactRepository.findAll().cache()).getContactList();
    }

    @PostMapping("/create")
    public void create(@RequestBody Contact user) {
        contactRepository.save(user);
    }

    @PutMapping("/update/{id}")
    public Mono<ResponseEntity<Contact>> update(@PathVariable(value = "id") String contactId, @Valid @RequestBody Contact user) {
        return contactRepository.findById(contactId)
                .flatMap(existingUser -> {
                    existingUser = user;
                    return contactRepository.save(existingUser);
                })
                .map(updateTweet -> new ResponseEntity<>(updateTweet, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<Void>> delete(@PathVariable("id") String id) {
        return contactRepository.findById(id)
                .flatMap(existingTweet ->
                        contactRepository.delete(existingTweet)
                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
                )
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
