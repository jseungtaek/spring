package com.example.spring_mysql_connect.controller;

import com.example.spring_mysql_connect.entity.User;
import com.example.spring_mysql_connect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public @ResponseBody String AddNewUser (@RequestParam String name, @RequestParam String pw){

        User new_user = new User(null, name, pw);
        System.out.println(new_user.toString());
        userRepository.save(new_user);
        return "saved!";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> GetAllUser() {
        System.out.println(userRepository.findAll().toString());
        return userRepository.findAll();
    }
}
