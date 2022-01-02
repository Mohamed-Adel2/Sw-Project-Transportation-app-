package com.example.demoProjectWebService.Controller;

import java.util.ArrayList;
import com.example.demoProjectWebService.Core.*;
import com.example.demoProjectWebService.application.Persons.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    public User AppUser;

    public UserController(){
        AppUser=new Passenger();
    }
    @PostMapping("/register")
    public boolean register(@RequestBody Passenger user) {
        return AppUser.register(user);
    }

    @GetMapping(path = "/login/{username}/{password}")
    public User login(@PathVariable String username, @PathVariable String password){
        AppUser=AppUser.login(username,password);
       return AppUser;
    }

    @GetMapping(path = "/offers")
    public ArrayList<Offer> getGetoffers() {
        return ((Passenger)AppUser).Getoffers();
    }

    @PostMapping (path = "/requestride/{source}/{destination}/{numberOfPassengers}")
    public void requestRide(@PathVariable String source,@PathVariable String destination,@PathVariable int numberOfPassengers ) {
        ((Passenger)AppUser).requestRide(source,destination,numberOfPassengers);
    }

    @PostMapping (path = "/ratedriver/{username}/{stars}")
    public void rateDriver(@PathVariable String username, @PathVariable int stars) {
        ((Passenger)AppUser).rateDriver(username,stars);
    }

    @GetMapping (path = "/driverrate/{username}")
    public double checkDriverRating(@PathVariable String username) {
        return ((Passenger)AppUser).checkDriverRating(username);
    }

    @GetMapping (path = "/Balance")
    public double getBalance() {
        return AppUser.getBalance();
    }

    @GetMapping (path = "/checkoffer/{offerid}")
    public String chkOffer(@PathVariable int offerid){
        return ((Passenger)AppUser).chkOffer(offerid);
    }

    @PutMapping (path = "/acceptride/{rideid}/{accept}/{offerid}")
    public void acceptOffer(@PathVariable int rideid,@PathVariable Boolean accept,@PathVariable int offerid){
        ((Passenger)AppUser).acceptOffer(rideid,accept,offerid);
    }

    @PutMapping (path = "/clearoffers")
    public void clearOffers(){
        ((Passenger)AppUser).clearOffers();
    }

    @PutMapping (path = "/deposit/{amount}")
    public boolean deposit( @PathVariable double amount) {
        return AppUser.deposit(amount);
    }

    @GetMapping("/getnotification")
    public ArrayList<String> getNotifications(){
        return AppUser.getNotifications();
    }
}
