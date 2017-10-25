package com.parking.dto;

import java.util.List;

public class ParkingDetails {
	
	private String id;
	private PersonDetails person;
	private List<VehicleDetails> vehicles;
	
	public ParkingDetails(){
	}
	
	public ParkingDetails(String id, PersonDetails person, List<VehicleDetails> vehicles) {
		super();
		this.id = id;
		this.person = person;
		this.vehicles = vehicles;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public PersonDetails getPerson() {
		return person;
	}
	public void setPerson(PersonDetails person) {
		this.person = person;
	}
	public List<VehicleDetails> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<VehicleDetails> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		return "Parking [id=" + id + ", person=" + person + ", vehicles=" + vehicles + "]";
	}
	
	

}
