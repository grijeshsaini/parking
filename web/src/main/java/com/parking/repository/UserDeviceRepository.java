package com.parking.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.parking.model.UserDevice;

@Repository
public interface UserDeviceRepository extends MongoRepository<UserDevice, String>{

	Optional<UserDevice> findUserDeviceById(String id);
}
