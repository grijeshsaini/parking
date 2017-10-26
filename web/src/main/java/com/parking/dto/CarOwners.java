package com.parking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CarOwners {

    @JsonProperty("carOwners")
    private List<ParkingDetails> parkingDetails;

    public CarOwners() {
    }

    public CarOwners(List<ParkingDetails> parkingDetails) {
        this.parkingDetails = parkingDetails;
    }

    public List<ParkingDetails> getParkingDetails() {
        return parkingDetails;
    }

    public void setParkingDetails(List<ParkingDetails> parkingDetails) {
        this.parkingDetails = parkingDetails;
    }
}
