package com.parking.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userDeviceInfo")
public class UserDevice {

	@Id
	private String id;
	private List<String> deviceIds;

	public UserDevice(String id, List<String> deviceIds) {
		super();
		this.id = id;
		this.deviceIds = deviceIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getDeviceIds() {
		return deviceIds;
	}

	public void setDeviceIds(List<String> deviceIds) {
		this.deviceIds = deviceIds;
	}

	@Override
	public String toString() {
		return "UserDevice [id=" + id + ", deviceIds=" + deviceIds + "]";
	}

	
}
