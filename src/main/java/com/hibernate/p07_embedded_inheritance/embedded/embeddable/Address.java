package com.hibernate.p07_embedded_inheritance.embedded.embeddable;

import jakarta.persistence.Embeddable;

/**
 * @Embeddable makes Address a reusable value object.
 *
 * Address does not have its own primary key.
 * Its fields will be stored in the owning entity's table.
 */
@Embeddable
public class Address {

    private String street;
    private String city;
    private String state;
    private String pincode;

    public Address() {
    }

    public Address(String street, String city,
                   String state, String pincode) {

        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}