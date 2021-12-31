package com.example.demoProjectWebService;

import com.example.demoProjectWebService.application.*;
import com.example.demoProjectWebService.application.DataArrays;
import com.example.demoProjectWebService.application.Driver;
import com.example.demoProjectWebService.application.Ride;
import com.example.demoProjectWebService.application.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Set;

@RestController
public class DataController {
    public DataArrays Data=DataArrays.getInstance();

    @PostMapping(path = "/adduser")
    public void addUser(@RequestBody User user) {
        Data.addUser(user);
    }

    @GetMapping(path = "/getusers")
    public ArrayList<User> getUsers()
    {
        return Data.getUsers();
    }

    @GetMapping(path = "/getusernames")
    public Set<String> getUsernames() {
        return Data.getUsernames();
    }

    @PostMapping(path = "/addDriver")
    public void addDriver(@RequestBody Driver driver) {
        Data.addDriver(driver);
    }

    @GetMapping(path = "/getdrivers")
    public ArrayList<Driver> getDrivers() {
        return Data.getDrivers();
    }

    @PostMapping(path = "/addride")
    public void addRide(@RequestBody Ride ride) {
        Data.addRide(ride);
    }


    @DeleteMapping(path = "/removeride")
    public void removeRide(@RequestBody Ride ride) {
        Data.removeRide(ride);
    }

    @GetMapping(path = "/getrides")
    public ArrayList<Ride> getRides() {
        return Data.getRides();
    }
}
