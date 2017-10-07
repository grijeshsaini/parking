package com.parking.repository;

import com.parking.model.OwnerDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends MongoRepository<OwnerDetails, String> {

    Optional<OwnerDetails> findOwnerDetailsByVehicleNo(String vehicleNo);
}
