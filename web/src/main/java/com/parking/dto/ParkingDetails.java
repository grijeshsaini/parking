package com.parking.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ParkingDetails {

	@NotNull
	@Size(min=1, message="id should not be empty")
	private String id;
	private String name;
	private String mobileNumber;
	private String workNumber;
	private String emailAddress;
	private String building;
	private String floor;
	private String seat;
	private List<VehicleDetails> vehicles;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getBuilding() {
		return building;
	}

	public String getFloor() {
		return floor;
	}

	public String getSeat() {
		return seat;
	}

	public List<VehicleDetails> getVehicles() {
		return vehicles;
	}

	public ParkingDetails() {
	}

	public ParkingDetails(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.mobileNumber = builder.mobileNumber;
		this.workNumber = builder.workNumber;
		this.emailAddress = builder.emailAddress;
		this.building = builder.building;
		this.floor = builder.floor;
		this.seat = builder.seat;
		this.vehicles = builder.vehicles;
	}

	public static class Builder {

		private String id;
		private String name;
		private String mobileNumber;
		private String workNumber;
		private String emailAddress;
		private String building;
		private String floor;
		private String seat;

		private List<VehicleDetails> vehicles;

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder mobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}

		public Builder workNumber(String workNumber) {
			this.workNumber = workNumber;
			return this;
		}

		public Builder emailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
			return this;
		}

		public Builder building(String building) {
			this.building = building;
			return this;
		}

		public Builder floor(String floor) {
			this.floor = floor;
			return this;
		}

		public Builder seat(String seat) {
			this.seat = seat;
			return this;
		}

		public Builder vehicles(List<VehicleDetails> vehicles) {
			this.vehicles = vehicles;
			return this;
		}

		public ParkingDetails build() {
			return new ParkingDetails(this);
		}

	}

}
