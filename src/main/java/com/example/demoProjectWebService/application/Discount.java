package com.example.demoProjectWebService.application;

public abstract class Discount {

    protected Ride ride;
    private Discount next;

    Discount(Ride ride) {
        this.ride = ride;
    }

    public Discount linkWith(Discount next) {
        this.next = next;
        return next;
    }

    public abstract double discount(double price);

    protected double checkNext(double price) {
        if (next == null)
            return price;
        return next.discount(price);
    }
}
