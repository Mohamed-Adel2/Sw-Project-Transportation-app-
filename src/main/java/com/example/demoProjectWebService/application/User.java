package com.example.demoProjectWebService.application;
import java.util.ArrayList;
public class User extends NewUser {
    public Ride offers = new Ride();
    private ArrayList<Ride> ridesHistory = new ArrayList<Ride>();
    private SystemData Data = DataArrays.getInstance();

    public User(String username, String email, String phone, String password) {
        super(username, email, phone, password);
    }

    public User() {
    }

    public boolean register(NewUser user) {
        if (((DataArrays)Data).getUsernames().contains(user.getUsername()))
            return false;
        Data.addUser((User) user);
        return true;
    }

    public NewUser login(String username, String password) {
        ArrayList<User> users = ((DataArrays)Data).getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password) && !users.get(i).isSuspended()) {
                return users.get(i);
            }
        }
        return null;
    }

    public ArrayList<Offer> getOffers() {
        return offers.getOffers();
    }

    public void requestRide(String source, String destination) {
        Ride my_ride = new Ride(source, destination, this);
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
        return ("The driver: " + offers.getOffers().get(offerid).getDriver().getUsername() + " Offers Your Ride with: " + offers.getOffers().get(offerid).getPrice() + " LE.");
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
        }
        else {
            ride.getOffers().remove(offer);
        }
    }

    public void clearOffers() {
        offers = null;
    }

    public void notify(String message, Ride ride) {
        this.addNotification(message);
        offers = ride;
    }
}