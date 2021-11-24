import java.util.ArrayList;

public class Admin {

    public void suspendUser(NewUser user) {
        user.setSuspended(true);
    }

    public void verifyDriver(Driver driver) {
        driver.setPending(false);
    }

    public ArrayList<Driver> listPendingDrivers() {
        ArrayList<Driver> drivers = DriversData.getDrivers();
        ArrayList<Driver> pendingDrivers = new ArrayList<>();

        for (Driver driver : drivers)
            if (driver.isPending())
                pendingDrivers.add(driver);
        return pendingDrivers;
    }
}
