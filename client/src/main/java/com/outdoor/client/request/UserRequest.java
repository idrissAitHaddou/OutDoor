package com.outdoor.client.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "firstName is required")
    private String firstname;

    @NotBlank(message = "lastName is required")
    private String lastname;

    @Email
    @NotBlank(message = "email is required")
    private String email;

    @Size(min = 6, message = "password must be at least 6 characters")
    @NotBlank(message = "password is required")
    private String password;

    private String image;

    private String role;
}
