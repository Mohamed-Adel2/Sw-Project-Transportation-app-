package com.example.demoProjectWebService.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DataArrays implements SystemData{

    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Driver> drivers = new ArrayList<>();
    private static Set<String> systemUsersname = new HashSet<>();
    private static ArrayList<Ride> rides = new ArrayList<>();
    private static DataArrays Data;

    private DataArrays(){}

    public static DataArrays getInstance(){
        if(Data==null)Data=new DataArrays();
        return Data;
    }

    public void addUser(User user) {
        users.add(user);
        systemUsersname.add(user.getUsername());
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public Set<String> getUsernames() {
        return systemUsersname;
    }

    @Override
    public void addDriver(Driver driver) {
        drivers.add(driver);
        systemUsersname.add(driver.getUsername());
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public void removeRide(Ride ride) {
        for(Ride r : rides){
            if(r.equals(ride))
            {
                rides.remove(r);
                break;
            }
        }
    }

    public NewUser getUser(String username){
        ArrayList<User> users = Data.getUsers();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                return users.get(i);
            }
        }
        ArrayList<Driver> Drivers = Data.getDrivers();

        for (int i = 0; i < Drivers.size(); i++) {
            if (Drivers.get(i).getUsername().equalsIgnoreCase(username)) {
                return Drivers.get(i);
            }
        }
        return null;
    }

    public Ride getRide(Ride r){
        ArrayList<Ride> Rides= Data.getRides();
        for (Ride rr:Rides) {
            if(r.equals(rr)){
                return rr;
            }
        }
        return null;
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }
}
