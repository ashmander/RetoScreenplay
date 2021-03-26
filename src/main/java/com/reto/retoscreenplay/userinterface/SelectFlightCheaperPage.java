package com.reto.retoscreenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class SelectFlightCheaperPage {

    public static final Target POSSIBLE_FLIGHT_CHEAPER = Target
            .the("Verify if is the cheaper flight")
            .locatedBy("//div[@id='{0}']//div[@class='segment-lowest-price']/div[@class='from-price']");

    public static final Target FLIGHT_CHEAPER = Target
            .the("Select the flight cheaper")
            .locatedBy("//div[@id='{0}']");

    public static final Target FLIGHTS = Target
            .the("List of flights")
            .locatedBy("//div[@class='flights']/div");

    public static final Target CONTINUE = Target
            .the("Continue")
            .locatedBy("div[class*='next-button'] button");

    public static final Target DETAIL_FLIGHT = Target
            .the("Select the detail of the flight")
            .locatedBy("div[class*='viva']:not([class*='super']):not([class*='max']) button");
}
