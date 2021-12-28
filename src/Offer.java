public class Offer {
    private Driver driver;
    private double price;

    public Offer(Driver driver, double price) {
        this.driver = driver;
        this.price = price;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getPrice() {
        return price;
    }
}
