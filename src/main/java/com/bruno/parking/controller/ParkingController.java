package com.bruno.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.parking.model.Parking;
import com.bruno.parking.repository.ParkingRepository;

@CrossOrigin
@RestController
@RequestMapping("/parking")
public class ParkingController {
	
	@Autowired
	private ParkingRepository parkings;
	
	@GetMapping
	public List<Parking> listar() {
		return this.parkings.findAll();
	}
	
}
