package com.mahdi.phonebookmaster.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Document(collection = "roles")
public class Role {

    @JsonIgnore
    @Id
    private ObjectId roleId;
    private String longRoleId;
    private List<Privilege> privileges;
    private String name;

    public Role() {
    }

    public Role(ObjectId roleId, List<Privilege> privileges, String name) {
        this.roleId = roleId;
        this.longRoleId = roleId.toString();
        this.privileges = privileges;
        this.name = name;
    }

    public Role(List<Privilege> privileges, String name) {
        this.privileges = privileges;
        this.name = name;
    }

    public String getLongRoleId() {
        return roleId.toString();
    }

    public void setLongRoleId(String longRoleId) {
        this.roleId = new ObjectId(longRoleId);
    }
}
