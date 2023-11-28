package com.accolite;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CarParkingSystem {

	public static void main(String[] args) {
		SpringApplication.run(CarParkingSystem.class, args);
	}

}
