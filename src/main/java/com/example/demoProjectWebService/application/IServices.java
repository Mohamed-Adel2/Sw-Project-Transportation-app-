package com.example.demoProjectWebService.application;
public interface IServices {
    boolean register(NewUser user);
    NewUser login(String username, String Password);
    void notify(String message, Ride ride);
}
