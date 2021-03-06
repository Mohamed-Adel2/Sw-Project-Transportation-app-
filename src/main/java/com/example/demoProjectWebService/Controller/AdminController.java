package com.example.demoProjectWebService.Controller;

import org.springframework.web.bind.annotation.*;
import com.example.demoProjectWebService.application.Persons.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/admin")
public class AdminController {
    public Admin AppAdmin=Admin.getinstance();

    @PutMapping(path = "/suspend/{username}")
    public boolean suspendUser(@PathVariable String username) {
        return AppAdmin.suspendUser(username);
    }

    @PutMapping(path = "/verify/{username}")
    public void verifyDriver(@PathVariable String username) {
        AppAdmin.verifyDriver(username);
    }

    @GetMapping(path = "/getpending")
    public ArrayList<Driver> listPendingDrivers() {
        return AppAdmin.listPendingDrivers();
    }

    @PostMapping(path = "/addDiscountArea/{area}")
    public void addDiscountArea(@PathVariable String area) {
        AppAdmin.addDiscountArea(area);
    }

    @GetMapping(path = "/Show_ride_event/{Rideid}")
    public ArrayList<String> showRideEvents(@PathVariable int Rideid) {
        return AppAdmin.showRideEvents(Rideid);
    }

}
