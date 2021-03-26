package com.reto.retoscreenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.reto.retoscreenplay.userinterface.OneWayFlightPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OneWayFlight implements Task {

    private com.reto.retoscreenplay.model.OneWayFlight oneWayFlight;

    public OneWayFlight(com.reto.retoscreenplay.model.OneWayFlight oneWayFlight) {
        this.oneWayFlight = oneWayFlight;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CHECKBOX_ONE_WAY),
                Click.on(LIST_DEPARTURE_CITIES),
                Clear.field(LIST_DEPARTURE_CITIES),
                Enter.theValue(oneWayFlight.getDepartureCity()).into(LIST_DEPARTURE_CITIES),
                Click.on(DEPARTURE_CITY),
                //Click.on(LIST_DESTINATION_CITIES),
                Enter.theValue(oneWayFlight.getDestinationCity()).into(LIST_DESTINATION_CITIES),
                Click.on(DESTINATION_CITY),
                Click.on(CALENDAR),
                WaitUntil.the(DATE_SELECTED(oneWayFlight.getDepartureDate().toString()), isVisible()),
                Click.on(DATE_SELECTED(oneWayFlight.getDepartureDate().toString())),
                Click.on(SEARCH_FLIGHT)
        );
    }

    public static OneWayFlight searchFlightWith(com.reto.retoscreenplay.model.OneWayFlight oneWayFlight) {
        return instrumented(OneWayFlight.class, oneWayFlight);
    }
}
