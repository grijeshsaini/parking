package com.parking.service;

import com.parking.dto.CarOwners;
import com.parking.dto.ParkingDetails;

public interface ParkingService {

    ParkingDetails getOwnerDetails(String vehicleRegNo);
    
    ParkingDetails getParkingDetails(String parkingId);

    CarOwners getCarOwners();
}
