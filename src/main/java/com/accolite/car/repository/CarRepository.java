package com.accolite.car.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.car.entity.Car;



@Repository
public interface CarRepository  extends JpaRepository<Car, Long> {
	 Optional<Car> findById(Long id);
	 
	 Optional<Car> findByParkingSpaceId(Long parkingSpaceId);
}
