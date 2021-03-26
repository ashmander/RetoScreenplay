package com.reto.retoscreenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.reto.retoscreenplay.userinterface.SelectFlightCheaperPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectFlightCheaper implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(FLIGHT_CHEAPER()),
                WaitUntil.the(DETAIL_FLIGHT, isVisible()),
                Click.on(DETAIL_FLIGHT),
                JavaScriptClick.on(CONTINUE)
        );
    }

    public static SelectFlightCheaper selectFlightCheaper() {
        return instrumented(SelectFlightCheaper.class);
    }
}
