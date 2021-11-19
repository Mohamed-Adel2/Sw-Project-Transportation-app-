import java.util.ArrayList;
import java.util.Scanner;

public class Driver extends NewUser {
    private String licence,NationalId;
    private ArrayList<String>FavAreas=new ArrayList<String>();
    private double avgRating;
    private ArrayList<Ride> rides=new ArrayList<Ride>();
    private ArrayList<Rating>ratings=new ArrayList<Rating>();

    public void setLicence(String licence) {
        this.licence = licence;
    }


    public void setNationalId(String nationalId) {
        NationalId = nationalId;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public void setFavAreas(ArrayList<String> favAreas) {
        FavAreas = favAreas;
    }

    public void setRides(ArrayList<Ride> rides) {
        this.rides = rides;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public String getLicence() {
        return licence;
    }

    public String getNationalId() {
        return NationalId;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public ArrayList<String> getFavAreas() {
        return FavAreas;
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public void AddFavArea(String s){
        FavAreas.add(s);
    }

    public void MakeOffer(Ride r){
        System.out.print("Enter Your Offer for Ride From: "+r.getSource()+" to: "+r.getDestination() +" :");
        Scanner sc=new Scanner(System.in);
        double price=sc.nextDouble();
        System.out.println("Your Offer Was Sent. Wating the reply from Client!");
        r.setPrice(price);
    }

}
