package com.reto.retoscreenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class RemoveExtraPricePage {

    public static final Target NOT_SELECT_SEAT = Target
            .the("Not select a seat")
            .locatedBy("div[class*='seat-map-container-buttons landscape'] div[data-v-48db7256][data-v-54f6a7bc] button[style*='border: none']");

    public static final Target NOT_SELECT_LUGGAGE = Target
            .the("Not select luggage")
            .locatedBy("div[class*='bag-service-link'] button[data-v-48db7256]");

    public static final Target NOT_BUY_INSURANCE = Target
            .the("Not buy insurance")
            .locatedBy("div[class='chubb-single-offer'] label span.box");

    public static final Target CONFIRM_NOT_SELECT_SEAT = Target
            .the("Confirm that not select a seat")
            .locatedBy("//button[@class='vue-dialog-button'][1]");

    public static final Target NO_CHECK_IN_AIRPORT = Target
            .the("Confirm no check in on the airport")
            .locatedBy("div[id='pass'] div div div[class*='service-toggle-switch']");

    public static final Target NO_EXPRESS_BOARD = Target
            .the("Confirm no express board")
            .locatedBy("div[id='expressLine'] div div div[class*='service-toggle-switch']");

    public static final Target NO_CHANGE_DATE = Target
            .the("Confirm no change flight date")
            .locatedBy("div[id='cancelProtection'] div div div[class*='service-toggle-switch']");
}
