package com.outdoor.client.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    @Id
    private String id_user;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String image;
    private String role;
}
