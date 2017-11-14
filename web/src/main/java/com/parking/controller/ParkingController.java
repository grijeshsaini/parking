package com.parking.controller;

import com.parking.dto.CarOwners;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.dto.ParkingDetails;
import com.parking.service.ParkingService;

@RestController
@CrossOrigin("*")
public class ParkingController {

	private ParkingService parkingService;

	@Autowired
	public ParkingController(ParkingService parkingService) {
		this.parkingService = parkingService;
	}

	@GetMapping("/owner/{vehicleNo}")
	public ResponseEntity<ParkingDetails> getOwnerDetails(@PathVariable String vehicleNo) {
		ParkingDetails owner = parkingService.getOwnerDetails(vehicleNo);
		return ResponseEntity.ok(owner);
	}

	@GetMapping("/parking/{parkingId}")
	public ResponseEntity<ParkingDetails> getParkingDetails(@PathVariable String parkingId) {
		return ResponseEntity.ok(parkingService.getParkingDetails(parkingId));
	}

	@GetMapping("/parking/vehicle/{vehicleNo}")
	public ResponseEntity<String> isVehicleNumberValid(@PathVariable String vehicleNo){
		parkingService.getOwnerDetails(vehicleNo);
		return ResponseEntity.ok("OK");
	}

	@GetMapping("/parking")
	public ResponseEntity<CarOwners> getCarOwners() {
		return ResponseEntity.ok(parkingService.getCarOwners());
	}
	
	@PostMapping(path = "/parking", consumes = "application/json", produces = "application/json")
	public ResponseEntity<HttpStatus> saveParkingDetails(@RequestBody @Valid ParkingDetails parkingDetails){
		parkingService.saveParking(parkingDetails);
		return ResponseEntity.ok(HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(path = "/parking/{parkingId}")
	public ResponseEntity<HttpStatus> deleteParkingDetails(@PathVariable String parkingId){
		parkingService.deleteParking(parkingId);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/parking/vehicle/{vehicleNo}")
	public ResponseEntity<HttpStatus> deleteParkingDetailsByVehicleRegNo(@PathVariable String vehicleNo){
		parkingService.deleteParkingByVehicleRegNo(vehicleNo);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
