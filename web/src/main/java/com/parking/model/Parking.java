package com.parking.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "parkingInfo")
public class Parking {
	
	@Id
	private String id;
	private Person person;
	private List<Vehicle> Vehicles;
	
	/**
	 * Default constructor
	 */
	public Parking(){
	}
	
	/**
	 * @param id
	 * @param person
	 * @param vehicles
	 */
	public Parking(String id, Person person, List<Vehicle> vehicles) {
		this.id = id;
		this.person = person;
		Vehicles = vehicles;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the person
	 */
	public Person getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(Person person) {
		this.person = person;
	}
	/**
	 * @return the vehicles
	 */
	public List<Vehicle> getVehicles() {
		return Vehicles;
	}
	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(List<Vehicle> vehicles) {
		Vehicles = vehicles;
	}

}
