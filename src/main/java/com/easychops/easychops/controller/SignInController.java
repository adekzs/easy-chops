package com.easychops.easychops.controller;

import com.easychops.easychops.model.User;
import com.easychops.easychops.repo.UserRepository;
import com.easychops.easychops.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@AllArgsConstructor
public class SignInController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser =  userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }


    @GetMapping("/get")
    public String testGetRequest() {
        return "Hello";
    }

}
