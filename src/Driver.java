import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Driver extends User {
    private String drivingLicence;
    private String nationalID;
    private String currentLocation;
    private boolean pending;
    private boolean available;
    private Set<String> favoriteAreas = new HashSet<>();
    private ArrayList<Rating> ratings = new ArrayList<>();

    public Driver() {}

    public Driver(String username, String email, String phone, String password, String drivingLicence, String nationalID) {
        super(username, email, phone, password);
        this.drivingLicence = drivingLicence;
        this.nationalID = nationalID;
        this.pending = true;
        this.available = true;
        this.currentLocation = "main_area";
    }

    public void setDrivingLicence(String drivingLicence) {
        this.drivingLicence = drivingLicence;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return available;
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
        ArrayList<Ride> rides = data.getRides();
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

    public void addUserRating(Rating rating) {
        ratings.add(rating);
        System.out.println("Thanks for Rating me " + rating.getStars());
    }

    public void addFavoriteArea(String area) {
        favoriteAreas.add(area);
    }

    public ArrayList<Rating> listUserRatings() {
        return ratings;
    }

    public void startRide(Ride ride) {
        available = false;
        ride.eventManager.notify(new Event("Captain arrived to user location", this, ride.getPassenger()), ride);
    }

    public void finishRide(Ride ride) {
        currentLocation = ride.getDestination();
        available = true;
        ride.eventManager.notify(new Event("Captain arrived to user destination", this, ride.getPassenger()), ride);
    }

    public void makeOffer(Ride ride, double price) {
        Passenger user = ride.getPassenger();
        ride.addOffer(new Offer(this, price));
        ride.eventManager.notify(new Event("Captain put a price to the ride", this, ride.getPassenger()), ride);
        user.notify(user, "The driver offers your ride. check the price!", ride);
    }

    @Override
    public boolean register(User user) {
        if (data.getUsernames().contains(user.getUsername()))
            return false;
        data.addDriver((Driver) user);
        return true;
    }

    @Override
    public User login(String username, String password) {
        ArrayList<Driver> drivers = data.getDrivers();
        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getUsername().equals(username) && drivers.get(i).getPassword().equals(password)
                    && !drivers.get(i).isSuspended() && !drivers.get(i).isPending()) {
                return drivers.get(i);
            }
        }
        return null;
    }

    public void notify(Driver driver, String message, Ride ride) {
        driver.addNotification(message);
    }
}