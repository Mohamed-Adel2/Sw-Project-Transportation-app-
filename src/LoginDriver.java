
import java.util.ArrayList;

public class LoginDriver implements ILogin {
    public NewUser login(String username, String password) {

        ArrayList<Driver> drivers = DriversData.getDrivers();

        for (int i = 0; i < drivers.size(); i++) {
            if (drivers.get(i).getUsername().equals(username) && drivers.get(i).getPassword().equals(password)
                    && !drivers.get(i).isSuspended() && !drivers.get(i).isPending()) {
                return drivers.get(i);
            }
        }
        return null;
    }
}