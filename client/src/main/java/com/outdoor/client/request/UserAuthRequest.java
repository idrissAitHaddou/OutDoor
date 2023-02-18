package com.outdoor.client.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthRequest {
    @Email
    @NotBlank(message = "email is required")
    private String email;

    @Size(min = 6, message = "password must be at least 6 characters")
    @NotBlank(message = "password is required")
    private String password;
}
