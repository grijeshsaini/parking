package com.parking.service;

import com.parking.dto.CarOwners;
import com.parking.dto.ParkingDetails;
import com.parking.model.Parking;

public interface ParkingService {

    ParkingDetails getOwnerDetails(String vehicleRegNo);
    
    ParkingDetails getParkingDetails(String parkingId);

    CarOwners getCarOwners();
    
    Parking saveParking(ParkingDetails parkingDetails);
    
    void deleteParking(String parkingId);
    
    void deleteParkingByVehicleRegNo(String vehicleNo);
}
