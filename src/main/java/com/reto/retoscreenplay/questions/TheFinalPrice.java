package com.reto.retoscreenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

import static com.reto.retoscreenplay.userinterface.FinalPricePage.FINAL_PRICE;
import static com.reto.retoscreenplay.userinterface.FinalPricePage.FLIGHT_INFORMATION;
import static com.reto.retoscreenplay.utils.TransformText.getPriceClean;

public class TheFinalPrice implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Click.on(FLIGHT_INFORMATION)
        );
        return getPriceClean(FINAL_PRICE.resolveFor(actor).getText()).equals(actor.recall("initialPrice"));
    }

    public static Question<Boolean> isEqualToPriceCheaper(){
        return new TheFinalPrice();
    }
}
