package com.example.demoProjectWebService.application;
import java.util.ArrayList;
import java.util.Date;

public class Passenger extends User {

    public Ride ride = new Ride();
    private boolean  firstRide = true;;
    private Date birthdate = new Date();
    private ArrayList<Ride> ridesHistory = new ArrayList<Ride>();
    private SystemData Data = DataArrays.getInstance();

    public Passenger(String username, String email, String phone, String password, Date birthdate) {
        super(username, email, phone, password);
        this.birthdate = birthdate;
    }

    public Passenger() {
    }

    public boolean register(User user) {
        if (((DataArrays)Data).getUsernames().contains(user.getUsername()))
            return false;
        Data.addPassenger((Passenger) user);
        return true;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public User login(String username, String password) {
        ArrayList<Passenger> users = ((DataArrays)Data).getPassengers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password) && !users.get(i).isSuspended()) {
                return users.get(i);
            }
        }
        return null;
    }

    public boolean isFirstRide() {
        return firstRide;
    }

    public Ride getRide() {
        return ride;
    }

    public ArrayList<Offer> Getoffers() {
        return ride.getOffers();
    }

    public void requestRide(String source, String destination,int numberOfPassengers) {
        Ride my_ride = new Ride(source, destination, this,numberOfPassengers);
        ride=my_ride;
        Data.addRide(my_ride);
    }

    public void rateDriver(String username,int stars) {
        Driver d=(Driver) Data.getUser(username);
        d.addUserRating(new Rating(this, stars));
    }

    public double checkDriverRating(String username) {
        return ((Driver)Data.getUser(username)).getAvgRating();
    }

    public String chkOffer(int offerid) {
        return ("The driver: " + ride.getOffers().get(offerid).getDriver().getUsername() + " Offers Your Ride with: " + ride.getOffers().get(offerid).getPrice() + " LE.");
    }

    public void acceptOffer(int Rideid, Boolean accept,int Offerid) {
        Ride ride=((DataArrays)Data).getRides().get(Rideid);
        Offer offer=ride.getOffers().get(Offerid);
        offer.getDriver().notify( "User " + (accept ? "accepted" : "rejected") + " the offer", ride);
        if (accept) {
            ridesHistory.add(ride);
            ride.setDriver(offer.getDriver());
            ride.setPrice(offer.getPrice());
            clearOffers();
            if (ride.makeTransaction()) {
                firstRide = false;
                ride.eventManager.notify(new AcceptOfferEvent("User accepts the captain price", this), ride);
            }
        }
        else {
            ride.getOffers().remove(offer);
        }
    }
    public ArrayList<Ride> getRidesHistory() {
        return ridesHistory;
    }


    public void clearOffers() {
        ride = null;
    }

    public void notify(String message, Ride ride) {
        this.addNotification(message);
        this.ride = ride;
    }
}