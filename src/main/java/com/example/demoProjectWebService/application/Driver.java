package com.example.demoProjectWebService.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Driver extends User {
    private String drivingLicence;
    private String nationalID;
    private boolean available=true;
    private String currentLocation="main_area";
    private boolean pending=true;
    private SystemData Data=DataArrays.getInstance();
    private Set<String> favoriteAreas = new HashSet<>();
    private ArrayList<Rating> ratings = new ArrayList<>();

    public Driver(String username, String email, String phone, String password, String drivingLicence, String nationalID) {
        super(username, email, phone, password);
        this.drivingLicence = drivingLicence;
        this.nationalID = nationalID;
    }

    public Driver() {
    }

    public boolean register(User user) {
        if (((DataArrays)Data).getUsernames().contains(user.getUsername()))
            return false;
        Data.addDriver((Driver) user);
        return true;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User login(String username, String password) {
        ArrayList<Driver> drivers = ((DataArrays)Data).getDrivers();
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getUsername().equals(username) && drivers.get(i).getPassword().equals(password)
                    && !drivers.get(i).isSuspended() && !drivers.get(i).isPending()) {
                return drivers.get(i);
            }
        }
        return null;
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public void addUserRating(Rating rating) {
        ratings.add(rating);
    }

    public void addFavoriteArea(String area) {
        favoriteAreas.add(area);
    }

    public ArrayList<Rating> listUserRatings() {
        return ratings;
    }

    public String getDrivingLicence() {
        return drivingLicence;
    }

    public String getNationalID() {
        return nationalID;
    }

    public boolean isPending() {
        return pending;
    }

    public double getAvgRating() {
        return CalculateAvgRating.calcAvgRating(this);
    }

    public Set<String> getFavoriteAreas() {
        return favoriteAreas;
    }

    public ArrayList<Ride> getRides() {
        ArrayList<Ride> rides = ((DataArrays)Data).getRides();
        ArrayList<Ride> favoriteAreaRides = new ArrayList<>();

        for (Ride ride : rides) {
            if (favoriteAreas.contains(ride.getSource()))
                favoriteAreaRides.add(ride);
        }
        return favoriteAreaRides;
    }

    public boolean canTakeRide(Ride ride) {
        return getFavoriteAreas().contains(ride.getSource()) && (getCurrentLocation().equalsIgnoreCase(ride.getSource()) || getCurrentLocation().equalsIgnoreCase("main_area")) && isAvailable();
    }

    public void startRide(int  Rideid) {
        available = false;
        ((DataArrays)Data).getRides().get(Rideid).eventManager.notify(new StatusEvent("Captain arrived to user location", this, ((DataArrays)Data).getRides().get(Rideid).getPassenger()), ((DataArrays)Data).getRides().get(Rideid));
    }

    public void finishRide(int  Rideid) {
        currentLocation = ((DataArrays)Data).getRides().get(Rideid).getDestination();
        available = true;
        ((DataArrays)Data).getRides().get(Rideid).eventManager.notify(new StatusEvent("Captain arrived to user destination", this, ((DataArrays)Data).getRides().get(Rideid).getPassenger()), ((DataArrays)Data).getRides().get(Rideid));
    }

    public void makeOffer(Ride r, double price) {
        Ride ride=Data.getRide(r);
        Passenger user = ride.getUser();
        ride.eventManager.notify(new MakeOfferEvent("Captain Make offer " , this, price),ride);
        ride.add_Offer(new Offer(this,price));
        user.notify( "The driver offers your ride. check the price!", ride);
    }

    public void notify( String message, Ride ride) {
        this.addNotification(message);
    }
}