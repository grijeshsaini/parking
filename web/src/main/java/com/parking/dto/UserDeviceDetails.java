package com.parking.dto;

import java.util.List;

public class UserDeviceDetails {

	private String id;
	private List<String> deviceIds;
	
	public UserDeviceDetails(){
		
	}

	public UserDeviceDetails(String id, List<String> deviceIds) {
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
		return "UserDeviceDetails [id=" + id + ", deviceIds=" + deviceIds + "]";
	}

	
}
