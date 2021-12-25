import java.util.ArrayList;
import java.util.Set;

public interface SystemData {
    void addUser(User user);
    ArrayList<User> getUsers();
    Set<String> getUsernames();
    void addDriver(Driver driver);
    ArrayList<Driver> getDrivers();
    void addRide(Ride ride);
    void removeRide(Ride ride);
    ArrayList<Ride> getRides();
}
