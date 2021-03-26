package com.reto.retoscreenplay.model;

import java.time.LocalDate;
import java.util.Date;

public class OneWayFlight {
    private String departureCity;
    private String destinationCity;
    private LocalDate departureDate;
    private Integer totalPassengers;
    private String money;
    private String discountCode;

    public OneWayFlight(String departureCity, String destinationCity, LocalDate departureDate, Integer totalPassengers, String money, String discountCode) {
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureDate = departureDate;
        this.totalPassengers = totalPassengers;
        this.money = money;
        this.discountCode = discountCode;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public Integer getTotalPassengers() {
        return totalPassengers;
    }

    public String getMoney() {
        return money;
    }

    public String getDiscountCode() {
        return discountCode;
    }
}
