package com.parking.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.parking.dto.CarOwners;
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
	private Function<Parking, ParkingDetails> parkingDetailsConverter = (parking) -> new ParkingDetails(parking.getId(), Util.buildPersonDetails(parking), Util.buildVehicleDetails(parking));

	/*private Function<List<Parking>, List<ParkingDetails>> parkingDetails = (parkings) ->
			parkings.stream().map(parkingDetailsConverter);
	private Function<List<Parking>, CarOwners> ownerConverter = (parkings) -> new CarOwners(parkingDetailsConverter());
	*/@Autowired
	public ParkingServiceImpl(OwnerRepository ownerRepository, ParkingRepository parkingRepository) {
		this.ownerRepository = ownerRepository;
		this.parkingRepository = parkingRepository;
	}

	@Override
	public PersonDetails getOwnerDetails(final String vehicleRegNo) {
		Optional<Parking> parkingDetailsOptional = ownerRepository.findPersonByRegNo(vehicleRegNo);

		return parkingDetailsOptional.map(Util::buildPersonDetails)
				.orElseThrow(() -> new DataNotFoundException("Data not available for id" + vehicleRegNo));
	}

	@Override
	public ParkingDetails getParkingDetails(String parkingId) {
		Optional<Parking> parkingDetailsOptional = parkingRepository.findParkingById(parkingId);

		return parkingDetailsOptional.map(parkingDetailsConverter)
				.orElseThrow(() -> new DataNotFoundException("Data not available for id" + parkingId));
	}

	@Override
	public CarOwners getCarOwners() {
		List<ParkingDetails> collect = parkingRepository.findAll().stream()
				.map(parkingDetailsConverter)
				.collect(Collectors.toList());
		return new CarOwners(collect);
	}
}
