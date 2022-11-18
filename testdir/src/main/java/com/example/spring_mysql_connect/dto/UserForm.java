package com.example.spring_mysql_connect.dto;

import com.example.spring_mysql_connect.entity.User;

public class UserForm {

    private String username;
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
