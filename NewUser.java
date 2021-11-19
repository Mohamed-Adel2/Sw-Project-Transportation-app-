import java.util.ArrayList;

abstract class NewUser {
    String UserName,Email,Phone,Password;
    ArrayList<String> Notification;
    boolean Suspended;


    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setSuspended(boolean suspended) {
        Suspended = suspended;
    }

    public String getUserName() {
        return UserName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public String getPassword() {
        return Password;
    }

    public boolean isSuspended() {
        return Suspended;
    }

}
