package com.reto.retoscreenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OneWayFlightPage {

    public static final Target CHECKBOX_ONE_WAY = Target
            .the("Click on the checkbox one way")
            .locatedBy("div[class='search-type-switch'] label");

    public static final Target LIST_DEPARTURE_CITIES = Target
            .the("Click on the departure cities list")
            .locatedBy("//div[@id='criteria-airport-select-departure']//input");

    public static final Target LIST_DESTINATION_CITIES = Target
            .the("Click on the destination cities list")
            .locatedBy("//div[@id='criteria-airport-select-destination']//input");

    public static final Target SEARCH_FLIGHT = Target
            .the("Click on the button to search flights")
            .located(By.id("criteria-search-button-desktop"));

    public static final Target CALENDAR = Target
            .the("Click on the calendar to select a date")
            .locatedBy("div[class*='date-selector-container']");

    public static final Target DEPARTURE_CITY = Target
            .the("Departure city selected")
            .locatedBy("li[id*='departure']");

    public static final Target DESTINATION_CITY = Target
            .the("Destination city selected")
            .locatedBy("li[id*='destination']");

    public static Target DATE_SELECTED(String date) {
        return Target
                .the("Date selected")
                .locatedBy("//button[@date='"+date+"']");
    }
}
