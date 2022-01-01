package com.example.demoProjectWebService.application;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class PublicHolidayDiscount extends Discount {

    final int DISCOUNT_PERCENTAGE = 5;

    PublicHolidayDiscount(Ride ride) {
        super(ride);
    }

    @Override
    public double discount(double price) {
        LocalDate today = LocalDate.now();
        if (today.getDayOfWeek() == DayOfWeek.FRIDAY || today.getDayOfWeek() == DayOfWeek.SATURDAY)
            price -= (ride.getPrice() * DISCOUNT_PERCENTAGE) / 100;
        return checkNext(price);
    }
}