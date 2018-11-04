package com.mahdi.phonebookmaster.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @Id
    private ObjectId privilegeId;
    private String name;
//    private String longRoleId;

    //    @JsonIgnore
//    private List<Role> roles;


    public Privilege() {
    }

    public Privilege(ObjectId privilegeId, String name) {
        this.privilegeId = privilegeId;
//        this.longRoleId = privilegeId.toString();
        this.name = name;
//        this.roles = roles;
    }

    public Privilege(String name) {
        this.name = name;
    }

//    public String getLongRoleId() {
//        return privilegeId.toString();
//    }
//
//    public void setLongRoleId(String longRoleId) {
//        this.privilegeId = new ObjectId(longRoleId);
//    }
}
