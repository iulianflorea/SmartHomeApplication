package com.example.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndController {

    @GetMapping
    public String getFrontEndController(Model model) {
        model.addAttribute("something", "This is from Controller");
        return "frontend";
    }


}
