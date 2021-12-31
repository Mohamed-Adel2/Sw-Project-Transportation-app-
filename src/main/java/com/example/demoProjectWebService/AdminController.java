package com.example.demoProjectWebService;

import com.example.demoProjectWebService.application.*;
import org.springframework.web.bind.annotation.*;

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
}
