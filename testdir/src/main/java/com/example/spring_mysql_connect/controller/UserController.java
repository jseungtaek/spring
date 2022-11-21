package com.example.spring_mysql_connect.controller;

import com.example.spring_mysql_connect.dto.UserForm;
import com.example.spring_mysql_connect.entity.User;
import com.example.spring_mysql_connect.repository.UserJpaRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/api/v1/user")
public class UserController {

//    field injection
    @Autowired
    private UserJpaRepository userJpaRepository;
//    constructor Based DI
//    private final UserJpaRepository userJpaRepository;
//
//    public UserController(UserJpaRepository userJpaRepository) {
//        this.userJpaRepository = userJpaRepository;
//    }

//    @GetMapping("")
//    public String all() {
//        Gson gson = new Gson(); //arrayList to Json
//        return gson.toJson(userJpaRepository.findAll());
//    }

    @GetMapping("auth")
    public String loginPage() {
        return "auth/login";
    }
    @PostMapping("/auth/loginCheck")
    public String UserForm (UserForm form) {
        User user = form.toEntity();
        System.out.println(user.username);
        System.out.println(user.password);
        System.out.println(user.toString());
        Boolean compareUser = userJpaRepository.equals(user); //id 값이 불일치
        System.out.println(compareUser);
        if(compareUser)
            return "auth/login";
        else
            return "auth/register";
    }

    @GetMapping("auth/register")
    public String registerPage() {
        return "auth/register";
    }

    @PostMapping("/auth/create")
    public String CreateUser (UserForm form) {

        User user = form.toEntity();
        System.out.println(user.toString());
        User saveUser = userJpaRepository.save(user);
        System.out.println(saveUser.toString());
        return "auth/register";
    }


    @GetMapping("/{id}")
    Optional<User> findOne(@PathVariable Long id) {
        System.out.println("find!");
        return userJpaRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        userJpaRepository.deleteById(id);
        System.out.println("delete!");
    }

}
