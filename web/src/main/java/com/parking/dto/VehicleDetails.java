package com.parking.dto;

public class VehicleDetails {

	private String regNo;
	private String make;
	private String model;
	private String type;
	private String colour;

	public String getRegNo() {
		return regNo;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getType() {
		return type;
	}

	public String getColour() {
		return colour;
	}

	public VehicleDetails() {

	}

	@Override
	public String toString() {

		return "Vehicle [regNo= " + regNo + ", make=" + make + ", model=" + model +
				", type=" + type + ", colour=" + colour + "]";

	}

	public static class Builder {

		private String regNo;
		private String make;
		private String model;
		private String type;
		private String colour;

		public Builder regNo(String regNo) {
			this.regNo = regNo;
			return this;
		}

		public Builder make(String make) {
			this.make = make;
			return this;
		}

		public Builder model(String model) {
			this.model = model;
			return this;
		}

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder colour(String colour) {
			this.colour = colour;
			return this;
		}

		public VehicleDetails build() {
			return new VehicleDetails(this);
		}
	}

	private VehicleDetails(Builder builder) {
		this.regNo = builder.regNo;
		this.make = builder.make;
		this.model = builder.model;
		this.type = builder.type;
		this.colour = builder.colour;
	}

}