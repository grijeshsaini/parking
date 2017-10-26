package com.parking.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.parking.dto.CarOwners;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import com.parking.dto.ParkingDetails;
import com.parking.dto.PersonDetails;
import com.parking.dto.VehicleDetails;
import com.parking.exceptions.DataNotFoundException;
import com.parking.service.ParkingService;

public class ParkingControllerTest {

	@Mock
	private ParkingService parkingService;

	private ParkingController parkingController;

	@BeforeEach
	public void setup() {
		initMocks(this);
		parkingController = new ParkingController(parkingService);
	}

	@Test
	@DisplayName("Should return Person details")
	public void should_return_person_details() {
		ParkingDetails parkingDetails = createParkingObject();
		when(parkingService.getOwnerDetails(any())).thenReturn(parkingDetails.getPerson());

		ResponseEntity<PersonDetails> details = parkingController.getOwnerDetails("ABCD1234");

		assertEquals(200, details.getStatusCodeValue());
		assertSame(parkingDetails.getPerson(), details.getBody());
	}

	@Test
	@DisplayName("should return no data found message")
	public void should_return_error_message() {
		when(parkingService.getOwnerDetails((any()))).thenThrow(new DataNotFoundException("Data not found"));
		when(parkingService.getParkingDetails((any()))).thenThrow(new DataNotFoundException("Data not found"));

		assertThrows(DataNotFoundException.class, () -> parkingController.getOwnerDetails("1234"));

		assertThrows(DataNotFoundException.class, () -> parkingController.getParkingDetails("1234"));
	}

	@Test
	@DisplayName("should return parking details")
	public void should_return_parking_details() {
		ParkingDetails parkingDetails = createParkingObject();
		when(parkingService.getParkingDetails(any())).thenReturn(parkingDetails);

		ResponseEntity<ParkingDetails> details = parkingController.getParkingDetails("ABCD1234");

		assertEquals(200, details.getStatusCodeValue());
		assertSame(parkingDetails, details.getBody());

	}

	@Test
	@DisplayName("should return all user details")
	public void should_return_all_user_and_vehicleDetails(){
		CarOwners carOwners = new CarOwners(Collections.singletonList(new ParkingDetails("id",
				new PersonDetails.Builder().name("asdas").build(),
				Collections.emptyList())));
		when(parkingService.getCarOwners()).thenReturn(carOwners);

		ResponseEntity<CarOwners> response = parkingController.getCarOwners();

		assertEquals(200, response.getStatusCodeValue());
		assertSame(carOwners, response.getBody());
	}

	private ParkingDetails createParkingObject() {
		List<VehicleDetails> vehicleList = new ArrayList<>();
		vehicleList.add(new VehicleDetails.Builder().color("blue").make("audi").regNo("12345").build());

		return new ParkingDetails("123", new PersonDetails.Builder().name("Test").emailAddress("test@abc.com").build(),
				vehicleList);
	}

}
