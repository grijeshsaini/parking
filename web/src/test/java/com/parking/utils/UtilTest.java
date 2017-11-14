package com.parking.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.parking.dto.ParkingDetails;
import com.parking.dto.VehicleDetails;
import com.parking.model.Parking;
import com.parking.model.Vehicle;

public class UtilTest {

	@Test
	@DisplayName("should return vehicle details object")
	public void should_return_vehicle_details() {
		List<Vehicle> vehicles = Collections
				.singletonList(new Vehicle.Builder().colour("blue").make("audi").reg("1234").build());

		List<VehicleDetails> vehicleDetails = Collections
				.singletonList(new VehicleDetails.Builder().colour("blue").make("audi").regNo("1234").build());

		assertEquals(vehicleDetails.get(0).getRegNo(), Util.buildVehicleDetails(vehicles).get(0).getRegNo());

	}

	@Test
	@DisplayName("should return null vehicle details object")
	public void should_return_null_vehicle_details() {
		List<Vehicle> vehicles = null;
		assertNull(Util.buildVehicleDetails(vehicles));
	}

	@Test
	@DisplayName("should return parking details object")
	public void should_return_parking_details() {
		List<Vehicle> vehicles = Collections
				.singletonList(new Vehicle.Builder().colour("blue").make("audi").reg("1234").build());
		Parking parking = new Parking.Builder().name("test").vehicles(vehicles).build();

		List<VehicleDetails> vehicleDetails = Collections
				.singletonList(new VehicleDetails.Builder().colour("blue").make("audi").regNo("1234").build());

		ParkingDetails parkingDetails = new ParkingDetails.Builder().name("test").vehicles(vehicleDetails).build();

		assertEquals(parkingDetails.getName(), Util.buildParkingDetails(parking).getName());
		assertEquals(parkingDetails.getVehicles().get(0).getColour(),
				Util.buildParkingDetails(parking).getVehicles().get(0).getColour());

	}

	@Test
	@DisplayName("should return null parking details object")
	public void should_return_null_parking_details() {
		List<Vehicle> parking = null;
		assertNull(Util.buildVehicleDetails(parking));
	}

	@Test
	@DisplayName("should return parking object")
	public void should_return_parking() {
		List<VehicleDetails> vehiclesDetails = Collections
				.singletonList(new VehicleDetails.Builder().colour("blue").make("audi").regNo("1234").build());
		ParkingDetails parkingDetails = new ParkingDetails.Builder().name("test").vehicles(vehiclesDetails).build();

		List<Vehicle> vehicle = Collections
				.singletonList(new Vehicle.Builder().colour("blue").make("audi").reg("1234").build());

		Parking parking = new Parking.Builder().name("test").vehicles(vehicle).build();

		assertEquals(parking.getName(), Util.buildParking(parkingDetails).getName());
		assertEquals(parking.getVehicles().get(0).getColour(),
				Util.buildParking(parkingDetails).getVehicles().get(0).getColour());

	}
}
