package com.example.demoProjectWebService.application;
import java.util.ArrayList;

public class Admin {

    private static Admin admin;
    private SystemData Data=DataArrays.getInstance();
    private Admin() {}

    public static Admin getinstance(){
        if(admin==null)admin=new Admin();
        return admin;
    }

    public boolean suspendUser(String username) {
        ArrayList<User> users = ((DataArrays)Data).getUsers();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                ((DataArrays)Data).getUsers().get(i).setSuspended(true);
                return true;
            }
        }
        ArrayList<Driver> Drivers = ((DataArrays)Data).getDrivers();

        for (int i = 0; i < Drivers.size(); i++) {
            if (Drivers.get(i).getUsername().equalsIgnoreCase(username)) {
                ((DataArrays)Data).getDrivers().get(i).setSuspended(true);
                return true;
            }
        }
        return false;
    }

    public void verifyDriver(String username) {
        ArrayList<Driver> Drivers = ((DataArrays)Data).getDrivers();
        for (int i = 0; i < Drivers.size(); i++) {
            if (Drivers.get(i).getUsername().equalsIgnoreCase(username)) {
                ((DataArrays)Data).getDrivers().get(i).setPending(false);
                return;
            }
        }
    }

    public ArrayList<Driver> listPendingDrivers() {
        ArrayList<Driver> drivers = ((DataArrays)Data).getDrivers();
        ArrayList<Driver> pendingDrivers = new ArrayList<>();

        for (Driver driver : drivers)
            if (driver.isPending())
                pendingDrivers.add(driver);
        return pendingDrivers;
    }

}