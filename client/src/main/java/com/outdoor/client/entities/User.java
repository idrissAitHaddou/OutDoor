package com.outdoor.client.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


<<<<<<< HEAD
@Document(collection = "users")
=======
@Document(collection = "user")
>>>>>>> ae0533eb34d705c91c38186ac3a9e9f1e9eed94a
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
<<<<<<< HEAD
=======
    



>>>>>>> ae0533eb34d705c91c38186ac3a9e9f1e9eed94a
}
