package com.outdoor.client;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
=======
>>>>>>> ae0533eb34d705c91c38186ac3a9e9f1e9eed94a
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
<<<<<<< HEAD
@EnableDiscoveryClient
public class ClientApplication {
=======
public class ClientApplication {

>>>>>>> ae0533eb34d705c91c38186ac3a9e9f1e9eed94a
    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
<<<<<<< HEAD
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }
=======

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }




>>>>>>> ae0533eb34d705c91c38186ac3a9e9f1e9eed94a
}
