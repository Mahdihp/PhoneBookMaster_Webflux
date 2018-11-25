package com.mahdi.phonebookmaster.dto.user;

import com.mahdi.phonebookmaster.dto.BaseDto;
import com.mahdi.phonebookmaster.model.User;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Data
public class UserDtoResponse {

    Mono<User> userMono;
    Flux<User> userFlux;

    public UserDtoResponse() {
    }

    public UserDtoResponse(Mono<User> userMono) {
        this.userMono = userMono;
    }

    public UserDtoResponse(Flux<User> userFlux) {
        this.userFlux = userFlux;
    }

//    public Mono<UserDtoList> getUsers(){
//        UserDtoList userDtoList=new UserDtoList();
//        List<User> dataList=new ArrayList<>();
//
//        return userFlux.map(p -> dataList.add(p))
//                .collect(Collectors.toList());
//    }
    public Mono<UserDtoList> getUserList() {
        Mono<List<User>> cache = userFlux.collectList().cache();
        cache.block().forEach(System.out::println);
        List<UserDto> userDtoList =new ArrayList<>();
        for (User udto: cache.block()){
            userDtoList.add(new UserDto(udto));
        }
        UserDtoList userDtoList1 = new UserDtoList( userDtoList,"200", "Users Is Found.");
        return Mono.just(userDtoList1);
    }

    public Flux<UserDto> getUserListDto() {
        Mono<List<User>> cache = userFlux.collectList().cache();
        cache.block().forEach(System.out::println);

        List<UserDto> userDtoList = new ArrayList<>();
        for (User u : cache.block()) {
            userDtoList.add(new UserDto(u));
        }

//        return userDtoFlux.map(updatedTweet -> new ResponseEntity<>(updatedTweet, HttpStatus.OK));
        return Flux.<UserDto>fromIterable(userDtoList);

    }

    public Mono<ResponseEntity<UserDtoList>> getUserDto() {
        User block = this.userMono.block();
        UserDto userDto = new UserDto(block);
//        System.out.println(block);
        if (block != null) {
//            userDto.setMessage("User is Found");
//            userDto.setStatusCode("200");
            Mono<UserDtoList> userDtoMono = Mono.just(new UserDtoList(Arrays.asList(userDto),"200","User is Found"));
            return userDtoMono.map(updatedTweet -> new ResponseEntity<>(updatedTweet, HttpStatus.OK));
        }
        return null;
    }

    public Mono<ResponseEntity<UserDto>> getUserDtoNotFound() {

        UserDto userDtoNotFound = new UserDto();
//        userDtoNotFound.setMessage("User Is Not Found");
//        userDtoNotFound.setStatusCode("404");
        Mono<UserDto> userDtoMono = Mono.just(userDtoNotFound);

        return userDtoMono.map(updatedTweet -> new ResponseEntity<>(updatedTweet, HttpStatus.NOT_FOUND));
    }

    public Mono<BaseDto> getBaseDto(){
        return Mono.just(new BaseDto("200","true"));
    }


}
