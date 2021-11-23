import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Driver extends NewUser {
    private String drivingLicence, nationalID;
    private boolean pending;
    private Set<String> favoriteAreas = new HashSet<>();
    private ArrayList<Rating> ratings = new ArrayList<>();

    public Driver(String username, String email, String phone, String password, String drivingLicence, String nationalID) {
        super(username, email, phone, password);
        this.drivingLicence = drivingLicence;
        this.nationalID = nationalID;
        this.pending = true;

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
        ArrayList<Ride> rides = RidesData.getRides();
        ArrayList<Ride> favoriteAreaRides = new ArrayList<>();

        for (Ride ride : rides) {
            if (favoriteAreas.contains(ride.getSource()))
                favoriteAreaRides.add(ride);
        }
        return favoriteAreaRides;
    }

    public void makeOffer(Ride ride) {
        System.out.print("Enter Your Offer for Ride From: " + ride.getSource() + " to: " + ride.getDestination() + " :");
        Scanner sc = new Scanner(System.in);
        double price = sc.nextDouble();
        System.out.println("Your Offer Was Sent. Waiting for the reply from Client!");
        ride.setPrice(price);
        User user = ride.getUser();
        ride.setDriver(this);
        user.notify(user, "The driver offers your ride. check the price!", ride);
    }

    public void notify(Driver driver, String message, Ride ride) {

        driver.addNotification(message);
    }
}