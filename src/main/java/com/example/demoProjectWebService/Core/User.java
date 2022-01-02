package com.example.demoProjectWebService.Core;
import com.example.demoProjectWebService.application.Service.*;
import com.example.demoProjectWebService.Data.*;
import java.util.ArrayList;

public abstract class User implements IServices {
    private String username;
    private String email;
    private String phone;
    private String password;
    private ArrayList<String> notifications = new ArrayList<>();
    private boolean suspended;
    private double balance;
    protected SystemData Data = DataArrays.getInstance();

    public User(String username, String email, String phone, String password) {
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.suspended = false;
    }

    public User() {
    }

    public abstract User login(String username, String Password);
    public abstract boolean register(User user);
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

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance)
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount < 0)
            return false;
        balance += amount;
        return true;
    }

    public ArrayList<String> getNotifications() {
        return notifications;
    }

    public boolean canWithdraw(double amount) {
        return withdraw(amount);
    }
}