package com.parking.model;

/**
 * Created by grijesh on 07/10/17.
 */
public class Vehicle {

	private String reg;
	private String make;
	private String model;
	private String type;
	private String color;

	/**
	 * @return the reg
	 */
	public String getreg() {
		return reg;
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
	public Vehicle() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vehicle [reg= ").append(reg).append(", make=").append(make).append(", model=").append(model)
				.append(", type=").append(type).append(", color=").append(color).append("]");

		return builder.toString();

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
