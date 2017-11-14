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
		if (null != vehicles) {
			return vehicles.stream()
					.map(vehicle -> new VehicleDetails.Builder().colour(vehicle.getColour()).make(vehicle.getMake())
							.model(vehicle.getModel()).regNo(vehicle.getreg()).type(vehicle.getType()).build())
					.collect(Collectors.toList());
		}
		return null;
	}

	public static List<Vehicle> buildVehicles(List<VehicleDetails> vehicleDetails) {
		if (null != vehicleDetails) {
			return vehicleDetails.stream()
					.map(vehicleDetail -> new Vehicle.Builder().colour(vehicleDetail.getColour())
							.model(vehicleDetail.getModel()).reg(vehicleDetail.getRegNo()).type(vehicleDetail.getType())
							.make(vehicleDetail.getMake()).build())
					.collect(Collectors.toList());
		}
		return null;
	}
	
	public static Parking buildParking(ParkingDetails parkingDetails){
		return new Parking.Builder().id(parkingDetails.getId()).name(parkingDetails.getName()).building(parkingDetails.getBuilding())
				.emailAddress(parkingDetails.getEmailAddress()).floor(parkingDetails.getFloor())
				.mobileNumber(parkingDetails.getMobileNumber()).seat(parkingDetails.getSeat()).workNumber(parkingDetails.getWorkNumber())
				.vehicles(Util.buildVehicles(parkingDetails.getVehicles())).build();
	}

}
