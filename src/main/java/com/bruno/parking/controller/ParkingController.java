package com.bruno.parking.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bruno.parking.model.Parking;
import com.bruno.parking.repository.ParkingRepository;

@CrossOrigin
@RestController
@RequestMapping("/parking")
public class ParkingController {
	
	@Autowired
	private ParkingRepository parkings;
	
	@GetMapping
	public List<Parking> findAll() {
		List<Parking> parkingList = this.parkings.findAll();
		Collections.reverse(parkingList);
		return parkingList;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Parking> getParkingById(@PathVariable Long id) {
		final Parking parking = this.parkings.getOne(id);
		
		if (parking == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(parking);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Parking createParking(@Valid @RequestBody Parking parking) {
		
		final Optional<Parking> existentParking = this.parkings
				.findByCarOwnerAndDate(parking.getCarOwner(), parking.getDate());
		if (existentParking.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"This car owner already has a parking payer today!");
		}
		return this.parkings.save(parking);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateParking(@PathVariable Long id, 
			@Valid @RequestBody Parking parking) {
		Parking existent = this.parkings.getOne(id);
		if(existent == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(parking, existent, "id");
		existent = this.parkings.save(existent);
		return ResponseEntity.ok(existent);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Parking> remove(@PathVariable Long id) {
		final Parking parking = this.parkings.getOne(id);
		if (parking == null) {
			return ResponseEntity.notFound().build();
		}
		this.parkings.delete(parking);
		return ResponseEntity.ok(parking);
	}
	
}
