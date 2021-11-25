

import java.util.ArrayList;

public class RidesData {

    private static ArrayList<Ride> rides = new ArrayList<>();

    public static void addRide(Ride ride) {
        rides.add(ride);
    }

    public static void removeRide(Ride ride) {
        for(Ride r : rides){
            if((r.getDestination().equalsIgnoreCase(ride.getDestination()))&&(r.getSource().equalsIgnoreCase(ride.getSource()))&&(r.getUser()==ride.getUser()))
            {
                rides.remove(r);
                break;
            }

        }
    }

    public static ArrayList<Ride> getRides() {
        return rides;
    }
}