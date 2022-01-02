import java.util.ArrayList;
import java.util.Date;

public class Passenger extends User {

    private Date birthdate = new Date();
    private Ride ride = new Ride();
    private boolean firstRide;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private ArrayList<Ride> ridesHistory = new ArrayList<>();

    public Passenger() {}

    public Passenger(String username, String email, String phone, String password, Date birthdate) {
        super(username, email, phone, password);
        this.birthdate = birthdate;
        this.firstRide = true;
    }

    public Ride getRide() {
        return ride;
    }

    public void clearRide() {
        ride = null;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public ArrayList<Ride> getRidesHistory() {
        return ridesHistory;
    }

    public boolean isFirstRide() {
        return firstRide;
    }

    public void requestRide(String source, String destination, int numberOfPassengers) {
        Ride myRide = new Ride(source, destination, this, numberOfPassengers);
        data.addRide(myRide);
        data.addPendingRide(myRide);
    }

    public void rateDriver(Driver driver, int stars) {
        driver.addUserRating(new Rating(this, stars));
    }

    public double checkDriverRating(Driver driver) {
        return driver.getAvgRating();
    }

    public String checkOffer(Offer offer) {
        return ("The driver: " + offer.getDriver().getUsername() + " Offers Your Ride with: " + offer.getPrice() + " LE.");
    }

    public boolean acceptOffer(Ride ride, Boolean accept, Offer offer) {
        offer.getDriver().notify(offer.getDriver(), "User " + (accept ? "accepted" : "rejected") + " the offer", ride);
        ride.setDriver(offer.getDriver());
        ride.setPrice(offer.getPrice());
        if (accept) {
            offer.getDriver().setCarCapacity(offer.getDriver().getCarCapacity() - ride.getNumberOfPassengers());
            ridesHistory.add(ride);
            data.removeRide(ride);
//          firstRide = false;
            ride.eventManager.notify(new Event("User accepts the captain price", offer.getDriver(), this), ride);
            ride.getDriver().setPassenger(ride.getPassenger());
            this.ride=ride;
            ride.addPassenger(this);
            return true;
        }
        ride.setDriver(null);
        ride.setPrice(null);
        return false;
    }


    @Override
    public boolean register(User user) {
        if (data.getUsernames().contains(user.getUsername()))
            return false;
        data.addPassenger((Passenger) user);
        return true;
    }

    @Override
    public User login(String username, String password) {
        ArrayList<Passenger> passengers = data.getPassengers();
        for (Passenger passenger : passengers) {
            if (passenger.getUsername().equals(username) && passenger.getPassword().equals(password) && !passenger.isSuspended()) {
                return passenger;
            }
        }
        return null;
    }

    public void notify(Passenger passenger, String message, Ride ride) {
        passenger.addNotification(message);
        this.ride = ride;
    }
}