package com.outdoor.product.objects;

import lombok.Data;

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
