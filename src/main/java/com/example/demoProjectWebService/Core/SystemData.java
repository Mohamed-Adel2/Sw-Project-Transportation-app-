package com.example.demoProjectWebService.Core;
import com.example.demoProjectWebService.application.Persons.*;

public interface SystemData {
    void addPassenger(Passenger user);
    void addDriver(Driver driver);
    void addRide(Ride ride);
    void removeRide(Ride ride);
    User getUser(String username);
    Ride getRide(Ride r);
    boolean addDiscountArea(String area);
}
