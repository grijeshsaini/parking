package com.parking.model;

public class Vehicle {

	private String reg;
	private String make;
	private String model;
	private String type;
	private String colour;

	public String getreg() {
		return reg;
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

	public Vehicle() {

	}

	@Override
	public String toString() {

		return "Vehicle [reg= " + reg + ", make=" + make + ", model=" + model +
				", type=" + type + ", colour=" + colour + "]";

	}

	public static class Builder {

		private String reg;
		private String make;
		private String model;
		private String type;
		private String colour;

		public Builder reg(String reg) {
			this.reg = reg;
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

		public Vehicle build() {
			return new Vehicle(this);
		}
	}

	private Vehicle(Builder builder) {
		this.reg = builder.reg;
		this.make = builder.make;
		this.model = builder.model;
		this.type = builder.type;
		this.colour = builder.colour;
	}

}
