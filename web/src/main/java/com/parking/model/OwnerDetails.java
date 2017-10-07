package com.parking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ownerdetails")
public class OwnerDetails {
    @Id
    private String id;
    private String ownerName;
    private String vehicleNo;

    public OwnerDetails() {
    }

    public OwnerDetails(String id, String ownerName, String vehicleNo) {
        this.id = id;
        this.ownerName = ownerName;
        this.vehicleNo = vehicleNo;
    }

    public String getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    @Override
    public String toString() {
        return "OwnerDetails{" +
                "id='" + id + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
