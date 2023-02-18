package com.outddor.inventory.objects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Data
public class User {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String image;
    private String role;
}
