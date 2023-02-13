package com.outdoor.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String id_user;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String image;

    private String role;
}
