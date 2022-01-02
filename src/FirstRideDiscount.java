public class FirstRideDiscount extends Discount {

    final int DISCOUNT_PERCENTAGE = 10;

    FirstRideDiscount(Ride ride) {
        super(ride);
    }

    @Override
    public double discount(double price) {
        if (ride.getPassenger().isFirstRide()) {
            price -= (ride.getPrice() * DISCOUNT_PERCENTAGE) / 100;
            //System.out.println("sayed");
        }
        return checkNext(price);
    }
}
