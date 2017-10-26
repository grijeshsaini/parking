package com.parking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.parking.model.Parking;

@Repository
public interface ParkingRepository extends MongoRepository<Parking, String>{

	Optional<Parking> findParkingById(String parkingId);

	List<Parking> findAll();
}
