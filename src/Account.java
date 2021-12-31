public class Account {
    private double balance;

    Account() {
        this.balance = 0;
    }

    double getBalance() {
        return balance;
    }

    boolean withdraw(double amount) {
        if (amount <= balance)
        {
            balance -= amount;
            return true;
        }
        return false;
    }

    boolean deposit(double amount) {
        if (amount < 0)
            return false;
        balance += amount;
        return true;
    }
}
