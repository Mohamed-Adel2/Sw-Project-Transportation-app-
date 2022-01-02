public class MultiplePassengersDiscount extends Discount {

    final int DISCOUNT_PERCENTAGE = 5;

    MultiplePassengersDiscount(Ride ride) {
        super(ride);
    }

    @Override
    public double discount(double price) {
        if ( (ride.getNumberOfPassengers() > 1) || (ride.getDriver().getPassengers().size() > 1)) {
            //System.out.println("sayed");
            price -= (ride.getPrice() * DISCOUNT_PERCENTAGE) / 100;
        }
        return checkNext(price);
    }
}
