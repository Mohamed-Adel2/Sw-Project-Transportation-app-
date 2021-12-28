
import java.util.ArrayList;

public class Admin {

    private static Admin admin;
    private SystemData Data=DataArrays.getInstance();
    private Admin() {}

    public static Admin getinstance(){
        if(admin==null)admin=new Admin();
        return admin;
    }

    public boolean suspendUser(String username) {
        ArrayList<User> users = Data.getUsers();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        ArrayList<Driver> Drivers = Data.getDrivers();

        for (int i = 0; i < Drivers.size(); i++) {
            if (Drivers.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public void verifyDriver(Driver driver) {
        driver.setPending(false);
    }

    public ArrayList<Driver> listPendingDrivers() {
        ArrayList<Driver> drivers = Data.getDrivers();
        ArrayList<Driver> pendingDrivers = new ArrayList<>();

        for (Driver driver : drivers)
            if (driver.isPending())
                pendingDrivers.add(driver);
        return pendingDrivers;
    }

    public void addDiscountArea(String area)
    {
        Data.addDiscount_area(area);
    }
}