package com.mahdi.phonebookmaster.dto.contact;

import com.mahdi.phonebookmaster.model.Contact;
import lombok.Data;

@Data
public class ContactDto {


    private String contactId;
    private String firstName;
    private String lastName;
    private String homePhone;
    private String mobile;
    private String email;

    public ContactDto() {
    }


    public ContactDto(Contact contact) {
        this.contactId = contact.getContactId().toString();
        this.firstName = contact.getFirstName();
        this.lastName = contact.getLastName();
        this.homePhone = contact.getHomePhone();
        this.mobile = contact.getMobile();
        this.email = contact.getEmail();

    }

    public ContactDto(String contactId, String firstName, String lastName, String homePhone, String mobile, String email) {
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.homePhone = homePhone;
        this.mobile = mobile;
        this.email = email;
    }

}
