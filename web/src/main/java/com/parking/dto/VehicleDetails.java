package com.parking.dto;

public class VehicleDetails {

	private String regNo;
	private String make;
	private String model;
	private String type;
	private String color;

	/**
	 * @return the regNo
	 */
	public String getRegNo() {
		return regNo;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Default constructor
	 */
	public VehicleDetails() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [regNo= ").append(regNo).append(", make=").append(make).append(", model=").append(model)
				.append(", type=").append(type).append(", color=").append(color).append("]");

		return builder.toString();

	}

	public static class Builder {

		private String regNo;
		private String make;
		private String model;
		private String type;
		private String color;

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

		public Builder color(String color) {
			this.color = color;
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
		this.color = builder.color;
	}

}