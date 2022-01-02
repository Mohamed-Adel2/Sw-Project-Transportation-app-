package com.example.demoProjectWebService.application.Service;
import com.example.demoProjectWebService.Data.*;
import com.example.demoProjectWebService.Core.*;

public class DestinationAreaDiscount extends Discount {

    private SystemData data = DataArrays.getInstance();
    final int DISCOUNT_PERCENTAGE = 10;

    public DestinationAreaDiscount(Ride ride) {
        super(ride);
    }

    @Override
    public double discount(double price) {
        if (((DataArrays)data).getDiscountAreas().contains(ride.getDestination()))
            price -= (ride.getPrice() * DISCOUNT_PERCENTAGE) / 100;
        return checkNext(price);
    }
}

