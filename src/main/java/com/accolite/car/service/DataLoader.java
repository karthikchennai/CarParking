package com.accolite.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ParkingService parkingService;

    @Override
    public void run(String... args) {
    	parkingService.populateParkingSpaces();
    }
}