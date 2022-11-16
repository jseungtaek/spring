package com.example.spring_test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @GetMapping("/hi")
    public String nice(Model model) {
        model.addAttribute("name", "seungtaek");
        return "greetings";
    }
}
