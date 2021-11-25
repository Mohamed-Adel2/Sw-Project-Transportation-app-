
public class RegisterUser implements IRegister {

    @Override
    public boolean register(NewUser user) {

        if (UsersData.getUsernames().contains(user.getUsername()) || DriversData.getUsernames().contains(user.getUsername()))
            return false;

        UsersData.addUser((User) user);
        return true;
    }
}