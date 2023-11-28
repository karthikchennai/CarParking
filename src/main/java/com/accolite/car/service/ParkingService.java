package com.accolite.car.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accolite.car.entity.Car;
import com.accolite.car.entity.ParkingSpace;
import com.accolite.car.repository.CarRepository;
import com.accolite.car.repository.ParkingSpaceRepository;

@Service
public class ParkingService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private ParkingSpaceRepository parkingSpaceRepository;

	@Transactional
	public String allocateParking() {
		List<ParkingSpace> availableSpaces = parkingSpaceRepository.findByAvailableTrue();
		if (!availableSpaces.isEmpty()) {
			ParkingSpace parkingSpace = availableSpaces.get(0);
			parkingSpace.setAvailable(false);
			parkingSpaceRepository.save(parkingSpace);

			Car car = new Car();
			car.setArrivalTime(LocalDateTime.now());
			car.setParkingSpaceId(parkingSpace.getId());
			// Set other car details if needed
			carRepository.save(car);

			return "Parking allocated. Space: " + parkingSpace.getId();
		} else {
			return "Car park is full";
		}
	}

	public double releaseParking(Long carId) {
		Optional<Car> optionalCar = carRepository.findById(carId);
		if (optionalCar.isPresent()) {
			Car car = optionalCar.get();

			Optional<ParkingSpace> optionalParkingSpace = parkingSpaceRepository.findById(car.getParkingSpaceId());
			if (optionalParkingSpace.isPresent()) {
				ParkingSpace parkingSpace = optionalParkingSpace.get();
				parkingSpace.setAvailable(true);
				parkingSpaceRepository.save(parkingSpace);
				Duration duration = Duration.between(car.getArrivalTime(), LocalDateTime.now());
				long milliSec = duration.toMillis();
				long hours = duration.toHours();
				if (milliSec > 0) {
					hours++; 
				}
				return hours * 2; // Charge £2 per hour
			} else {
				return 0; // Car not found
			}

		}
		return 0;
	}
	
	 public void populateParkingSpaces() {
	        for (int i = 1; i <= 100; i++) {
	            ParkingSpace parkingSpace = new ParkingSpace();
	            parkingSpace.setAvailable(true);
	            
	            parkingSpaceRepository.save(parkingSpace);
	        }
	    }
}
