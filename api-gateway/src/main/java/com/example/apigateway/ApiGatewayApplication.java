package com.example.apigateway;

import com.example.apigateway.security.config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder, SecurityConfig securityConfig) {
		return builder.routes()
				.route("client", r -> r.path("/api/v1/user/**").uri("lb://client"))
				.route("product", r -> r.path("/product/**").uri("lb://product"))
				.route("inventory", r -> r.path("/api/v1/inventory/**").uri("lb://inventory")).build();
	}

}
