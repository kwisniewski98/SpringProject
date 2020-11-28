package com.kwisniewski.projekt.Models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AppLocation {

    @NotNull(message = "ID is required")
    private int id;

    @NotNull(message = "ID App is required")
    private int id_app;

    @NotNull(message = "City is required")
    @Size(min = 3, message = "City must be at least 3 characters long")
    private String city;

    @NotNull(message = "Street is required")
    @Size(min = 3, message = "Street must be at least 3 characters long")
    private String street;

    @NotNull(message = "Street number is required")
    private int street_number;

    @NotNull(message = "Country is required")
    @Size(min = 3, message = "Country must be at least 3 characters long")
    private String country;

    public void setId(int id) {
        this.id = id;
    }

    public void setId_app(int id_app) {
        this.id_app = id_app;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreet_number(int street_number) {
        this.street_number = street_number;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public int getId_app() {
        return id_app;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getStreet_number() {
        return street_number;
    }

    public String getCountry() {
        return country;
    }

    public AppLocation() {
    }

    public AppLocation(int id, int id_app, String city, String street, int street_number, String country) {
        this.id = id;
        this.id_app = id_app;
        this.city = city;
        this.street = street;
        this.street_number = street_number;
        this.country = country;
    }

    @Override
    public String toString() {
        return id+ "," +id_app+ "," +city+ "," +street+ "," +street_number+ "," +country;
    }
}
