package com.parking.controller;


import com.parking.dto.Owner;
import com.parking.dto.OwnerBuilder;
import com.parking.service.ParkingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

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
    @DisplayName("Should return Skype-Id")
    public void should_return_skype_id() {
        Owner ownerDetails = new OwnerBuilder().setId("1").setName("Test").createOwner();
        when(parkingService.getOwnerDetails(any())).thenReturn(ownerDetails);

        ResponseEntity<Owner> details = parkingController.getOwnerDetails("ABCD1234");

        Assertions.assertEquals(200, details.getStatusCodeValue());
        Assertions.assertSame(ownerDetails, details.getBody());
    }

}
