package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min=3)
    private String departingAirport;

    @NotNull
    @Size(min=3)
    private String arrivingAirport;

    @NotNull
    @Size(min=3)
    private String type;

    @NotNull
    @Size(min=3)
    private String price;

    @NotNull
    @Size(min=3)
    private String date;

    @NotNull
    @Size(min=3)
    private String flightNum;

    @NotNull
    @Size(min=3)
    private String airline;

    private String headshot;

    public Flight(@NotNull @Size(min = 3) String departingAirport, @NotNull @Size(min = 3) String arrivingAirport, @NotNull @Size(min = 3) String type, @NotNull @Size(min = 3) String price, @NotNull @Size(min = 3) String date, @NotNull @Size(min = 3) String flightNum, @NotNull @Size(min = 3) String airline) {
        this.departingAirport = departingAirport;
        this.arrivingAirport = arrivingAirport;
        this.type = type;
        this.price = price;
        this.date = date;
        this.flightNum = flightNum;
        this.airline = airline;
    }

    public Flight() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartingAirport() {
        return departingAirport;
    }

    public void setDepartingAirport(String departingAirport) {
        this.departingAirport = departingAirport;
    }

    public String getArrivingAirport() {
        return arrivingAirport;
    }

    public void setArrivingAirport(String arrivingAirport) {
        this.arrivingAirport = arrivingAirport;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }
}