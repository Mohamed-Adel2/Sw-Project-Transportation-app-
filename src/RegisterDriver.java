

public class RegisterDriver implements IRegister {

    @Override
    public boolean register(NewUser user) {

        if (UsersData.getUsernames().contains(user.getUsername()) || DriversData.getUsernames().contains(user.getUsername()))
            return false;

        DriversData.addDriver((Driver) user);
        return true;
    }
}