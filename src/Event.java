import java.sql.Time;
import java.time.LocalTime;

public class Event {

    private String name;
    private Time time;
    private Driver driver;
    private Passenger passenger;

    public Event(String name, Driver driver, Passenger passenger) {
        this.name = name;
        this.time = Time.valueOf(LocalTime.now());
        this.driver = driver;
        this.passenger = passenger;
    }

    public String getName() {
        return name;
    }

    public Time getTime() {
        return time;
    }

    public Driver getDriver() {
        return driver;
    }

    public Passenger getPassenger() {
        return passenger;
    }


    @Override
    public String toString() {
        return "Event: " + this.name + "\n"
                + "Time: " + this.time + "\n"
                + "Driver: " + this.driver.getUsername() + "\n"
                + "Passenger: " + this.passenger.getUsername() + "\n";
    }
}