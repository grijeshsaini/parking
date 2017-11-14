package com.parking.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dto.CarOwners;
import com.parking.dto.ParkingDetails;
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

	@Autowired
	public ParkingServiceImpl(OwnerRepository ownerRepository, ParkingRepository parkingRepository) {
		this.ownerRepository = ownerRepository;
		this.parkingRepository = parkingRepository;
	}

	@Override
	public ParkingDetails getOwnerDetails(final String vehicleRegNo) {
		Optional<Parking> parkingDetailsOptional = ownerRepository.findPersonByRegNo(vehicleRegNo);

		return parkingDetailsOptional.map(Util::buildParkingDetails)
				.orElseThrow(() -> new DataNotFoundException("Data not available for id" + vehicleRegNo));
	}

	@Override
	public ParkingDetails getParkingDetails(String parkingId) {
		Optional<Parking> parkingDetailsOptional = parkingRepository.findParkingById(parkingId);

		return parkingDetailsOptional.map(Util::buildParkingDetails)
				.orElseThrow(() -> new DataNotFoundException("Data not available for id" + parkingId));
	}

	@Override
	public CarOwners getCarOwners() {
		List<ParkingDetails> collect = parkingRepository.findAll().stream()
				.map(Util::buildParkingDetails)
				.collect(Collectors.toList());
		return new CarOwners(collect);
	}

	@Override
	public Parking saveParking(ParkingDetails parkingDetails) {
		return parkingRepository.save(Util.buildParking(parkingDetails));
		
	}

	@Override
	public void deleteParking(String parkingId) {
		parkingRepository.delete(parkingId);
	}

	@Override
	public void deleteParkingByVehicleRegNo(String vehicleNo) {
		parkingRepository.deleteParkingByRegNo(vehicleNo);
	}
}
