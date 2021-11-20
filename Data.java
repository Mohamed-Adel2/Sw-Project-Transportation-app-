import java.util.*;
public class Data {
    private ArrayList<User>users=new ArrayList<User>();
    private ArrayList<Driver>drivers=new ArrayList<Driver>();
    private ArrayList<Ride>rides=new ArrayList<Ride>();
    //private ArrayList<Register>requests=new ArrayList<Register>(); // ** To be implement later **

    public void set_Users(User user){
       users.add(user); 
    }
    public void set_Drivers(Driver driver){
        drivers.add(driver); 
    }
    public void set_Rides(Ride ride){
        rides.add(ride); 
    }
    public ArrayList<User> get_Users(){
        return users;
    }
    public ArrayList<Driver> get_Drivers(){
        return drivers;
    }
    public ArrayList<Ride> get_Rides(){
        return rides;
    }

}
