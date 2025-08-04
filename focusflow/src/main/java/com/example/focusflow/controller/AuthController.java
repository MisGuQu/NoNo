package com.example.focusflow.controller;

import com.example.focusflow.model.User;
import com.example.focusflow.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.save(user);
    }

    @GetMapping("/find/{username}")
    public Optional<User> findByUsername(@PathVariable String username) {
        return authService.findByUsername(username);
    }
}
