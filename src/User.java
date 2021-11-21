import java.util.ArrayList;
import java.util.Scanner;

public class User extends NewUser {

    public User(String username, String email, String phone, String password) {
        super(username, email, phone, password);

    }

    public void requestRide(String source, String destination) {
        RidesData.addRide(new Ride(source, destination, this));
    }

    public void rateDriver(Driver driver, int stars) {
        driver.addUserRating(new Rating(this, stars));
    }

    public double checkDriverRating(Driver driver) {
        return driver.getAvgRating();
    }

    public void acceptOffer(Ride ride) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The driver: " + ride.getDriver().getUsername() + " Offers Your Ride with: " + ride.getPrice() + " LE. do you want to accept? Yes/No");
        String s = sc.nextLine();
        while (!(s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("no"))) {
            System.out.println("Wrong Choice! Please Enter Yes Or No");
            s = sc.nextLine();
        }
        boolean accept = s.equalsIgnoreCase("yes");
        ride.getDriver().notify(ride.getDriver(), "User " + (accept ? "accepted" : "rejected") + " the offer", ride);
        if (accept)
            RidesData.removeRide(ride);
        else
            ride.setDriver(null);
    }

    public void notify(User user, String message, Ride ride) {
        user.addNotification(message);
        acceptOffer(ride);
    }
}
