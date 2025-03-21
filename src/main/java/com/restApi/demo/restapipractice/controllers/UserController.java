package com.restApi.demo.restapipractice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.demo.restapipractice.entities.AppUser;
import com.restApi.demo.restapipractice.services.UserService;

import io.jsonwebtoken.security.InvalidKeyException;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser) {
        AppUser createdUser = userService.register(appUser);
        return ResponseEntity.ok().body(createdUser);
    }

    @PostMapping("/login")
    public String login(@RequestBody AppUser appUser) throws InvalidKeyException, NoSuchAlgorithmException {

        return userService.veryfy(appUser);
    }

}
