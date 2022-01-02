package com.example.demoProjectWebService.application.Service;

import com.example.demoProjectWebService.Core.*;

public class FirstRideDiscount extends Discount {

    final int DISCOUNT_PERCENTAGE = 10;

    public FirstRideDiscount(Ride ride) {
        super(ride);
    }

    @Override
    public double discount(double price) {
        if (ride.getPassenger().isFirstRide())
            price -= (ride.getPrice() * DISCOUNT_PERCENTAGE) / 100;
        return checkNext(price);
    }
}
