package com.example.demoProjectWebService.application;

public class MakeOfferEvent extends Event{

    String drivername;
    double price;
    public MakeOfferEvent(String name,Driver driver,double p) {
        super(name);
        drivername=driver.getUsername();
        price=p;
    }
    public String toString() {
        return "Event: " + this.getName() + " , "
                + "Time: " + this.getTime() + " , "
                + "Driver: " + this.drivername+" , "
                +"Captain put a price to the ride = "+price;
    }
}
