package com.example.apigateway.users;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserDetails loadUserByUsername(String email) {
        return null;
    }
}
