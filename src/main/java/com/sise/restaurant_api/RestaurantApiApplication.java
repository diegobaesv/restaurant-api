package com.sise.restaurant_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@SpringBootApplication
@ConfigurationProperties(prefix = "spring.mail")
public class RestaurantApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantApiApplication.class, args);
	}

}


// controllers (incluye rutas en cada metodo)
// services (interfaces y clases)
// repository (interfaces)
// models

// util
// security
// config