package com.parking.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parkingInfo")
public class Parking {
	
	@Id
	private String id;
	private Person person;
	private List<Vehicle> vehicles;
	
	public Parking(){
	}
	
	public Parking(String id, Person person, List<Vehicle> vehicles) {
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

}
