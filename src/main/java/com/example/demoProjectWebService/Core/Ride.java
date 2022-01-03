package com.example.demoProjectWebService.Core;
import java.util.ArrayList;
import com.example.demoProjectWebService.Data.*;
import com.example.demoProjectWebService.application.Persons.*;
import com.example.demoProjectWebService.application.Service.*;

public class Ride {

    private String source;
    private String destination;
    private Passenger passenger;
    private Driver driver;
    private Double price;
    private double priceAfterDiscount;
    private int numberOfPassengers;
    private SystemData Data=DataArrays.getInstance();
    private ArrayList<Offer> offers = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();
    public EventManager eventManager;
    public int Rid;
    static int RideID=0;
    static int OfferID=0;
    public boolean status=true;

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public Ride() {
    }

    public Ride(Double price,Ride r){
        this.price = price;
        this.source = r.getSource();
        this.destination = r.getDestination();
        this.passenger = r.getPassenger();
        this.driver = null;
        this.numberOfPassengers = r.getNumberOfPassengers();
    }

    public void add_Offer(Offer o)
    {
        o.ID=OfferID;
        OfferID++;
        offers.add(o);
    }

    public Ride(String source, String destination, Passenger user, int numberOfPassengers) {
        this.source = source;
        this.destination = destination;
        this.passenger = user;
        this.price = null;
        this.driver = null;
        this.numberOfPassengers = numberOfPassengers;
        this.eventManager = new EventManager();
        this.eventManager.subscribe(Admin.getinstance());

        Rid=RideID;
        RideID++;

        ArrayList<Driver> drivers = ((DataArrays)Data).getDrivers();
        for (Driver driver : drivers) {
            if (driver.canTakeRide(this))
                driver.notify( "There is a ride that has a source area from your favorite areas!", this);
        }

    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Passenger getPassenger() {
        return passenger;
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

    public Passenger getUser() {
        return passenger;
    }

    public Double getPrice() {
        return price;
    }

    public double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void calculatePriceAfterDiscount() {
        Discount discount = new FirstRideDiscount(this);
        discount.linkWith(new DestinationAreaDiscount(this)).
                linkWith(new MultiplePassengersDiscount(this)).
                linkWith(new PublicHolidayDiscount(this)).
                linkWith(new BirthdateDiscount(this)).
                linkWith(null);
        priceAfterDiscount = discount.discount(price);
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public boolean makeTransaction() {
        //calculatePriceAfterDiscount();
        return driver.deposit(getPrice()) && passenger.canWithdraw(getPrice());
    }

    public Driver getDriver() {
        return driver;
    }

    public void setOffers(ArrayList<Offer> offers) {
        this.offers = offers;
    }
}