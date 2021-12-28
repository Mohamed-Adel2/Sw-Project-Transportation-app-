

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Driver extends NewUser {
    private String drivingLicence, nationalID;
    private boolean pending;
    private String Current_location;
    private boolean available;
    private SystemData Data=DataArrays.getInstance();
    private Set<String> favoriteAreas = new HashSet<>();
    private ArrayList<Rating> ratings = new ArrayList<>();

    public Driver(String username, String email, String phone, String password, String drivingLicence, String nationalID) {
        super(username, email, phone, password);
        this.drivingLicence = drivingLicence;
        this.nationalID = nationalID;
        this.pending = true;
        available =true;
        Current_location = "main_area";
    }

    public Driver() {
    }

    public boolean register(NewUser user) {
        if (Data.getUsernames().contains(user.getUsername()))
            return false;
        Data.addDriver((Driver) user);
        return true;
    }

    public String getCurrent_location() {
        return Current_location;
    }

    public boolean isAvailable() {
        return available;
    }

    public NewUser login(String username, String password) {
        ArrayList<Driver> drivers = Data.getDrivers();
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
        System.out.println("Thanks for Rating me "+rating.getStars());
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
        ArrayList<Ride> rides = Data.getRides();
        ArrayList<Ride> favoriteAreaRides = new ArrayList<>();

        for (Ride ride : rides) {
            if (favoriteAreas.contains(ride.getSource()))
                favoriteAreaRides.add(ride);
        }
        return favoriteAreaRides;
    }

    public void makeOffer(Ride ride, double price) {
        User user = ride.getUser();
        ride.add_Offer(new Offer(this,price));
        user.notify(user, "The driver offers your ride. check the price!", ride);
    }

    public void setCurrent_location(String current_location) {
        Current_location = current_location;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void finish_Ride(Ride ride)
    {
        Current_location = ride.getDestination();
        available = true;
    }

    public void start_Ride()
    {
        available=false;
    }

    public void notify(Driver driver, String message, Ride ride) {
        driver.addNotification(message);
    }
}