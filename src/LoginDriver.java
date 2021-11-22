import java.util.ArrayList;

public class LoginDriver implements ILogin {
    public Driver login(String username, String password) {

        ArrayList<Driver> drivers = DriversData.getDrivers();

        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getUsername().equals(username) && drivers.get(i).getPassword().equals(password)
                    && !drivers.get(i).isSuspended() && !drivers.get(i).isPending()) {
                return drivers.get(i);
            }
        }
        return null;
    }

    @Override
    public NewUser login(String username) {

        ArrayList<Driver> Drivers = DriversData.getDrivers();

        for (int i = 0; i < Drivers.size(); i++) {
            if (Drivers.get(i).getUsername().equals(username)) {
                return Drivers.get(i);
            }
        }
        return null;
    }
}
