import java.util.ArrayList;

public class RidesData {

    private static ArrayList<Ride> rides = new ArrayList<>();

    public static void addRide(Ride ride) {
        rides.add(ride);
    }

    public static void removeRide(Ride ride) {
        rides.remove(ride);
    }

    public static ArrayList<Ride> getRides() {
        return rides;
    }
}
