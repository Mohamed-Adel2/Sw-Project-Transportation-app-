package com.example.demoProjectWebService.application;
public interface IServices {
    boolean register(User user);
    User login(String username, String Password);
    void notify(String message, Ride ride);
}
