package com.example.demoProjectWebService.application;
import java.util.ArrayList;
import java.util.Set;

public interface SystemData {
    void addUser(User user);
    void addDriver(Driver driver);
    void addRide(Ride ride);
    void removeRide(Ride ride);
    NewUser getUser(String username);
    Ride getRide(Ride r);
}
