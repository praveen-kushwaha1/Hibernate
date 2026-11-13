package com.hibernate.p07_embedded_inheritance.embedded.attributeoverride;

import jakarta.persistence.Embeddable;

/**
 * Reusable address value object.
 */
@Embeddable
public class Address {

    private String street;
    private String city;
    private String state;

    public Address() {
    }

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}