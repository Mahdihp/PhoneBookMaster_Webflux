package com.mahdi.phonebookmaster.dto.contact;

import com.mahdi.phonebookmaster.dto.BaseDto;
import lombok.Data;

import java.util.List;


@Data
public class ContactDtoList extends BaseDto {
    private List<ContactDto> dataList;

    public ContactDtoList() {
    }

    public ContactDtoList(List<ContactDto> dataList) {
        this.dataList = dataList;
    }

    public ContactDtoList( List<ContactDto> dataList,String statusCode, String message) {
        super(statusCode, message);
        this.dataList = dataList;
    }
}
