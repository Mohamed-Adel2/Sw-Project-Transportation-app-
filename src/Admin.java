import java.util.ArrayList;

public class Admin {

    private static Admin admin;
    private SystemData data = DataArrays.getInstance();

    private Admin() {}

    public static Admin getInstance() {
        if (admin == null)
            admin = new Admin();
        return admin;
    }

    public boolean suspendUser(String username) {
        ArrayList<Passenger> passengers = data.getPassengers();

        for (Passenger passenger : passengers) {
            if (passenger.getUsername().equals(username)) {
                return true;
            }
        }
        ArrayList<Driver> drivers = data.getDrivers();

        for (Driver driver : drivers) {
            if (driver.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void verifyDriver(Driver driver) {
        driver.setPending(false);
    }

    public ArrayList<Driver> listPendingDrivers() {
        ArrayList<Driver> drivers = data.getDrivers();
        ArrayList<Driver> pendingDrivers = new ArrayList<>();

        for (Driver driver : drivers)
            if (driver.isPending())
                pendingDrivers.add(driver);
        return pendingDrivers;
    }

    public void addDiscountArea(String area) {
        data.addDiscountArea(area);
    }

    public ArrayList<Event> showRideEvents(Ride ride) {
        return ride.getEvents();
    }
}