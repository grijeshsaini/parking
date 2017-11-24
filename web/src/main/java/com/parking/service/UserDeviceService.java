package com.parking.service;

import com.parking.dto.UserDeviceDetails;
import com.parking.model.UserDevice;

public interface UserDeviceService {

	UserDevice saveUserDevice(UserDeviceDetails userDeviceDetails);

	UserDeviceDetails getUserDeviceDetails(String id);
}
