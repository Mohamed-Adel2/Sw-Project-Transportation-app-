public class Rating {

    private User user;
    private int stars;

    public Rating(User user, int stars) {
        this.user = user;
        stars = Math.min(stars, 5);
        stars = Math.max(stars, 1);
        this.stars = stars;
    }

    public User getUser() {
        return user;
    }

    public int getStars() {
        return stars;
    }

    public void rate(Driver driver) {
        driver.addUserRating(this);
    }
}
