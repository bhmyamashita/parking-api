package com.bruno.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bruno.parking.model.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long> {

}
