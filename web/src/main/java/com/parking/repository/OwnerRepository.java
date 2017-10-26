package com.parking.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.parking.model.Parking;

@Repository
public interface OwnerRepository extends MongoRepository<Parking, String> {

	@Query(value="{'vehicles.reg' : ?0}", fields="{person : 1}")
    Optional<Parking> findPersonByRegNo(String vehicleNo);
}
