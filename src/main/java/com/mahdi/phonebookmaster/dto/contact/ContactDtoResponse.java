package com.mahdi.phonebookmaster.dto.contact;

import com.mahdi.phonebookmaster.dto.BaseDto;
import com.mahdi.phonebookmaster.dto.user.UserDto;
import com.mahdi.phonebookmaster.dto.user.UserDtoList;
import com.mahdi.phonebookmaster.model.Contact;
import com.mahdi.phonebookmaster.model.User;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
public class ContactDtoResponse {

    Mono<Contact> userMono;
    Flux<Contact> userFlux;

    public ContactDtoResponse() {
    }

    public ContactDtoResponse(Mono<Contact> userMono) {
        this.userMono = userMono;
    }

    public ContactDtoResponse(Flux<Contact> userFlux) {
        this.userFlux = userFlux;
    }

    public Flux<ContactDtoList> getContactList() {
        Mono<List<Contact>> cache = userFlux.collectList().cache();
        cache.block().forEach(System.out::println);
        List<ContactDto> userDtoList = new ArrayList<>();
        for (Contact udto : cache.block()) {
            userDtoList.add(new ContactDto(udto));
        }
        ContactDtoList userDtoList1 = new ContactDtoList(userDtoList, "200", "Contact Is Found.");
        return Flux.just(userDtoList1);
    }

    public Flux<ContactDto> getContactListDto() {
        Mono<List<Contact>> cache = userFlux.collectList().cache();
        cache.block().forEach(System.out::println);

        List<ContactDto> userDtoList = new ArrayList<>();
        for (Contact u : cache.block()) {
            userDtoList.add(new ContactDto(u));
        }

//        return userDtoFlux.map(updatedTweet -> new ResponseEntity<>(updatedTweet, HttpStatus.OK));
        return Flux.<ContactDto>fromIterable(userDtoList);

    }

    public Mono<ResponseEntity<ContactDtoList>> getContactDto() {
        Contact block = this.userMono.block();
        ContactDto userDto = new ContactDto(block);
//        System.out.println(block);
        if (block != null) {
            Mono<ContactDtoList> userDtoMono = Mono.just(new ContactDtoList(Arrays.asList(userDto),"200","Contact is Found"));
            return userDtoMono.map(updatedTweet -> new ResponseEntity<>(updatedTweet, HttpStatus.OK));
        }
        return null;
    }

    public Mono<ResponseEntity<ContactDto>> getContactDtoNotFound() {

        ContactDto userDtoNotFound = new ContactDto();
//        userDtoNotFound.setMessage("Contact Is Not Found");
//        userDtoNotFound.setStatusCode("404");
        Mono<ContactDto> userDtoMono = Mono.just(userDtoNotFound);

        return userDtoMono.map(updatedTweet -> new ResponseEntity<>(updatedTweet, HttpStatus.NOT_FOUND));
    }

    public Mono<BaseDto> getBaseDto() {
        return Mono.just(new BaseDto("200", "true"));
    }


}
