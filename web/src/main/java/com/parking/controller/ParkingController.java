package com.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.parking.dto.ParkingDetails;
import com.parking.dto.PersonDetails;
import com.parking.service.ParkingService;

@RestController
public class ParkingController {

	private ParkingService parkingService;

	@Autowired
	public ParkingController(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@GetMapping("/owner/{vehicleNo}")
	public ResponseEntity<PersonDetails> getOwnerDetails(@PathVariable String vehicleNo) {
		PersonDetails owner = parkingService.getOwnerDetails(vehicleNo);
		return ResponseEntity.ok(owner);
	}
	
	@GetMapping("/parking/{parkingId}")
	public ResponseEntity<ParkingDetails> getParkingDetails(@PathVariable String parkingId) {
		ParkingDetails parking = parkingService.getParkingDetails(parkingId);
		return ResponseEntity.ok(parking);
	}
}
