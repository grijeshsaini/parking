package com.parking.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dto.PersonDetails;
import com.parking.exceptions.DataNotFoundException;
import com.parking.model.Parking;
import com.parking.repository.OwnerRepository;
import com.parking.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {

	private OwnerRepository ownerRepository;

	@Autowired
	public ParkingServiceImpl(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public PersonDetails getOwnerDetails(final String vehicleRegNo) {
		Optional<Parking> parkingDetailsOptional = ownerRepository.findPersonExcludeVehicles(vehicleRegNo);

		return parkingDetailsOptional
				.map(details -> new PersonDetails.Builder().name(details.getPerson().getName())
						.building(details.getPerson().getBuilding()).emailAddress(details.getPerson().getEmailAddress())
						.floor(details.getPerson().getFloor()).mobileNumber(details.getPerson().getMobileNumber())
						.seat(details.getPerson().getSeat()).workNumber(details.getPerson().getWorkNumber()).build())
				.orElseThrow(() -> new DataNotFoundException("Data not available for id" + vehicleRegNo));
	}
}
