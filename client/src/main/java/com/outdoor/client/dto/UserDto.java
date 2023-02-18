package com.outdoor.client.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class UserDto {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String image;
    private String role;
}
