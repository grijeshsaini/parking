package com.parking.dto;

public class OwnerBuilder {
    private String id;
    private String name;

    public OwnerBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public OwnerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Owner createOwner() {
        return new Owner(id, name);
    }
}