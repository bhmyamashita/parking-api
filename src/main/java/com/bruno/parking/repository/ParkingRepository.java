package com.bruno.parking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.parking.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
	
	Optional<Parking> findByCarOwnerAndDate (String carOwner, String date);
	
}
