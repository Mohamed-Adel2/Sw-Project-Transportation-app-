import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DataArrays implements SystemData {

    private static ArrayList<Passenger> passengers = new ArrayList<>();
    private static ArrayList<Driver> drivers = new ArrayList<>();
    private static Set<String> systemUsernames = new HashSet<>();
    private static ArrayList<Ride> rides = new ArrayList<>();
    private static ArrayList<Ride> pendingRides = new ArrayList<>();
    private static ArrayList<String> discountAreas = new ArrayList<>();
    private static DataArrays data;

    private DataArrays() {
    }

    public static DataArrays getInstance() {
        if (data == null)
            data = new DataArrays();
        return data;
    }

    @Override
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
        systemUsernames.add(passenger.getUsername());
    }

    @Override
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    @Override
    public void addDriver(Driver driver) {
        drivers.add(driver);
        systemUsernames.add(driver.getUsername());
    }

    @Override
    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    @Override
    public Set<String> getUsernames() {
        return systemUsernames;
    }

    @Override
    public void addRide(Ride ride) {
        rides.add(ride);
    }

    @Override
    public void addPendingRide(Ride ride) {
        pendingRides.add(ride);
    }

    @Override
    public void removeRide(Ride ride) {
        pendingRides.remove(ride);
    }

    @Override
    public ArrayList<Ride> getRides() {
        return rides;
    }

    @Override
    public ArrayList<Ride> getPendingRides() {
        return pendingRides;
    }

    @Override
    public void addDiscountArea(String area) {
        discountAreas.add(area);
    }

    @Override
    public ArrayList<String> getDiscountAreas() {
        return discountAreas;
    }
}