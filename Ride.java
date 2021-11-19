package com.company;

public class Ride {
    private String source,destination;
    private User user;
    private Double price;
    private Driver driver;
    public Ride(String src,String dest){
        source=src;
        destination=dest;
        price=null;
        driver=null;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public User getUser() {
        return user;
    }

    public Double getPrice() {
        return price;
    }

    public Driver getDriver() {
        return driver;
    }
}
