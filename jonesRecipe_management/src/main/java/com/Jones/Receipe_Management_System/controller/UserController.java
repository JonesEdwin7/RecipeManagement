package com.Jones.Receipe_Management_System.controller;

import com.Jones.Receipe_Management_System.dto.SignInInput;
import com.Jones.Receipe_Management_System.dto.SignInOutput;
import com.Jones.Receipe_Management_System.dto.SignUpInput;
import com.Jones.Receipe_Management_System.dto.SignUpOutput;
import com.Jones.Receipe_Management_System.model.User;
import com.Jones.Receipe_Management_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signIn")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

}
