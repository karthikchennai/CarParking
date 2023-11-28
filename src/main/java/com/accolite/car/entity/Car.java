package com.accolite.car.entity;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Car {

	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private LocalDateTime arrivalTime;
	    private LocalDateTime departureTime;
	    
	    @Column(name = "parking_space_id")
	    private Long parkingSpaceId;
	    
		public Long getParkingSpaceId() {
			return parkingSpaceId;
		}
		public void setParkingSpaceId(Long parkingSpaceId) {
			this.parkingSpaceId = parkingSpaceId;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public LocalDateTime getArrivalTime() {
			return arrivalTime;
		}
		public void setArrivalTime(LocalDateTime arrivalTime) {
			this.arrivalTime = arrivalTime;
		}
		public LocalDateTime getDepartureTime() {
			return departureTime;
		}
		public void setDepartureTime(LocalDateTime departureTime) {
			this.departureTime = departureTime;
		}
	    
	    

		
		
}
