package com.example.demoProjectWebService.Controller;


import com.example.demoProjectWebService.Core.*;
import com.example.demoProjectWebService.application.Persons.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Set;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/driver")
@RestController
public class DriverController {

    User driver;
    DriverController(){
        driver=new Driver();
    }

    @PostMapping("/register")
    public boolean register(@RequestBody Driver d) {
        return driver.register(d);
    }

    @GetMapping("/login/{username}/{password}")
    public User login(@PathVariable String username, @PathVariable String password) {
        driver=driver.login(username,password);
        return driver;
    }

    @PostMapping("/setlicence/{drivingLicence}")
    public void setDrivingLicence(@PathVariable String drivingLicence) {
        ((Driver)driver).setDrivingLicence(drivingLicence);
    }

    @PostMapping("/setpending/{pending}")
    public void setPending(@PathVariable boolean pending) {
        ((Driver)driver).setPending(pending);
    }

    @PostMapping("/addarea/{area}")
    public boolean addFavoriteArea(@PathVariable String area) {
        return ((Driver)driver).addFavoriteArea(area);
    }

    @GetMapping("/Currentlocation")
    public String getCurrentLocation() {
        return ((Driver)driver).getCurrentLocation();
    }

    @GetMapping("/getratings")
    public ArrayList<Rating> listUserRatings() {
        return  ((Driver)driver).listUserRatings();
    }

    @GetMapping("/getlicence")
    public String getDrivingLicence() {
        return  ((Driver)driver).getDrivingLicence();
    }

    @GetMapping("/getid")
    public String getNationalID() {
        return  ((Driver)driver).getNationalID();
    }

    @GetMapping("/getstatus")
    public boolean isPending() {
        return  ((Driver)driver).isPending();
    }

    @GetMapping("/getavgrating")
    public double getAvgRating() {
        return  ((Driver)driver).getAvgRating();
    }

    @GetMapping("/getfavarea")
    public Set<String> getFavoriteAreas() {
        return  ((Driver)driver).getFavoriteAreas();
    }

    @GetMapping("/getRides")
    public ArrayList<Ride> getRides() {
        return  ((Driver)driver).getRides();
    }

    @PutMapping(path="/startride")
    public String startRide() {
        return ((Driver)driver).startRide();
    }

    @PutMapping(path="/finishRide")
    public String finishRide() {
        return ((Driver)driver).finishRide();
    }

    @PostMapping("/makeOffer/{id}/{price}")
    public String makeOffer(@PathVariable int id,@PathVariable double price) {
       return ((Driver)driver).makeOffer(((Driver) driver).getRides().get(id), price);
    }

    @GetMapping (path = "/Balance")
    public double getBalance() {
        return driver.getBalance();
    }

    @GetMapping("/getnotification")
    public ArrayList<String> getNotifications(){
        return driver.getNotifications();
    }
}
