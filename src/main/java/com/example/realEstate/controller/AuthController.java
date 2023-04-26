package com.example.realEstate.controller;

import com.example.realEstate.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @GetMapping("login")
    User login(){
        return null;
    }

    @GetMapping("/signup")
    User signup(){
        return null;
    }


}
