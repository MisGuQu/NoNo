package com.example.focusflow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "index"; // Trả về dashboard.html
    }

    
}
