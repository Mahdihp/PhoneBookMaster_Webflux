package com.mahdi.phonebookmaster.dto.user;

import lombok.Data;
import java.util.List;


@Data
public class UserDtoList {

    private String statusCode;
    private String message;
    private List<UserDto> dataList;

    public UserDtoList() {
    }

    public UserDtoList(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public UserDtoList(List<UserDto> dataList, String statusCode, String message) {
        this.dataList = dataList;
        this.statusCode = statusCode;
        this.message = message;
    }

}
