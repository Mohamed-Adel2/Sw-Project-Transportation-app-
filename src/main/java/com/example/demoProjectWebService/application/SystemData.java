package com.example.demoProjectWebService.application;

public interface SystemData {
    void addPassenger(Passenger user);
    void addDriver(Driver driver);
    void addRide(Ride ride);
    void removeRide(Ride ride);
    User getUser(String username);
    Ride getRide(Ride r);
    void addDiscountArea(String area);
}
