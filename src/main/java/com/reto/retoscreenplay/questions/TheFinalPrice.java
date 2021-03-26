package com.reto.retoscreenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;

import static com.reto.retoscreenplay.userinterface.FinalPricePage.FINAL_PRICE;
import static com.reto.retoscreenplay.userinterface.FinalPricePage.FLIGHT_INFORMATION;
import static com.reto.retoscreenplay.utils.TransformText.getFinalPrice;

public class TheFinalPrice implements Question<Boolean> {

    private String price;

    public TheFinalPrice(String price) {
        this.price = price;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Click.on(FLIGHT_INFORMATION)
        );
        return getFinalPrice(FINAL_PRICE.resolveFor(actor).getText()).equals(price);
    }

    public static Question<Boolean> isEqualTo(String price){
        return new TheFinalPrice(price);
    }
}
