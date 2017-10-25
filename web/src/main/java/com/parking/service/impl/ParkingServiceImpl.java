package com.parking.service.impl;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dto.ParkingDetails;
import com.parking.dto.PersonDetails;
import com.parking.exceptions.DataNotFoundException;
import com.parking.model.Parking;
import com.parking.repository.OwnerRepository;
import com.parking.repository.ParkingRepository;
import com.parking.service.ParkingService;
import com.parking.utils.Util;

@Service
public class ParkingServiceImpl implements ParkingService {

	private OwnerRepository ownerRepository;
	private ParkingRepository parkingRepository;
	private Function<Parking, ParkingDetails> function = (parking) -> {
		return new ParkingDetails(parking.getId(), Util.buildPersonDetails(parking), Util.buildVehicleDetails(parking));
	};

	@Autowired
	public ParkingServiceImpl(OwnerRepository ownerRepository, ParkingRepository parkingRepository) {
		this.ownerRepository = ownerRepository;
		this.parkingRepository = parkingRepository;
	}

	@Override
	public PersonDetails getOwnerDetails(final String vehicleRegNo) {
		Optional<Parking> parkingDetailsOptional = ownerRepository.findPersonExcludeVehicles(vehicleRegNo);

		return parkingDetailsOptional.map(details -> Util.buildPersonDetails(details))
				.orElseThrow(() -> new DataNotFoundException("Data not available for id" + vehicleRegNo));
	}

	@Override
	public ParkingDetails getParkingDetails(String parkingId) {
		Optional<Parking> parkingDetailsOptional = parkingRepository.findParking(parkingId);

		return parkingDetailsOptional.map(function)
				.orElseThrow(() -> new DataNotFoundException("Data not available for id" + parkingId));
	}
}
