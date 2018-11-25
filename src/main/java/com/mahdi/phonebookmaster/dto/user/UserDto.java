package com.mahdi.phonebookmaster.dto.user;

import com.mahdi.phonebookmaster.dto.BaseDto;
import com.mahdi.phonebookmaster.model.Role;
import com.mahdi.phonebookmaster.model.User;
import lombok.Data;

import java.util.List;


@Data
public class UserDto {
    private String userId;
    private String username;
    private String password;
    private String displayname;
    private List<String> role;

    public UserDto() {
    }

    public UserDto(User user) {
        this.userId = user.getUserId().toString();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.displayname = user.getDisplayname();
        this.role = user.getRoles();
    }

//    public UserDto(String userId, String username, String password, String displayname, Role role) {
//        this.userId = userId;
//        this.username = username;
//        this.password = password;
//        this.displayname = displayname;
//        this.role = role;
//    }
}
