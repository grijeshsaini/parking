package com.parking.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.dto.UserDeviceDetails;
import com.parking.exceptions.DataNotFoundException;
import com.parking.model.UserDevice;
import com.parking.repository.UserDeviceRepository;
import com.parking.service.UserDeviceService;
import com.parking.utils.Util;

@Service
public class UserDeviceServiceImpl implements UserDeviceService {

	private UserDeviceRepository userDeviceRepository;
	
	
	@Autowired
	public UserDeviceServiceImpl(UserDeviceRepository userDeviceRepository) {
		this.userDeviceRepository = userDeviceRepository;
	}


	@Override
	public UserDevice saveUserDevice(UserDeviceDetails userDetails) {
		return userDeviceRepository.save(Util.buildUserDevice(userDetails));
	}

	@Override
	public UserDeviceDetails getUserDeviceDetails(String id) {
		Optional<UserDevice> userDeviceDetailsOptional = userDeviceRepository.findUserDeviceById(id);

		return userDeviceDetailsOptional.map(Util::buildUserDeviceDetails)
				.orElseThrow(() -> new DataNotFoundException("Data not available for id" + id));

	}

}
