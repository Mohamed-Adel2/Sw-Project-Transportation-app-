package com.example.demoProjectWebService.application;
import java.util.ArrayList;
import java.util.List;
public class Ride {

    private String source;
    private String destination;
    private User user;
    private Driver driver;
    private Double price;
    private SystemData Data=DataArrays.getInstance();
    private ArrayList<Offer> offers = new ArrayList<>();
    public int Rid;
    static int RideID=0;
    static int OfferID=0;
    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public Ride() {
    }
    public void add_Offer(Offer o)
    {
        o.ID=OfferID;
        OfferID++;
        offers.add(o);
    }

    public Ride(String source, String destination, User user) {
        this.source = source;
        this.destination = destination;
        this.user = user;
        price = null;
        driver = null;

        ArrayList<Driver> drivers =((DataArrays)Data).getDrivers();
        for (Driver driver : drivers) {
            if (driver.getFavoriteAreas().contains(source)) {
                driver.notify( "There is a ride that has a source area from your favorite areas!", this);
            }
        }
        Rid=RideID;
        RideID++;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public User getUser() {
        return user;
    }

    public Double getPrice() {
        return price;
    }

    public Driver getDriver() {
        return driver;
    }
}