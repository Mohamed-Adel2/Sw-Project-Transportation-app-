package com.example.demoProjectWebService.application.Service;
import com.example.demoProjectWebService.Core.*;
import com.example.demoProjectWebService.application.Persons.*;

public class StatusEvent extends Event {
    private String drivername;
    private String passengername;

    public StatusEvent(String name, Driver driver, Passenger passenger) {
        super(name);
        drivername=driver.getUsername();
        passengername=passenger.getUsername();
    }

    public String toString() {
        return "Event: " + this.getName() + " , "
                + "Time: " + this.getTime() + " , "
                + "Driver: " + this.drivername + " , "
                + "Passenger: " + this.passengername;
    }
}
