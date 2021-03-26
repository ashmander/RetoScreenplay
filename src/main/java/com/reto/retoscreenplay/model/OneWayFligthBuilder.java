package com.reto.retoscreenplay.model;

import java.time.LocalDate;

public class OneWayFligthBuilder {

    private String departureCity;
    private String destinationCity;
    private LocalDate departureDate;
    private Integer totalPassengers;
    private String money;

    public OneWayFligthBuilder(String departureCity) {
        this.departureCity = departureCity;
    }

    public static OneWayFligthBuilder departureCity(String departureCity) {
        return new OneWayFligthBuilder(departureCity);
    }

    public OneWayFligthBuilder destinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
        return this;
    }

    public OneWayFligthBuilder departureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
        return this;
    }

    public OneWayFligthBuilder totalPassengers(Integer totalPassengers) {
        this.totalPassengers = totalPassengers;
        return this;
    }

    public OneWayFligthBuilder money(String money) {
        this.money = money;
        return this;
    }

    public OneWayFlight andWithoutDiscountCode() {
        return new OneWayFlight(
                this.departureCity,
                this.destinationCity,
                this.departureDate,
                this.totalPassengers,
                this.money,
                "");
    }
}
