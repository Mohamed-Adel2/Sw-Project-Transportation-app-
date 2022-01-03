package com.example.demoProjectWebService.application.Persons;
import java.util.ArrayList;
import com.example.demoProjectWebService.Data.*;
import com.example.demoProjectWebService.Core.*;
import com.example.demoProjectWebService.application.Service.*;

public class Admin implements EventListener{

    private static Admin admin;
    private SystemData Data=DataArrays.getInstance();
    private Admin() {}

    public static Admin getinstance(){
        if(admin==null)admin=new Admin();
        return admin;
    }

    public boolean suspendUser(String username) {
        ArrayList<Passenger> users = ((DataArrays)Data).getPassengers();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equalsIgnoreCase(username)) {
                ((DataArrays)Data).getPassengers().get(i).setSuspended(true);
                return true;
            }
        }
        ArrayList<Driver> Drivers = ((DataArrays)Data).getDrivers();

        for (int i = 0; i < Drivers.size(); i++) {
            if (Drivers.get(i).getUsername().equalsIgnoreCase(username)) {
                ((DataArrays)Data).getDrivers().get(i).setSuspended(true);
                return true;
            }
        }
        return false;
    }

    public boolean verifyDriver(String username) {
        ArrayList<Driver> Drivers = ((DataArrays)Data).getDrivers();
        for (int i = 0; i < Drivers.size(); i++) {
            if (Drivers.get(i).getUsername().equalsIgnoreCase(username)) {
                ((DataArrays)Data).getDrivers().get(i).setPending(false);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Driver> listPendingDrivers() {
        ArrayList<Driver> drivers = ((DataArrays)Data).getDrivers();
        ArrayList<Driver> pendingDrivers = new ArrayList<>();

        for (Driver driver : drivers)
            if (driver.isPending())
                pendingDrivers.add(driver);
        return pendingDrivers;
    }

    public boolean addDiscountArea(String area) {
        return Data.addDiscountArea(area);
    }

    public ArrayList<String> showRideEvents(int Rideid) {
        ArrayList<String> events=new ArrayList<String>();
        ArrayList<Event> tmp=((DataArrays)Data).getRides().get(Rideid).getEvents();
        for(int i=0;i<tmp.size();i++){
            events.add(tmp.get(i).toString());
        }
        return events;
    }
    @Override
    public void update(Event event, Ride ride) {
        ride.addEvent(event);
    }
}
