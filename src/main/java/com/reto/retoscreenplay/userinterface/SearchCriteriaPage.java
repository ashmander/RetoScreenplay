package com.reto.retoscreenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchCriteriaPage {

    public static final Target SEARCH_CRITERIA = Target.the("Scroll to search criteria").located(By.id("criteria"));
}
