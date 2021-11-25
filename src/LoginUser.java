

import java.util.ArrayList;

public class LoginUser implements ILogin {

    public NewUser login(String username, String password) {

        ArrayList<User> users = UsersData.getUsers();

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password) && !users.get(i).isSuspended()) {
                return users.get(i);
            }
        }
        return null;
    }

}
