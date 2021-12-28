
import java.util.ArrayList;
import java.util.List;

public class Ride {

    private String source;
    private String destination;
    private User user;
    private Driver driver;
    private Double price;
    private int num_passenger;
    private SystemData Data=DataArrays.getInstance();
    private ArrayList<Offer> offers = new ArrayList<>();

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public Ride() {
    }
    public void add_Offer(Offer o)
    {
        offers.add(o);
    }

    public Ride(String source, String destination, User user, int passenger) {
        this.source = source;
        this.destination = destination;
        this.user = user;
        price = null;
        driver = null;
        num_passenger = passenger;

        ArrayList<Driver> drivers =Data.getDrivers();
        for (Driver driver : drivers) {
            if (driver.getFavoriteAreas().contains(source) && (driver.getCurrent_location().equalsIgnoreCase(source) || driver.getCurrent_location().equalsIgnoreCase("main_area")) && driver.isAvailable()) {
                driver.notify(driver, "There is a ride that has a source area from your favorite areas!", this);
            }
        }
    }
//    public Ride(Ride r){
//        this.source=r.source;
//        this.destination=r.destination;
//        this.user=r.user;
//        this.num_passenger =r.num_passenger;
//        this.offers =r.offers;
//    }

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