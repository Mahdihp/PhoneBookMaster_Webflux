package com.mahdi.phonebookmaster.dto;

import lombok.Data;

@Data
public class BaseDto {

    private String status;
    private String errorCode;
    private String message;


    public BaseDto() {
    }

    public BaseDto(String status, String errorCode, String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }
}
