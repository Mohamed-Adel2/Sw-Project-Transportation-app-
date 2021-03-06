
package com.example.demoProjectWebService.application.view;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import com.example.demoProjectWebService.Data.*;
import com.example.demoProjectWebService.Core.*;
import com.example.demoProjectWebService.application.Persons.*;


public class Main {
    static Scanner sc =new Scanner(System.in);
    // for register
    public static String Enter_username(String username)
    {
        System.out.println("Enter The following Data to register");
        System.out.println("Username: ");
        username = sc.nextLine();
        return username;
    }
    public static String Enter_email(String email)
    {
        System.out.println("Email: ");
        email = sc.nextLine();
        return email;
    }
    public static String Enter_phone(String phone)
    {
        System.out.println("Phone Number: ");
        phone = sc.nextLine();
        return phone;
    }
    public static String Enter_password(String pass)
    {
        System.out.println("Password: ");
        pass=sc.nextLine();
        return pass;
    }

    //-------------------------------------------------------------

    // for login
    public static String Login_username(String username)
    {
        System.out.println("Enter The following data to login" );
        System.out.println("Username: ");
        username =sc.nextLine();
        return username;
    }
    public static String Login_pass(String pass)
    {
        System.out.println(" Password: ");
        pass =sc.nextLine();
        return pass;
    }

    //-------------------------------------------------------------

    public static void main(String[] args) {
        SystemData data=DataArrays.getInstance();
        User u=new Passenger("asd","123","123","123",new Date(2001, Calendar.JANUARY, 1));
        User d=new Driver("qwe","213","123","123","123","123",4);
        User d1=new Driver("zxc","213","123","123","123","123",4);
        data.addPassenger((Passenger) u);
        data.addDriver((Driver)d);
        data.addDriver((Driver)d1);
        Admin a=Admin.getinstance();
        a.verifyDriver(d.getUsername());
        a.verifyDriver(d1.getUsername());
        ((Driver) d).addFavoriteArea("aaa");
        ((Driver) d1).addFavoriteArea("aaa");
        ((Passenger) u).requestRide("aaa","bbb",2);

        boolean chk=true;
        String choice;

        while(chk)
        {
            System.out.println("That's Home Page\n Enter your choice as number 1/2/3/0\n 1-Register\n 2-Login\n 3-Admin\n 0-Exit");
            choice = sc.nextLine();
            // Register
            if(Integer.parseInt(choice)==1)
            {
                System.out.println("Register Page\n Enter your choice as number 1/2/0\n 1-Register as User\n 2-Register as Driver\n 0-Exit");
                choice = sc.nextLine();
                String username="",email="",phone="",password="";

                // as User
                if(Integer.parseInt(choice)==1)
                {
                    boolean unique = true;
                    while(unique)
                    {
                        // Enter Data
                        username = Enter_username(username);
                        email = Enter_email(email);
                        phone = Enter_phone(phone);
                        password = Enter_password(password);

                        // Register User & add in UsersData
                        Passenger new_user =new Passenger(username,email,phone,password,new Date(2001, Calendar.JANUARY, 1));

                        // Check for Username
                        unique = (new_user.register(new_user));
                        if(unique)
                        {
                            System.out.println("Registeration Successfully");
                            unique=false;
                        }
                        else
                        {
                            System.out.println("This Username is already used please Enter Another Username");
                            unique = true;
                        }
                    }

                }

                // as Driver
                else if(Integer.parseInt(choice)==2)
                {
                    String licence, national_id;
                    boolean unique = true;
                    while(unique)
                    {
                        // Enter Data
                        username = Enter_username(username);
                        email = Enter_email(email);
                        phone = Enter_phone(phone);
                        password = Enter_password(password);

                        System.out.println("Your Licence: ");
                        licence = sc.nextLine();
                        System.out.println("National Id: ");
                        national_id=sc.nextLine();

                        // Register Driver & add in DriversData
                        Driver new_driver =new Driver(username,email,phone,password,licence,national_id,4);

                        // Check for Username
                        unique = (new_driver.register(new_driver));
                        if(unique)
                        {
                            System.out.println("Registeration Successfully");
                            unique=false;
                        }
                        else
                        {
                            System.out.println("This Username is already used please Enter Another Username");
                            unique=true;
                        }
                    }
                }
                else
                {
                    chk=false;
                }
            }

            //-------------------------------------------------------------------------------------------------------------------------

            // Login
            else if(Integer.parseInt(choice)==2)
            {
                System.out.println("Login Page\n Enter your choice as number 1/2/0\n 1-Login as User\n 2-Login as Driver\n 0-Exit");
                choice = sc.nextLine();
                String username="",password="";
                // as User
                if(Integer.parseInt(choice)==1)
                {
                    Passenger My_account = new Passenger();
                    boolean correct=true;
                    while(correct)
                    {
                        // to login as User
                        username = Login_username(username);
                        password =Login_pass(password);
                        My_account = new Passenger();
                        My_account=(Passenger)My_account.login(username,password);

                        // check out Username and Password
                        if(My_account==null)
                        {
                            System.out.println("Login Failed! Invalid Username or Password or Suspended Account\n Press 1 To Try again or 0 to Exit");
                            choice=sc.nextLine();
                            if(Integer.parseInt(choice)==0)
                            {
                                correct=false;
                                chk=false;
                            }
                        }
                        else
                        {
                            System.out.println("Login Successfully");
                            correct = false;
                        }
                    }
                    // to Exit
                    if(!chk)
                    {
                        break;
                    }
                    boolean login =true;
                    while(login)
                    {
                        System.out.println("Enter your choice as number 1/2/3/0\n 1-Request ride\n 2-Get all notifications\n 3-Get offers 0-Logout");
                        choice=sc.nextLine();
                        // request ride
                        if(Integer.parseInt(choice)==1)
                        {
                            String src,des,pass;
                            System.out.print("Enter The name of source area: ");
                            src = sc.nextLine();
                            System.out.print("Enter The name of destination area: ");
                            des = sc.nextLine();

                            // request ride and notify all drivers
                            My_account.requestRide(src,des,2);
                        }
                        // print notifications
                        else if(Integer.parseInt(choice)==2)
                        {
                            System.out.println(My_account.getNotifications());
                        }
                        // get offers of my rides and rate driver if user accept the offer check average user rating for the driver
                        /*else if(Integer.parseInt(choice)==3)
                        {
                            Ride offers=My_account.getOffers();
                            Scanner sc = new Scanner(System.in);
                            for(int i=0;i<offers.getOffers().size();i++){
                                System.out.print("Enter 1 if you need check for average user rating of driver or 0 if you do not need: ");
                                String x = sc.nextLine();
                                if(Integer.parseInt(x)==1)
                                {
                                    System.out.println("The average Rating of driver = "+My_account.checkDriverRating(offers.getOffers().get(i).getDriver()));
                                }
                                System.out.println(My_account.chkOffer(offers.getOffers().get(i)));
                                System.out.println("do you want to accept? Yes/No");
                                String s = sc.nextLine();
                                boolean accept=(s.equalsIgnoreCase("yes"));
                                My_account.acceptOffer(offers,accept,offers.getOffers().get(i));
                                if(accept==true)
                                {
                                    System.out.println("Enter Your Rate for Dirver between 1 and 5 : ");
                                    s=sc.nextLine();
                                    int rate=Integer.parseInt(s);
                                    My_account.rateDriver(offers.getOffers().get(i).getDriver(),rate);
                                    break;
                                }
                            }
                            My_account.clearOffers();
                        }
                        else
                        {
                            login=false;
                        }*/
                    }
                }
                // as Driver
                else if(Integer.parseInt(choice)==2)
                {
                    boolean correct=true;
                    Driver My_account = new Driver();
                    while(correct)
                    {
                        // to login as Driver
                        username = Login_username(username);
                        password =Login_pass(password);
                        My_account = new Driver();
                        My_account =(Driver)My_account.login(username,password);

                        // check out Username and Password
                        if(My_account==null)
                        {
                            System.out.println("Login Failed! Invalid Username or Password or Suspended Account\n Press 1 To Try again or 0 to Exit");
                            choice=sc.nextLine();
                            if(Integer.parseInt(choice)==0)
                            {
                                correct=false;
                                chk=false;
                            }
                        }
                        else
                        {
                            System.out.println("Login Successfully");
                            correct = false;
                        }

                    }
                    // to Exit
                    if(!chk)
                    {
                        break;
                    }
                    boolean login=true;
                    while(login)
                    {
                        System.out.println("Enter your choice as number 1/2/3/4/0\n 1-Add Favoriate Area\n 2-List Rides and make offer\n 3-Display all user rating\n 4-Get all notifications\n 0-Logout");
                        choice=sc.nextLine();
                        String ch;
                        Ride My_ride=new Ride();
                        // add favoriate area
                        if(Integer.parseInt(choice)==1)
                        {
                            System.out.print("Enter The name of favoriate area: ");
                            ch = sc.nextLine();
                            My_account.addFavoriteArea(ch);
                        }
                        // List Rides and make offers
                        else if(Integer.parseInt(choice)==2)
                        {
                            ArrayList<Ride> rides = My_account.getRides();
                            for(Ride ride:rides)
                            {
                                System.out.println("Do you want to make offer for ride that has source "+ride.getSource()+" and destination "+ride.getDestination()+" from user "+ride.getUser().getUsername()+" ? yes/no");
                                ch=sc.nextLine();
                                if(ch.equalsIgnoreCase("yes"))
                                {
                                    System.out.print("Enter Your Offer for Ride From: " + ride.getSource() + " to: " + ride.getDestination() + " :");
                                    Scanner sc = new Scanner(System.in);
                                    double price = sc.nextDouble();

                                    System.out.println("Your Offer Was Sent. Waiting for the reply from Client!");
                                    My_ride=ride;
                                    // make offer and notify user
                                    My_account.makeOffer(My_ride,price);
                                }
                            }
                            if(rides.size()==0)
                            {
                                System.out.println("No such any rides available now ");
                            }
                        }
                        // list rating
                        else if(Integer.parseInt(choice)==3)
                        {
                            ArrayList<Rating> rating = My_account.listUserRatings();
                            for(Rating rate:rating)
                            {
                                System.out.println("The User "+rate.getUser().getUsername()+" rate you with "+rate.getStars()+" Star(s)");
                            }
                        }
                        // print notifications
                        else if(Integer.parseInt(choice)==4)
                        {
                            System.out.println(My_account.getNotifications());
                        }
                        else
                        {
                            login=false;
                        }
                    }

                }
                else{
                    chk=false;
                }
            }

            //-------------------------------------------------------------------------------------------------------------------------

            // Admin
            else if(Integer.parseInt(choice)==3){
                Admin admin = Admin.getinstance();
                String ch;
                System.out.println("Enter the access value of admin: ");
                ch = sc.nextLine();
                if(ch.equalsIgnoreCase("admin"))
                {
                    boolean ad=true;
                    while(ad)
                    {
                        // verify this driver by admin
                        System.out.println("Admin Page\n Enter your choice as number 1/2/3/4/0\n 1-Suspend Driver/User  \n 2-verify drivers\n 3-List of all users\n 4-List of all drivers \n 0-Go Home Page");
                        choice = sc.nextLine();
                        if(Integer.parseInt(choice)==1){
                            System.out.println("Enter the username of driver you want suspend him");
                            ch =sc.nextLine();
                            if(!(admin.suspendUser(ch)))
                            {
                                System.out.println("No such driver has this username");
                            }
                            else
                            {
                                System.out.println("Suspended successfully");
                            }
                        }
                        else if(Integer.parseInt(choice)==2)
                        {
                            ArrayList<Driver> pending = admin.listPendingDrivers();
                            for(Driver driver:pending)
                            {
                                System.out.println("The Driver "+driver.getUsername()+" is pending and wait for your verify... yes/no");
                                ch=sc.nextLine();
                                if(ch.equalsIgnoreCase("yes"))
                                {
                                    admin.verifyDriver(driver.getUsername());
                                }
                            }
                        }
                        else if(Integer.parseInt(choice)==3)
                        {
                            ArrayList<Passenger> users = ((DataArrays)data).getPassengers();
                            System.out.println("All Usernames and Suspend Status of Users in application ");
                            for(Passenger user:users)
                            {
                                System.out.println("Username: "+user.getUsername()+" Suspend: "+(user.isSuspended()?"Yes":"No"));
                            }
                            if(users.size()==0)
                                System.out.println("No such any users in application yet!");
                        }
                        else if(Integer.parseInt(choice)==4)
                        {
                            ArrayList<Driver> drivers = ((DataArrays)data).getDrivers();
                            System.out.println("All Usernames and Suspend Status and verification status of Drivers in application");
                            for(Driver driver:drivers)
                            {
                                System.out.println("Username: "+driver.getUsername()+" Suspend: "+(driver.isSuspended()?"Yes":"No")+" Verify: "+(driver.isPending()?"No":"Yes"));
                            }
                            if(drivers.size()==0)
                                System.out.println("No such any drivers in application yet!");
                        }
                        else
                        {
                            ad=false;
                        }
                    }

                }
                else
                {
                    System.out.println("You are not admin Terminate application");
                    chk=false;
                }
            }

            //-------------------------------------------------------------------------------------------------------------------------

            //Exit
            else if(Integer.parseInt(choice)==0)
            {
                chk=false;
            }
            else
            {
                System.out.println("please enter 1 or 2 or 3 or 0");
            }
        }
    }
}