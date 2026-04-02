package com.example.lab2.controller;


import com.example.lab2.model.User;
import com.example.lab2.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/email")
    public Optional<User> findByEmail(@RequestParam String email){
        return userService.findByEmail(email);
    }

    @GetMapping("/phone")
    public Optional<User> findByPhoneNumber(@RequestParam String phoneNumber){
        return userService.findByPhoneNumber(phoneNumber);
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
