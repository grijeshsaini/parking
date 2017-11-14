package com.parking.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.parking.dto.CarOwners;
import com.parking.dto.ParkingDetails;
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
		when(parkingService.getOwnerDetails(any())).thenReturn(parkingDetails);

		ResponseEntity<ParkingDetails> details = parkingController.getOwnerDetails("ABCD1234");

		assertEquals(200, details.getStatusCodeValue());
		assertSame(parkingDetails, details.getBody());
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
		CarOwners carOwners = new CarOwners(Collections.singletonList(new ParkingDetails.Builder().id("id").name("asdas").build()));
		when(parkingService.getCarOwners()).thenReturn(carOwners);

		ResponseEntity<CarOwners> response = parkingController.getCarOwners();

		assertEquals(200, response.getStatusCodeValue());
		assertSame(carOwners, response.getBody());
	}


	@Test
	@DisplayName("should return OK when vehicle number is valid")
	public void should_return_ok_when_vehicle_number_is_valid(){
		ParkingDetails parkingDetails = createParkingObject();
		when(parkingService.getOwnerDetails(any())).thenReturn(parkingDetails);

		ResponseEntity<String> details = parkingController.isVehicleNumberValid("ABCD1234");

		assertEquals(200, details.getStatusCodeValue());
	}

	private ParkingDetails createParkingObject() {
		List<VehicleDetails> vehicleList = new ArrayList<>();
		vehicleList.add(new VehicleDetails.Builder().colour("blue").make("audi").regNo("12345").build());

		return new ParkingDetails.Builder().name("Test").emailAddress("test@abc.com").vehicles(vehicleList).build();
	}
	
	@Test
	@DisplayName("should insert parking details")
	public void should_insert_parking_details(){
		ParkingDetails parkingDetails = createParkingObject();
		when(parkingService.saveParking(any())).thenReturn(any());
		ResponseEntity<HttpStatus> status = parkingController.saveParkingDetails(parkingDetails);
		
		assertEquals(200, status.getStatusCodeValue());
	}
	
	@Test
	@DisplayName("should delete parking details")
	public void should_delete_parking_details(){
		Mockito.doNothing().when(parkingService).deleteParking(any());
		ResponseEntity<HttpStatus> status = parkingController.deleteParkingDetails("123");
		
		verify(parkingService, times(1)).deleteParking(Matchers.eq("123"));
		assertEquals(200, status.getStatusCodeValue());
	}

}
