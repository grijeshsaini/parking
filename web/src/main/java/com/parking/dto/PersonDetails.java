package com.parking.dto;

public class PersonDetails {

	private String name;
	private String mobileNumber;
	private String workNumber;
	private String emailAddress;
	private String building;
	private String floor;
	private String seat;

	
	public PersonDetails() {
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

	public PersonDetails(Builder builder) {
		this.name = builder.name;
		this.mobileNumber = builder.mobileNumber;
		this.workNumber = builder.workNumber;
		this.emailAddress = builder.emailAddress;
		this.building = builder.building;
		this.floor = builder.floor;
		this.seat = builder.seat;

	}

	@Override
	public String toString() {

		return "Person [name= " + name + ", mobileNumber=" + mobileNumber +
				", workNumber=" + workNumber + ", emailAddress=" + emailAddress +
				", building=" + building + ", floor=" + floor + ", seat=" + seat +
				"]";
	}

	public static class Builder {

		private String name;
		private String mobileNumber;
		private String workNumber;
		private String emailAddress;
		private String building;
		private String floor;
		private String seat;

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

		public PersonDetails build() {
			return new PersonDetails(this);
		}

	}

}
