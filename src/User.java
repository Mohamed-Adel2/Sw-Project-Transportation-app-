import java.util.ArrayList;

abstract class User implements ILogin, IRegister, INotifier {
    private String username;
    private String email;
    private String phone;
    private String password;
    private ArrayList<String> notifications = new ArrayList<>();
    private boolean suspended;
    private Account account;
    private ILogin iLogin;
    private IRegister iRegister;
    private INotifier iNotifier;
    protected SystemData data = DataArrays.getInstance();

    public User() {}

    public User(String username, String email, String phone, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.suspended = false;
        this.account = new Account();
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

    public Account getAccount() {
        return account;
    }

    public boolean withdraw(double amount) {
        return account.withdraw(amount);
    }

    public boolean canWithdraw(double amount) {
        return account.withdraw(amount);
    }

    public boolean deposit(double amount) {
        return account.deposit(amount);
    }

    public double getBalance() {
        return account.getBalance();
    }

    @Override
    public User login(String username, String Password){
        return iLogin.login(username,password);
    }

    @Override
    public boolean register(User user){
        return iRegister.register(user);
    }

    @Override
    public void notify(User user, String message, Ride ride) {
        iNotifier.notify(user, message, ride);
    }

}
