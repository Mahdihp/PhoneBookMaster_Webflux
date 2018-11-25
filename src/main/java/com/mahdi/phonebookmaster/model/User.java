package com.mahdi.phonebookmaster.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User  {


    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId userId;
    private String username;
    private String password;
    private String displayname;
    private List<String> roles = new ArrayList<String>();
    private final boolean enabled;
    private final Date lastPasswordResetDate;

    @JsonCreator(mode=JsonCreator.Mode.PROPERTIES)
    public User(ObjectId userId,
                String username,
                String password,
                String displayname,
                List<String> roles,
                boolean enabled,
                Date lastPasswordResetDate) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.displayname = displayname;
        this.roles = roles;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

}
