package com.mahdi.phonebookmaster.dto.user;

import com.mahdi.phonebookmaster.model.User;
import lombok.Data;
import org.bson.types.ObjectId;


@Data
public class UserDto {

    private String statusCode;
    private String message;

    private String userId;
    private String username;
    private String password;
    private String displayname;
    public UserDto() {
    }

    public UserDto(User user) {
        this.userId = user.getUserId().toString();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.displayname = user.getDisplayname();
    }
    public UserDto(User user,String statusCode, String message) {
        this.userId = user.getUserId().toString();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.displayname = user.getDisplayname();
        this.statusCode = statusCode;
        this.message = message;
    }

    public UserDto(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public UserDto(String userId, String username, String password, String displayname, String statusCode, String message) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.displayname = displayname;
        this.statusCode = statusCode;
        this.message = message;
    }
}
