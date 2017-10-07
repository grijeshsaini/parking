package com.parking.service;

import com.parking.dto.Owner;

public interface ParkingService {

    Owner getOwnerDetails(String vehicleRegNpo);
}
