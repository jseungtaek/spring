package com.example.spring_mysql_connect.controller;

import com.example.spring_mysql_connect.dto.UserForm;
import com.example.spring_mysql_connect.entity.User;
import com.example.spring_mysql_connect.repository.UserJpaRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
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

    @GetMapping("auth/login")
    public String UserForm() {
        return "auth/login";
    }

    @PostMapping("/create")
    public String CreateUser (UserForm form) {

        User user = form.toEntity();

        User saveUser = userJpaRepository.save(user);
        return "user/login";
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
