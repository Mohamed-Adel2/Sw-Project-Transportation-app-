package com.example.demoProjectWebService.application;

public class AcceptOfferEvent extends Event{
    String passengername;

    public AcceptOfferEvent(String name,Passenger p) {
        super(name);
        passengername=p.getUsername();
    }
    public String toString() {
        return "Event: " + this.getName() + " , "
                + "Time: " + this.getTime() + " , "
                + "Passenger: " + this.passengername;
    }
}
