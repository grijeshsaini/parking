package com.parking.controller;

import com.parking.dto.Owner;
import com.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {

    private ParkingService parkingService;

    @Autowired
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/owner/{vehicleNo}")
    public ResponseEntity<Owner> getOwnerDetails(@PathVariable String vehicleNo) {
        Owner owner = parkingService.getOwnerDetails(vehicleNo);
        return ResponseEntity.ok(owner);
    }
}
