package com.example.demoProjectWebService.application.Service;
import com.example.demoProjectWebService.Core.*;
import com.example.demoProjectWebService.application.Persons.*;
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
