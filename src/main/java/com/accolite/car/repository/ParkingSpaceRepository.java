package com.accolite.car.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.car.entity.ParkingSpace;



@Repository
public interface ParkingSpaceRepository  extends JpaRepository<ParkingSpace, Long> {
	
	 Optional<ParkingSpace> findById(Long id);
	 List<ParkingSpace> findByAvailableTrue();
	 
	 
}
