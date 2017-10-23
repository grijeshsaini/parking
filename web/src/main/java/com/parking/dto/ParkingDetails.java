package com.parking.dto;

import java.util.List;

public class ParkingDetails {
	
	private String id;
	private PersonDetails person;
	private List<VehicleDetails> vehicles;
	
	/**
	 * Default constructor
	 */
	public ParkingDetails(){
	}
	
	/**
	 * @param id
	 * @param person
	 * @param vehicles
	 */
	public ParkingDetails(String id, PersonDetails person, List<VehicleDetails> vehicles) {
		super();
		this.id = id;
		this.person = person;
		this.vehicles = vehicles;
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
	public PersonDetails getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(PersonDetails person) {
		this.person = person;
	}
	/**
	 * @return the vehicles
	 */
	public List<VehicleDetails> getVehicles() {
		return vehicles;
	}
	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(List<VehicleDetails> vehicles) {
		this.vehicles = vehicles;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Parking [id=" + id + ", person=" + person + ", vehicles=" + vehicles + "]";
	}
	
	

}
