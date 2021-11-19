package com.company;

import java.util.Scanner;

public class User extends NewUser {

    public void RequestRide(String src,String Dest){
        new Ride(src,Dest);
    }
    public void RateDriver(Driver d,int stars){
        //d.ratings.add(stars);
    }
    public double chkDriverRating(Driver d){
        return d.getAvgRating();
    }
    public boolean AcceptOffer(Ride r){
        Scanner sc=new Scanner(System.in);
        System.out.println("The driver: "+r.getDriver().getUserName()+" Offers Your Ride with: "+r.getPrice()+" LE. do you want to accept? Yes/No");
        String s= sc.nextLine();
        while(!(s.equalsIgnoreCase("yes")||s.equalsIgnoreCase("no"))) {
            System.out.println("Wrong Choice! Please Enter Yes Or No");
            s = sc.nextLine();
        }
        if(s.equalsIgnoreCase("yes"))return true;
        return false;
    }
}
