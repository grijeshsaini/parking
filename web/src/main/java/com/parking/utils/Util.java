package com.parking.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.parking.dto.PersonDetails;
import com.parking.dto.VehicleDetails;
import com.parking.model.Parking;

public class Util {

	public static PersonDetails buildPersonDetails(Parking details) {
		return new PersonDetails.Builder().name(details.getPerson().getName())
				.building(details.getPerson().getBuilding()).emailAddress(details.getPerson().getEmailAddress())
				.floor(details.getPerson().getFloor()).mobileNumber(details.getPerson().getMobileNumber())
				.seat(details.getPerson().getSeat()).workNumber(details.getPerson().getWorkNumber()).build();
	}

	public static List<VehicleDetails> buildVehicleDetails(Parking parking) {
		return parking.getVehicles().stream()
				.map(vehicle -> new VehicleDetails.Builder().color(vehicle.getColor()).make(vehicle.getMake())
						.model(vehicle.getModel()).regNo(vehicle.getreg()).type(vehicle.getType()).color(vehicle.getColor()).build())
				.collect(Collectors.toList());

	}

}
