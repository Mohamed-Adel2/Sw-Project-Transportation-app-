import java.util.ArrayList;

public class DriversData {

    private static ArrayList<Driver> drivers = new ArrayList<>();

    public static void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public static ArrayList<Driver> getDrivers() {
        return drivers;
    }
}
