package com.parking.model;

public class Vehicle {

	private String reg;
	private String make;
	private String model;
	private String type;
	private String color;

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

	public String getColor() {
		return color;
	}

	public Vehicle() {

	}

	@Override
	public String toString() {

		return "Vehicle [reg= " + reg + ", make=" + make + ", model=" + model +
				", type=" + type + ", color=" + color + "]";

	}

	public static class Builder {

		private String reg;
		private String make;
		private String model;
		private String type;
		private String color;

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

		public Builder color(String color) {
			this.color = color;
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
		this.color = builder.color;
	}

}
