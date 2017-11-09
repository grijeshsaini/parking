package com.parking.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.parking.dto.ParkingDetails;
import com.parking.dto.VehicleDetails;
import com.parking.model.Parking;
import com.parking.model.Vehicle;

public class Util {

	public static ParkingDetails buildParkingDetails(Parking details) {
		return new ParkingDetails.Builder().id(details.getId()).name(details.getName()).building(details.getBuilding())
				.emailAddress(details.getEmailAddress()).floor(details.getFloor())
				.mobileNumber(details.getMobileNumber()).seat(details.getSeat()).workNumber(details.getWorkNumber())
				.vehicles(Util.buildVehicleDetails(details.getVehicles())).build();
	}

	public static List<VehicleDetails> buildVehicleDetails(List<Vehicle> vehicles) {
		if (null!=vehicles) {
			return vehicles.stream()
					.map(vehicle -> new VehicleDetails.Builder().colour(vehicle.getColour()).make(vehicle.getMake())
							.model(vehicle.getModel()).regNo(vehicle.getreg()).type(vehicle.getType())
							.colour(vehicle.getColour()).build())
					.collect(Collectors.toList());
		}
		return null;
	}

}
