import java.util.ArrayList;

abstract class NewUser implements IRegister, ILogin, INotifier {
    private String username;
    private String email;
    private String phone;
    private String password;
    private ArrayList<String> notifications = new ArrayList<>();
    private boolean suspended;
    private IRegister iRegister;
    private ILogin iLogin;
    private INotifier notifier;

    public NewUser(String username, String email, String phone, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.suspended = false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    public void addNotification(String message) {
        notifications.add(message);
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSuspended() {
        return suspended;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }

    @Override
    public void register(NewUser user) {
        iRegister.register(user);
    }

    @Override
    public boolean login(NewUser user) {
        return iLogin.login(user);
    }

    @Override
    public void notify(NewUser user, String message, Ride ride) {
        notifier.notify(user, message, ride);
    }
}