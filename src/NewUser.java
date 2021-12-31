

import java.util.ArrayList;

public abstract class NewUser implements IServices {
    private String username;
    private String email;
    private String phone;
    private String password;
    private ArrayList<String> notifications = new ArrayList<>();
    private boolean suspended;

    public NewUser(String username, String email, String phone, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.suspended = false;
    }

    public NewUser() {
    }

    public abstract NewUser login(String username, String Password);
    public abstract boolean register(NewUser user);
    public abstract void notify(String message, Ride ride);

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
}