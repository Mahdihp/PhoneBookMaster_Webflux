package com.mahdi.phonebookmaster.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Data
@Document(collection = "privileges")
public class Privilege {

    @Id
    private ObjectId privilegeId;
    private String name;
    private List<Role> roles;

    public Privilege() {
    }

    public Privilege(ObjectId privilegeId, String name, List<Role> roles) {
        this.privilegeId = privilegeId;
        this.name = name;
        this.roles = roles;
    }

    public Privilege(String name) {
        this.name = name;
    }
}
