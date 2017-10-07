package com.parking.service;

import com.parking.dto.Owner;
import com.parking.exceptions.DataNotFoundException;
import com.parking.model.OwnerDetails;
import com.parking.repository.OwnerRepository;
import com.parking.service.impl.ParkingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

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
        String vehicleRegNpo = "ABCDE1234";
        OwnerDetails ownerDetails = new OwnerDetails("1", "Test", vehicleRegNpo);
        when(ownerRepository.findOwnerDetailsByVehicleNo(any())).thenReturn(Optional.of(ownerDetails));

        Owner owner = parkingService.getOwnerDetails(vehicleRegNpo);

        assertNotNull(owner);
        assertEquals(ownerDetails.getOwnerName(), owner.getName());
        verify(ownerRepository, times(1)).findOwnerDetailsByVehicleNo(Matchers.eq(vehicleRegNpo));
    }

    @Test
    @DisplayName("should throw data not found exception when data not found")
    public void should_return_empty_Details(){
        String vehicleRegNpo = "ABCDE1234";
        when(ownerRepository.findOwnerDetailsByVehicleNo(any())).thenReturn(Optional.empty());

        assertThrows(DataNotFoundException.class, ()-> parkingService.getOwnerDetails(vehicleRegNpo));
    }

}