import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DriversData {

    private static ArrayList<Driver> drivers = new ArrayList<>();
    private static Set<String> driversUsernames = new HashSet<>();

    public static void addDriver(Driver driver) {
        drivers.add(driver);
        driversUsernames.add(driver.getUsername());
    }

    public static ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public static Set<String> getUsernames() {
        return driversUsernames;
    }
}
