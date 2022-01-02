package com.example.demoProjectWebService.Core;
import com.example.demoProjectWebService.application.Persons.*;

public class Offer {
    private Driver driver;
    private double price;
    public int ID;
    public Offer(Driver driver, double price) {
        this.driver = driver;
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getPrice() {
        return price;
    }
}
