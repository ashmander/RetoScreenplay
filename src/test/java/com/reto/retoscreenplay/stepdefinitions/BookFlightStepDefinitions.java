package com.reto.retoscreenplay.stepdefinitions;

import com.reto.retoscreenplay.questions.TheFinalPrice;
import com.reto.retoscreenplay.tasks.OneWayFlight;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static com.reto.retoscreenplay.model.OneWayFligthBuilder.departureCity;
import static com.reto.retoscreenplay.tasks.CloseNotification.andCloseNotificationAndScrollToSearchCriteria;
import static com.reto.retoscreenplay.tasks.OneWayFlight.searchFlightWith;
import static com.reto.retoscreenplay.tasks.RemoveExtraPrice.removeExtraPrice;
import static com.reto.retoscreenplay.tasks.SelectFlightCheaper.selectFlightCheaper;
import static com.reto.retoscreenplay.userinterface.SelectFlightCheaperPage.priceCheaper;
import static com.reto.retoscreenplay.utils.TomorrowDate.tomorrow;
import static com.reto.retoscreenplay.utils.TransformText.getFinalPrice;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BookFlightStepDefinitions {

    @Before
    public void prepareStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) want to flight to Bogota tomorrow$")
    public void openHomePage(String actor) {
        theActorCalled(actor).wasAbleTo(
                Open.url("https://www.vivaair.com/co/es"),
                andCloseNotificationAndScrollToSearchCriteria()
        );
    }


    @When("^Andres book the flight from Medellin to Bogota$")
    public void bookFlight() {
        theActorInTheSpotlight().attemptsTo(
                searchFlightWith(
                        departureCity("MDE")
                        .destinationCity("BOG")
                        .departureDate(tomorrow())
                        .totalPassengers(1)
                        .money("COP")
                        .andWithoutDiscountCode()),
                selectFlightCheaper(),
                removeExtraPrice()
        );
    }

    @Then("^Andres should see the flight cheaper$")
    public void shouldSeeTheFlightCheaper() {
        theActorInTheSpotlight().should(seeThat(TheFinalPrice.isEqualTo(priceCheaper)));
    }
}
