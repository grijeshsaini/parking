package com.parking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.parking.exceptions.DataNotFoundException;
import com.parking.model.Parking;
import com.parking.model.Person;
import com.parking.repository.OwnerRepository;
import com.parking.service.impl.ParkingServiceImpl;

class ParkingServiceTest {

	@Mock
	private OwnerRepository ownerRepository;

	private ParkingService parkingService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		parkingService = new ParkingServiceImpl(ownerRepository);
	}

	@Test
	@DisplayName("should return Owner details when vehicle no has been passed")
	public void should_return_owner_details() {
		String vehicleRegNo = "ABCDE1234";
		Person ownerDetails = new Person.Builder().name("Test").mobileNumber("12345678").emailAddress("test@abc.com")
				.building("9c").seat("").workNumber("77").build();
		Parking parking = new Parking("1", ownerDetails, null);
		when(ownerRepository.findPersonExcludeVehicles(any())).thenReturn(Optional.of(parking));

		com.parking.dto.PersonDetails owner = parkingService.getOwnerDetails(vehicleRegNo);

		assertNotNull(parking);
		assertEquals(ownerDetails.getName(), owner.getName());
		assertEquals(ownerDetails,parking.getPerson());
		verify(ownerRepository, times(1)).findPersonExcludeVehicles(Matchers.eq(vehicleRegNo));
	}

	@Test
	@DisplayName("should throw data not found exception when data not found")
	public void should_return_empty_Details() {
		String vehicleRegNpo = "ABCDE1234";
		when(ownerRepository.findPersonExcludeVehicles(any())).thenReturn(Optional.empty());

		assertThrows(DataNotFoundException.class, () -> parkingService.getOwnerDetails(vehicleRegNpo));
	}

}