package com.accolite.car.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.car.service.ParkingService;

@RestController
@RequestMapping("/parking")
public class ParkingController {
    
    @Autowired
    private ParkingService parkingService;

    @PostMapping("/allocate")
    public ResponseEntity<String> allocateParking() {
        String response = parkingService.allocateParking();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/release/{carId}")
    public ResponseEntity<Double> releaseParking(@PathVariable Long carId) {
        double amount = parkingService.releaseParking(carId);
        return ResponseEntity.ok(amount);
    }

  
}