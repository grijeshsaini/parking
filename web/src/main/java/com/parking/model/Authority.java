package com.parking.model;

import org.springframework.security.core.GrantedAuthority;


public enum Authority implements GrantedAuthority {
    ROLE_EMPLOYEE,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
