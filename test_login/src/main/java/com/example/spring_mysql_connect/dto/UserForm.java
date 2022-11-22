package com.example.spring_mysql_connect.dto;

import com.example.spring_mysql_connect.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@AllArgsConstructor //constructor
//@NoArgsConstructor
//@ToString //tostring
public class UserForm {

    public String username;
    private String password;

    public UserForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User toEntity() {return new User(null, username, password);}
}

//lombok , AllArgsConstructor, ToString 사용시 form을 못 받아옴 이뉴는?
