package com.parking.service.impl;

import com.parking.dto.Owner;
import com.parking.dto.OwnerBuilder;
import com.parking.exceptions.DataNotFoundException;
import com.parking.model.OwnerDetails;
import com.parking.repository.OwnerRepository;
import com.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParkingServiceImpl implements ParkingService {

    private OwnerRepository ownerRepository;

    @Autowired
    public ParkingServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner getOwnerDetails(final String vehicleRegNpo) {
        Optional<OwnerDetails> detailsOptional = ownerRepository.findOwnerDetailsByVehicleNo(vehicleRegNpo);

        return detailsOptional.map(details -> new OwnerBuilder().setId(details.getId()).setName(details.getOwnerName()).createOwner())
                .orElseThrow(() ->new DataNotFoundException("Data not available for id" + vehicleRegNpo));
    }
}
