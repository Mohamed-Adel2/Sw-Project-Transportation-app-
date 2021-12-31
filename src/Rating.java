public class Rating {

    private Passenger user;
    private int stars;

    public Rating(Passenger user, int stars) {
        this.user = user;
        stars = Math.min(stars, 5);
        stars = Math.max(stars, 1);
        this.stars = stars;
    }

    public Passenger getUser() {
        return user;
    }

    public int getStars() {
        return stars;
    }
}