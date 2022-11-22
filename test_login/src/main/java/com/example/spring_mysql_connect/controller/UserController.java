package com.example.spring_mysql_connect.controller;

import com.example.spring_mysql_connect.dto.UserForm;
import com.example.spring_mysql_connect.entity.User;
import com.example.spring_mysql_connect.repository.UserJpaRepository;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
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

    @GetMapping("/auth/login")
    public String loginPage() {
        return "auth/login";
    }
    @PostMapping("/auth/login")
    public String loginCheck() { return "auth/login"; }
//    @PostMapping("/auth/loginCheck")
//    public String UserForm (UserForm form) {
//        User user = form.toEntity();
//        System.out.println(user.username);
//        List<User> test = userJpaRepository.findByUsername(user.username);
//        log.info(test.toString());
//        Boolean compareUser = userJpaRepository.equals(test); //id 값이 불일치
//        log.info(compareUser.toString());
//        if(compareUser)
//            return "auth/login";
//        else
//            return "auth/register";
//    }

    @GetMapping("auth/register")
    public String registerPage() {
        return "auth/register";
    }

    @PostMapping("/auth/create")
    public String CreateUser (UserForm form) {

        User user = form.toEntity();
//        System.out.println(user.toString()); -> logging
        log.info(user.toString());
        User saveUser = userJpaRepository.save(user);
//        System.out.println(saveUser.toString());
        log.info(saveUser.toString());
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
