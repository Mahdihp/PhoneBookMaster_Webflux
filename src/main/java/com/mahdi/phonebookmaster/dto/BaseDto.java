package com.mahdi.phonebookmaster.dto;

import lombok.Data;

@Data
public class BaseDto {

    private String statusCode;
    private String message;


    public BaseDto() {
    }

    public BaseDto(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
