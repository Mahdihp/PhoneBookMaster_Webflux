package com.mahdi.phonebookmaster.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class Role  {
    @Id
    private String id;

}
