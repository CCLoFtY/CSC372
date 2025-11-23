public class BankAccount {

    private double balance;

    // Constructor: starts with a given balance
    public BankAccount(double startingBalance) {
        this.balance = startingBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            balance -= amount; // allow negative if you want overdraft
        }
    }

    public double getBalance() {
        return balance;
    }
}