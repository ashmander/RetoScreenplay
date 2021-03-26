package com.reto.retoscreenplay.utils;

public class TransformText {

    public static String getFinalPrice(String information) {
        String priceWithPoint = information.split(" ")[1];
        return priceWithPoint.split(",")[0] + priceWithPoint.split(",")[1];
    }
}
