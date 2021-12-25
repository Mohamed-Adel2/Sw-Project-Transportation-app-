import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DataArrays implements SystemData{

    private static ArrayList<User> users = new ArrayList<>();
    private static ArrayList<Driver> drivers = new ArrayList<>();
    private static Set<String> systemUsersname = new HashSet<>();
    private static ArrayList<Ride> rides = new ArrayList<>();
    private static DataArrays Data;

    private DataArrays(){}

    public static DataArrays getInstance(){
        if(Data==null)Data=new DataArrays();
        return Data;
    }

    public void addUser(User user) {
        users.add(user);
        systemUsersname.add(user.getUsername());
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public Set<String> getUsernames() {
        return systemUsersname;
    }

    @Override
    public void addDriver(Driver driver) {
        drivers.add(driver);
        systemUsersname.add(driver.getUsername());
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public void removeRide(Ride ride) {
        for(Ride r : rides){
            if((r.getDestination().equalsIgnoreCase(ride.getDestination()))&&(r.getSource().equalsIgnoreCase(ride.getSource()))&&(r.getUser()==ride.getUser()))
            {
                rides.remove(r);
                break;
            }

        }
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }
}
