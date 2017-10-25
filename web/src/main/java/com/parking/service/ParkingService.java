package com.parking.service;

import com.parking.dto.ParkingDetails;
import com.parking.dto.PersonDetails;

public interface ParkingService {

    PersonDetails getOwnerDetails(String vehicleRegNpo);
    
    ParkingDetails getParkingDetails(String parkingId);
}
