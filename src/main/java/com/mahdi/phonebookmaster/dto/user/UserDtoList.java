package com.mahdi.phonebookmaster.dto.user;

import com.mahdi.phonebookmaster.dto.BaseDto;
import lombok.Data;

import java.util.List;


@Data
public class UserDtoList extends BaseDto {


    private List<UserDto> dataList;

    public UserDtoList() {
    }

    public UserDtoList(List<UserDto> dataList) {
        this.dataList = dataList;
    }

    public UserDtoList(String status, String errorCode, String message, List<UserDto> dataList) {
        super(status, errorCode, message);
        this.dataList = dataList;
    }
}
