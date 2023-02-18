package com.example.apigateway;

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
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("client", r -> r.path("/api/v1/user/**").uri("lb://client"))
				.route("product", r -> r.path("/api/v1/product/**").uri("lb://product"))
				.route("order", r -> r.path("/api/v1/command/**").uri("lb://order"))
				.route("inventory", r -> r.path("/api/v1/inventory/**").uri("lb://inventory")
				).build();
	}

}
