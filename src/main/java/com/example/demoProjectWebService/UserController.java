package com.example.demoProjectWebService;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import com.example.demoProjectWebService.application.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import java.util.ArrayList;
@RestController
@RequestMapping("/user")
public class UserController {
    public NewUser AppUser;

    public UserController(){
        AppUser=new User();
    }
    @PostMapping("/register")
    public boolean register(@RequestBody User user) {
        return AppUser.register(user);
    }
    @GetMapping(path = "/login/{username}/{password}")
    public NewUser login(@PathVariable String username,@PathVariable String password){
        AppUser=AppUser.login(username,password);
       return AppUser;
    }

    @GetMapping(path = "/offers")
    public ArrayList<Offer> getGetoffers() {
        return ((User)AppUser).getOffers();
    }

    @PostMapping (path = "/requestride/{source}/{destination}")
    public void requestRide(@PathVariable String source,@PathVariable String destination) {
        ((User)AppUser).requestRide(source,destination);
    }

    @PostMapping (path = "/ratedriver/{username}/{stars}")
    public void rateDriver(@PathVariable String username, @PathVariable int stars) {
        ((User)AppUser).rateDriver(username,stars);
    }

    @GetMapping (path = "/driverrate/{username}")
    public double checkDriverRating(@PathVariable String username) {
        return ((User)AppUser).checkDriverRating(username);
    }

    @GetMapping (path = "/checkoffer/{offerid}")
    public String chkOffer(@PathVariable int offerid){
        return ((User)AppUser).chkOffer(offerid);
    }

    @PutMapping (path = "/acceptride/{rideid}/{accept}/{offerid}")
    public void acceptOffer(@PathVariable int rideid,@PathVariable Boolean accept,@PathVariable int offerid){
        ((User)AppUser).acceptOffer(rideid,accept,offerid);
    }

    @PutMapping (path = "/clearoffers")
    public void clearOffers(){
        ((User)AppUser).clearOffers();
    }

    /*@PostMapping (path = "/notify/{message}")
    public void notify(@PathVariable String message,@RequestBody Ride ride) {
        AppUser.notify(message, ride);
    }*/

    @GetMapping("/getnotification")
    public ArrayList<String> getNotifications(){
        return AppUser.getNotifications();
    }
}
