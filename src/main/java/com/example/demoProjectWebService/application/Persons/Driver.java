package com.example.demoProjectWebService.application.Persons;

import com.example.demoProjectWebService.Core.*;
import com.example.demoProjectWebService.Data.*;
import com.example.demoProjectWebService.application.Service.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Driver extends User {
    private String drivingLicence;
    private String nationalID;
    private boolean available=true;
    private String currentLocation="main_area";
    private boolean pending=true;
    private int carCapacity;
    private ArrayList<Passenger> RidePassenger = new ArrayList<>();
    private Set<String> favoriteAreas = new HashSet<>();
    private ArrayList<Rating> ratings = new ArrayList<>();

    public Driver(String username, String email, String phone, String password, String drivingLicence, String nationalID,int cap) {
        super(username, email, phone, password);
        this.drivingLicence = drivingLicence;
        this.nationalID = nationalID;
        carCapacity=cap;
    }

    public Driver() {
    }

    public boolean register(User user) {
        if (((DataArrays)Data).getUsernames().contains(user.getUsername()))
            return false;
        Data.addDriver((Driver) user);
        return true;
    }

    public void setPassenger(Passenger passenger){
        RidePassenger.add(passenger);}

    public ArrayList<Passenger> getRidePassenger(){return RidePassenger;}

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

    public boolean addFavoriteArea(String area) {
        return favoriteAreas.add(area);
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
            if (favoriteAreas.contains(ride.getSource()) && ride.status)
                favoriteAreaRides.add(ride);
        }
        return favoriteAreaRides;
    }

    public boolean canTakeRide(Ride ride) {
        return getFavoriteAreas().contains(ride.getSource()) && (getCurrentLocation().equalsIgnoreCase(ride.getSource()) || getCurrentLocation().equalsIgnoreCase("main_area")) && isAvailable() && getCarCapacity()>=ride.getNumberOfPassengers();
    }

    public String startRide() {
        for(int i = 0; i< RidePassenger.size(); i++)
        {
            RidePassenger.get(i).getRide().calculatePriceAfterDiscount();
            RidePassenger.get(i).withdraw(RidePassenger.get(i).getRide().getPriceAfterDiscount());
            RidePassenger.get(i).setFirstRide(false);
            this.deposit(RidePassenger.get(i).getRide().getPrice());
            RidePassenger.get(i).getRide().eventManager.notify(new StatusEvent("Captain arrived to user location", this, RidePassenger.get(i)), RidePassenger.get(i).getRide());
        }
        available = false;
        return "ride started. wish you a comfort ride.!";
    }

    public String finishRide() {
        currentLocation = RidePassenger.get(0).getRide().getDestination();
        available = true;
        for(int i = 0; i< RidePassenger.size(); i++)
        {
            RidePassenger.get(i).getRide().eventManager.notify(new StatusEvent("Captain arrived to user destination", this, RidePassenger.get(i)), RidePassenger.get(i).getRide());
            RidePassenger.get(i).getRide().status=false;
        }
        return "ride finished. 7amdla 3la slamtk <3 .!";
    }

    public String makeOffer(Ride r, double price) {
        Ride ride=Data.getRide(r);
        Passenger user = ride.getUser();
        ride.eventManager.notify(new MakeOfferEvent("Captain Make offer " , this, price),ride);
        ride.add_Offer(new Offer(this,price));
        user.notify( "The driver offers your ride. check the price!", ride);
        return "Offer sent successfully!";
    }

    public int getCarCapacity() {
        return carCapacity;
    }

    public void setCarCapacity(int carCapacity) {
        this.carCapacity = carCapacity;
    }

    public void notify( String message, Ride ride) {
        this.addNotification(message);
    }
}