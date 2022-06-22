package com.example.demo.controllers;

import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@Validated
public class UserController {
    private UserService  userService;

    public UserController(UserService userService){
        this.userService = userService;

    }

    @PostMapping("")
    public ResponseEntity<String> createUser(@RequestBody @Valid UserDTO userDTO) {
         User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        userService.createUser(user);
        return new ResponseEntity<>("Usuario creado en Mongo", HttpStatus.CREATED);
    }



}
