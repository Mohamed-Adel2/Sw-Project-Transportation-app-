

public class CalculateAvgRating {

    public static double calcAvgRating(Driver driver) {
        double sum = 0;
        for (int i = 0; i < driver.listUserRatings().size(); i++) {
            sum += driver.listUserRatings().get(i).getStars();
        }
        return sum / driver.listUserRatings().size();
    }
}