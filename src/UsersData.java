

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UsersData {

    private static ArrayList<User> users = new ArrayList<>();
    private static Set<String> usersUsernames = new HashSet<>();

    public static void addUser(User user) {
        users.add(user);
        usersUsernames.add(user.getUsername());
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static Set<String> getUsernames() {
        return usersUsernames;
    }
}