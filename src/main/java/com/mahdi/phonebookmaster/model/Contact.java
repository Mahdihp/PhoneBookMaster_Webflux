package com.mahdi.phonebookmaster.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "contacts")
public class Contact {

    @Id
    private ObjectId contactId;

    @JsonIgnore
    @ToString.Exclude
    private User user;
    private String firstName;
    private String lastName;
    private String homePhone;
    private String mobile;
    private String email;

    public Contact() {
    }

    public Contact(User user, String firstName, String lastName, String homePhone, String mobile, String email) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.mobile = mobile;
        this.email = email;
    }

    public Contact(String firstName, String lastName, String homePhone, String mobile, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.mobile = mobile;
        this.email = email;
    }
}
