package com.reto.retoscreenplay.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/book_flight.feature",
        glue = "com.reto.retoscreenplay.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class BookFlight {

}
