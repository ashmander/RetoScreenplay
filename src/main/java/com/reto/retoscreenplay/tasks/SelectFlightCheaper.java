package com.reto.retoscreenplay.tasks;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.reto.retoscreenplay.userinterface.SelectFlightCheaperPage.*;
import static com.reto.retoscreenplay.utils.GetFlightCheaper.getFlightCheaper;
import static com.reto.retoscreenplay.utils.TransformText.getPriceClean;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectFlightCheaper implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        FLIGHTS.waitingForNoMoreThan(Duration.ofSeconds(10));
        String flightCheaperId = getFlightCheaperId(FLIGHTS.resolveAllFor(actor), actor);
        actor.attemptsTo(
                Click.on(FLIGHT_CHEAPER.of(flightCheaperId)),
                WaitUntil.the(DETAIL_FLIGHT, isVisible()),
                Click.on(DETAIL_FLIGHT),
                JavaScriptClick.on(CONTINUE)
        );
    }

    public static SelectFlightCheaper selectFlightCheaper() {
        return instrumented(SelectFlightCheaper.class);
    }

    public String getFlightCheaperId(List<WebElementFacade> flights, Actor actor) {
        Map<String, Integer> prices = new HashMap<>();
        for(WebElement flight : flights) {
            String id = flight.getAttribute("id");
            Integer priceConverted = Integer.parseInt(getPriceClean(POSSIBLE_FLIGHT_CHEAPER.of(id).resolveFor(actor).getText()));
            prices.put(id, priceConverted);
        }
        return getFlightCheaper(prices, actor);
    }
}
