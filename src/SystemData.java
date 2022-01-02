import java.util.ArrayList;
import java.util.Set;

public interface SystemData {
    void addPassenger(Passenger passenger);
    ArrayList<Passenger> getPassengers();
    void addDriver(Driver driver);
    ArrayList<Driver> getDrivers();
    Set<String> getUsernames();
    void addRide(Ride ride);
    void addPendingRide(Ride ride);
    ArrayList<Ride> getRides();
    ArrayList<Ride> getPendingRides();
    void removeRide(Ride ride);
    void addDiscountArea(String area);
    ArrayList<String> getDiscountAreas();
}