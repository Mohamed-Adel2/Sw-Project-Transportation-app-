public class DestinationAreaDiscount extends Discount {

    private SystemData data = DataArrays.getInstance();
    final int DISCOUNT_PERCENTAGE = 10;

    DestinationAreaDiscount(Ride ride) {
        super(ride);
    }

    @Override
    public double discount(double price) {
        if (data.getDiscountAreas().contains(ride.getDestination()))
            price -= (ride.getPrice() * DISCOUNT_PERCENTAGE) / 100;
        return checkNext(price);
    }
}
