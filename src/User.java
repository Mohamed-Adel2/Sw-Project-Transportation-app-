

import java.util.ArrayList;
import java.util.Scanner;

public class User extends NewUser {
    private  ArrayList<Ride> getoffers = new ArrayList<Ride>();
    private ArrayList<Ride> ridesHistory=new ArrayList<Ride>();
    private SystemData Data=DataArrays.getInstance();
    public User(String username, String email, String phone, String password) {
        super(username, email, phone, password);
    }

    public User() {
    }

    public boolean register(NewUser user) {
        if (Data.getUsernames().contains(user.getUsername()))
            return false;
        Data.addUser((User) user);
        return true;
    }

    public NewUser login(String username,String password){
        ArrayList<User> users = Data.getUsers();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password) && !users.get(i).isSuspended()) {
                return users.get(i);
            }
        }
        return null;
    }

    public ArrayList<Ride> getGetoffers() {
        return getoffers;
    }

    public void requestRide(String source, String destination) {
        Ride my_ride = new Ride(source, destination, this);
        Data.addRide(my_ride);
    }

    public void rateDriver(Driver driver, int stars) {
        driver.addUserRating(new Rating(this, stars));
    }

    public double checkDriverRating(Driver driver) {
        return driver.getAvgRating();
    }

    public double chkAvgRating(Driver driver){
        return driver.getAvgRating();
    }

    public String chkOffer(Ride ride){
        return ("The driver: " + ride.getDriver().getUsername() + " Offers Your Ride with: " + ride.getPrice() + " LE.");
    }

    public void acceptOffer(Ride ride,Boolean accept){
        ride.getDriver().notify(ride.getDriver(), "User " + (accept ? "accepted" : "rejected") + " the offer", ride);
        if(accept) {
            ridesHistory.add(ride);
            for(Ride r:Data.getRides()){
                System.out.println(r.getDriver());
            }
            ride.setDriver(null);
            ride.setPrice(null);
            for(Ride r:Data.getRides()){
                System.out.println(r.getDriver());
            }
            Data.removeRide(ride);
        }
    }

    public void clearOffers(){
        getoffers.clear();
    }

    public void notify(User user, String message, Ride ride) {
        user.addNotification(message);
        user.getoffers.add(ride);
    }

    /*public void acceptOffer() {
        for(Ride ride: getoffers)
        {
            Scanner sc = new Scanner(System.in);
            //check average rating
            System.out.print("Enter 1 if you need check for average user rating of driver or 0 if you do not need: ");
            String x = sc.nextLine();
            if(Integer.parseInt(x)==1)
            {
                System.out.println("The average Rating of driver = "+ride.getUser().checkDriverRating(ride.getDriver()));
            }
            System.out.println("The driver: " + ride.getDriver().getUsername() + " Offers Your Ride with: " + ride.getPrice() + " LE. do you want to accept? Yes/No");
            String s = sc.nextLine();
            while (!(s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("no"))) {
                System.out.println("Wrong Choice! Please Enter Yes Or No");
                s = sc.nextLine();
            }
            boolean accept = s.equalsIgnoreCase("yes");
            ride.getDriver().notify(ride.getDriver(), "User " + (accept ? "accepted" : "rejected") + " the offer", ride);
            if(accept) {
                // rate driver and add this in rating list
                String stars;
                System.out.print("Enter stars for the driver: ");
                stars = sc.nextLine();
                this.rateDriver(ride.getDriver(), Integer.parseInt(stars));
                ride.setDriver(null);
                ride.setPrice(null);
                Data.removeRide(ride);
                break;
            }
        }
        getoffers.clear();
    }*/
}