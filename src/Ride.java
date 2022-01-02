import java.util.ArrayList;

public class Ride {

    private String source;
    private String destination;
    private ArrayList<Passenger> passengers = new ArrayList<>();
    private Passenger passenger;
    private Driver driver;
    private Double price;
    private double priceAfterDiscount;
    private int numberOfPassengers;
    private ArrayList<Offer> offers = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();
    public EventManager eventManager;
    private SystemData data = DataArrays.getInstance();

    public Ride() {}

    public Ride(String source, String destination, Passenger passenger, int numberOfPassengers) {
        this.source = source;
        this.destination = destination;
        this.passenger = passenger;
        this.price = null;
        this.driver = null;
        this.numberOfPassengers = numberOfPassengers;
        this.eventManager = new EventManager();
        this.eventManager.subscribe(Admin.getInstance());

        ArrayList<Driver> drivers = data.getDrivers();
        ArrayList<Ride> rides = data.getPendingRides();
        for (Driver driver : drivers) {
            if ( driver.canTakeRide(this))
                driver.notify(driver, "There is a ride that has a source area from your favorite areas!", this);
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

    public void setPrice(Double price) {
        this.price = price;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
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

    public Passenger getPassenger() {
        return passenger;
    }

    public Double getPrice() {
        return price;
    }

    public double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void calculatePriceAfterDiscount(Ride ride) {
        Discount discount = new FirstRideDiscount(ride);
        discount.linkWith(new DestinationAreaDiscount(ride)).
                linkWith(new MultiplePassengersDiscount(ride)).
                linkWith(new PublicHolidayDiscount(ride)).
                linkWith(new BirthdateDiscount(ride)).
                linkWith(null);
        priceAfterDiscount = discount.discount(price);
    }

    public Driver getDriver() {
        return driver;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void addOffer(Offer offer) {
        offers.add(offer);
    }

    public ArrayList<Offer> getOffers() {
        return offers;
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

}