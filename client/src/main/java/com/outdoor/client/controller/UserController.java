package com.outdoor.client.controller;

import com.outdoor.client.entities.User;
import com.outdoor.client.request.UserRequest;
import com.outdoor.client.response.UserResponse;
import com.outdoor.client.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

//    create user
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
    }

//    get all users
    @GetMapping("/getUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

}
