package com.parking.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.parking.model.Parking;

@Repository
public interface OwnerRepository extends MongoRepository<Parking, String> {

	@Query(value="{}", fields="{person : 1, vehicles: 0 }")
    Optional<Parking> findPersonExcludeVehicles(String vehicleNo);
}
