package com.example.imgurapp.controller;

import com.example.imgurapp.model.User;
import com.example.imgurapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        String message = userService.registerUser(user);
        return ResponseEntity.ok(message);
    }
}