package com.mahdi.phonebookmaster.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
public class User  {


    @Id
    private ObjectId userId;
    private String username;
    private String password;
    private String displayname;

//    private List<String> roles = new ArrayList<String>();
//    private final boolean enabled;
//    private final Date lastPasswordResetDate;


    public User(ObjectId userId, String username, String password, String displayname) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.displayname = displayname;
    }
}
