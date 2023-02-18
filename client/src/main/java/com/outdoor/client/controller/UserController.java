package com.outdoor.client.controller;

import com.outdoor.client.authentication.AuthenticationService;
import com.outdoor.client.dto.UserDto;
import com.outdoor.client.request.UserRequest;
import com.outdoor.client.response.UserResponse;
import com.outdoor.client.security.config.JwtUtil;
import com.outdoor.client.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final JwtUtil jwtUtil;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
    }

    @GetMapping("/get-by-email")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserByEmail(@RequestParam String email){
        return userService.loadUserByEmail(email);
    }

    @GetMapping("/load-by-email")
    @ResponseStatus(HttpStatus.OK)
    public UserDetails loadUserByEmail(@RequestParam String email){
        return userService.loadUserByUsername(email);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updateUser(@Valid @RequestBody UserRequest userRequest, @RequestParam String id){
        UserDto user = new UserDto();
        BeanUtils.copyProperties(userRequest, user);
        return userService.updateUser(id, user);
    }

    @GetMapping("/getUsers")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get-user-by-id")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUserById(@RequestParam String id){
        return userService.loadUserById(id);
    }

}
