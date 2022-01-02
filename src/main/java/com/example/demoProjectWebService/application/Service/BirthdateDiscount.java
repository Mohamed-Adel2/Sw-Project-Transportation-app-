package com.example.demoProjectWebService.application.Service;
import com.example.demoProjectWebService.Core.*;
import com.example.demoProjectWebService.application.Persons.*;
import java.time.LocalDate;
import java.util.Date;

public class BirthdateDiscount extends Discount {

    final int DISCOUNT_PERCENTAGE = 10;

    public BirthdateDiscount(Ride ride) {
        super(ride);
    }

    @Override
    public double discount(double price) {
        LocalDate today = LocalDate.now();
        Passenger passenger = ride.getPassenger();
        Date birthdate = passenger.getBirthdate();

        if (today.getDayOfMonth() == birthdate.getDate() && today.getMonthValue() == birthdate.getMonth() + 1)
            price -= (ride.getPrice() * DISCOUNT_PERCENTAGE) / 100;
        return checkNext(price);
    }
}
