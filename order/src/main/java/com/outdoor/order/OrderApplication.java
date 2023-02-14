package com.outdoor.order;

<<<<<<< HEAD
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableDiscoveryClient
public class OrderApplication {
    @Bean
    public ModelMapper modelMapper () {
        return new ModelMapper();
    }
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApplication {
>>>>>>> ae0533eb34d705c91c38186ac3a9e9f1e9eed94a

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

<<<<<<< HEAD

=======
>>>>>>> ae0533eb34d705c91c38186ac3a9e9f1e9eed94a
}
