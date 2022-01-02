package com.example.demoProjectWebService.application.Service;
import com.example.demoProjectWebService.Core.*;
public class MultiplePassengersDiscount extends Discount {

    final int DISCOUNT_PERCENTAGE = 5;

    public MultiplePassengersDiscount(Ride ride) {
        super(ride);
    }

    @Override
    public double discount(double price) {
        if (ride.getNumberOfPassengers() > 1 || (ride.getDriver().getRidePassenger().size() > 1))
            price -= (ride.getPrice() * DISCOUNT_PERCENTAGE) / 100;
        return checkNext(price);
    }
}
