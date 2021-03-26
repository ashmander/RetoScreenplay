package com.reto.retoscreenplay.utils;

import net.serenitybdd.screenplay.Actor;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GetFlightCheaper {

    public static String getFlightCheaper(Map<String, Integer> prices, Actor actor) {
        Map<String, Integer> orderAscendent = prices.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        actor.remember("initialPrice", String.valueOf(orderAscendent.entrySet().stream().findFirst().get().getValue()));
        return orderAscendent.entrySet().stream().findFirst().get().getKey();
    }
}
