package com.reto.retoscreenplay.utils;

import java.time.LocalDate;

public class TomorrowDate {

    public static LocalDate tomorrow() {
        LocalDate todayDate = LocalDate.now();
        LocalDate tomorrowDate = todayDate.plusDays(1);
        return tomorrowDate;
    }
}
