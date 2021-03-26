package com.reto.retoscreenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.reto.retoscreenplay.userinterface.RemoveExtraPricePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RemoveExtraPrice implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(NOT_SELECT_SEAT, isVisible()).forNoMoreThan(20).seconds(),
                JavaScriptClick.on(NOT_SELECT_SEAT),
                WaitUntil.the(CONFIRM_NOT_SELECT_SEAT, isVisible()),
                Click.on(CONFIRM_NOT_SELECT_SEAT),
                WaitUntil.the(NOT_SELECT_LUGGAGE, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(NOT_SELECT_LUGGAGE),
                Click.on(NO_CHECK_IN_AIRPORT),
                Click.on(NO_EXPRESS_BOARD),
                Click.on(NO_CHANGE_DATE),
                Click.on(NOT_BUY_INSURANCE)
        );
    }

    public static RemoveExtraPrice removeExtraPrice() {
        return instrumented(RemoveExtraPrice.class);
    }
}
