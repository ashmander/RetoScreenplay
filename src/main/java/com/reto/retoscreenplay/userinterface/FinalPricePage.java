package com.reto.retoscreenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FinalPricePage {

    public static final Target FLIGHT_INFORMATION = Target
            .the("Flight information")
            .located(By.id("basket-icon"));

    public static final Target FINAL_PRICE = Target
            .the("Final price")
            .locatedBy("//div[@class='price']");
}
