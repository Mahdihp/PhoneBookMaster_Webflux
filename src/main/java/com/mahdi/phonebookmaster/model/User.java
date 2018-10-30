package com.mahdi.phonebookmaster.model;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document(collection = "users")
public class User {

    @Id
    private ObjectId userId;
    private String username;
    private String password;
    private String displayname;
    private Role role;

    public User() {
    }

    public User(ObjectId userId, String username, String password, String displayname, Role role) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.displayname = displayname;
        this.role = role;
    }

    public User(String username, String password, String displayname) {
        this.username = username;
        this.password = password;
        this.displayname = displayname;
    }

}
