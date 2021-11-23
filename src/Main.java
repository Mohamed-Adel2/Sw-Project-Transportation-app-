import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Driver driver1 = new Driver("name", "emmail", "123", "pass", "driving", "nID");

        driver1.addFavoriteArea("source");

        Driver driver2 = new Driver("name2", "emmail", "123", "pass", "driving", "nID");

        driver2.addFavoriteArea("source");

        Admin admin = new Admin();
        admin.verifyDriver(driver1);

        RegisterDriver registerDriver = new RegisterDriver();
        LoginDriver loginDriver = new LoginDriver();
        boolean b = registerDriver.register(driver1);
        if (!b)
            System.out.println("not found");
        else
            System.out.println("found");

        b = registerDriver.register(driver2);
        if (!b)
            System.out.println("not found");
        else
            System.out.println("found");

        Driver d1 = (Driver) loginDriver.login("name", "pass");

        User user = new User("username", "mail", "456", "UserPass");

        System.out.println(UsersData.getUsers());

        user.requestRide("source", "dest");

        ArrayList<Driver> drivers = DriversData.getDrivers();

        for (Driver driver : drivers) {
            ArrayList<Ride> rides = driver.getRides();
            for (Ride ride : rides){
                driver.makeOffer(ride);
                System.out.println(driver.getNotifications());
            }
            System.out.println(driver.getRides().size());
        }

    }
}