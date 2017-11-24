package com.parking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.parking.dto.CarOwners;
import com.parking.dto.ParkingDetails;
import com.parking.exceptions.DataNotFoundException;
import com.parking.model.Parking;
import com.parking.model.Vehicle;
import com.parking.repository.OwnerRepository;
import com.parking.repository.ParkingRepository;
import com.parking.service.impl.ParkingServiceImpl;
import com.parking.utils.Util;

class ParkingServiceTest {

	@Mock
	private OwnerRepository ownerRepository;

	@Mock
	private ParkingRepository parkingRepository;

	private ParkingService parkingService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		parkingService = new ParkingServiceImpl(ownerRepository, parkingRepository);
	}

	@Test
	@DisplayName("should return Owner details when vehicle no has been passed")
	public void should_return_owner_details() {
		String vehicleRegNo = "ABCDE1234";
		Parking parking = createParkingObject();
		when(ownerRepository.findPersonByRegNo(any())).thenReturn(Optional.of(parking));

		ParkingDetails owner = parkingService.getOwnerDetails(vehicleRegNo);

		assertNotNull(parking);
		assertEquals(parking.getName(), owner.getName());
		assertEquals(parking, parking);
		verify(ownerRepository, times(1)).findPersonByRegNo(Matchers.eq(vehicleRegNo));
	}

	@Test
	@DisplayName("should throw data not found exception when owner records not found")
	public void should_return_empty_owner_details() {
		String vehicleRegNpo = "ABCDE1234";
		when(ownerRepository.findPersonByRegNo(any())).thenReturn(Optional.empty());

		assertThrows(DataNotFoundException.class, () -> parkingService.getOwnerDetails(vehicleRegNpo));
	}

	@Test
	@DisplayName("should return Parking details when parking id has been passed")
	public void should_return_parking_details() {
		String parkingId = "ABCDE1234";

		Parking parking = createParkingObject();
		when(parkingRepository.findParkingById(any())).thenReturn(Optional.of(parking));

		ParkingDetails parkingDetails = parkingService.getParkingDetails(parkingId);

		assertNotNull(parking);
		assertEquals(parking.getId(), parkingDetails.getId());
		assertEquals(parking.getName(), parkingDetails.getName());
		assertEquals(parking.getVehicles().get(0).getColour(), parkingDetails.getVehicles().get(0).getColour());
		verify(parkingRepository, times(1)).findParkingById(Matchers.eq(parkingId));
	}

	@Test
	@DisplayName("should throw data not found exception when parking record not found")
	public void should_return_empty_parking_details() {
		String parkingId = "ABCDE1234";
		when(parkingRepository.findParkingById(any())).thenReturn(Optional.empty());

		assertThrows(DataNotFoundException.class, () -> parkingService.getParkingDetails(parkingId));
	}

	@Test
	@DisplayName("should return all car owners")
	public void should_return_all_car_owners() {
		CarOwners carOwners = new CarOwners(
				Collections.singletonList(new ParkingDetails.Builder().id("id").name("Test").build()));
		when(parkingRepository.findAll()).thenReturn(Arrays.asList(createParkingObject(), createParkingObject()));
		CarOwners owners = parkingService.getCarOwners();

		assertSame(carOwners.getParkingDetails().get(0).getName(), owners.getParkingDetails().get(0).getName());

	}

	private Parking createParkingObject() {
		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleList.add(new Vehicle.Builder().colour("blue").make("audi").reg("12345").build());

		return new Parking.Builder().name("Test").mobileNumber("12345678").emailAddress("test@abc.com").building("9c")
				.seat("").workNumber("77").vehicles(vehicleList).build();
	}

	@Test
	@DisplayName("should save parking details")
	public void should_save_parking_details() {
		when(parkingRepository.save(Matchers.any(Parking.class))).thenReturn(createParkingObject());
		Parking parking = parkingService.saveParking(Util.buildParkingDetails(createParkingObject()));
		assertSame(createParkingObject().getName(), parking.getName());

	}

	@Test
	@DisplayName("should delete parking details")
	public void should_delete_parking_details() {
		Mockito.doNothing().when(parkingRepository).delete(Matchers.any(String.class));
		parkingService.deleteParking("123");
		verify(parkingRepository, times(1)).delete(Matchers.eq("123"));

	}
}