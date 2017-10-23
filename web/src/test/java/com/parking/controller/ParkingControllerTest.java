package com.parking.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import com.parking.dto.PersonDetails;
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
		PersonDetails ownerDetails = new PersonDetails.Builder().name("Test").mobileNumber("12345678").emailAddress("test@abc.com")
				.build();
		when(parkingService.getOwnerDetails(any())).thenReturn(ownerDetails);

		ResponseEntity<PersonDetails> details = parkingController.getOwnerDetails("ABCD1234");

		assertEquals(200, details.getStatusCodeValue());
		assertSame(ownerDetails, details.getBody());
	}
	
	@Test
	@DisplayName("should return no data found message")
	public void should_return_error_message() {
		when(parkingService.getOwnerDetails((any()))).thenThrow(new DataNotFoundException("Data not found"));
		
		 assertThrows(DataNotFoundException.class,
	            ()->{parkingController.getOwnerDetails("1234");} );
	}

}
