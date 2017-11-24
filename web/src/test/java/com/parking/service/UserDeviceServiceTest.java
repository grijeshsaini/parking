package com.parking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.parking.dto.UserDeviceDetails;
import com.parking.model.UserDevice;
import com.parking.repository.UserDeviceRepository;
import com.parking.service.impl.UserDeviceServiceImpl;
import com.parking.utils.Util;

public class UserDeviceServiceTest {

	@Mock
	private UserDeviceRepository userDeviceRepository;
	
	private UserDeviceService userDeviceService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		userDeviceService = new UserDeviceServiceImpl(userDeviceRepository);
	}
	
	private UserDevice createUserDeviceObject() {
		List<String> deviceList = new ArrayList<String>();
		deviceList.add("A1234B");

		UserDevice userDeviceDetails = new UserDevice("abc.xyz", deviceList);
		return userDeviceDetails;
	}

	@Test
	@DisplayName("should save user device details")
	public void should_save_user_device_details() {
		when(userDeviceRepository.save(Matchers.any(UserDevice.class))).thenReturn(createUserDeviceObject());
		UserDevice userDevice = userDeviceService.saveUserDevice(Util.buildUserDeviceDetails(createUserDeviceObject()));
		assertSame(createUserDeviceObject().getId(), userDevice.getId());

	}
	
	@Test
	@DisplayName("should return User Device details when user id has been passed")
	public void should_return_user_device_details() {

		UserDevice userDevice = createUserDeviceObject();
		when(userDeviceRepository.findUserDeviceById(any())).thenReturn(Optional.of(userDevice));

		UserDeviceDetails userDeviceDetails = userDeviceService.getUserDeviceDetails("abc.xyz");

		assertNotNull(userDeviceDetails);
		assertEquals(userDevice.getId(), userDeviceDetails.getId());
		verify(userDeviceRepository, times(1)).findUserDeviceById(Matchers.eq("abc.xyz"));
	}
}
