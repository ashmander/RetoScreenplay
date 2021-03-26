package com.reto.retoscreenplay.utils;

public class TransformText {

    public static String getPriceClean(String information) {
        String priceWithPoint = information.split(" ")[1];
        return priceWithPoint.split(",")[0] + priceWithPoint.split(",")[1];
    }
}
