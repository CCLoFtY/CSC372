public class BankAccount {

    // Fields
    private String firstName;
    private String lastName;
    private int accountID;
    private double balance;

    // Constructor
    public BankAccount(String firstName, String lastName, int accountID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = 0.0;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
        else System.out.println("Deposit amount must be positive.");
    }

    // Withdrawal
    public void withdrawal(double amount) {
        if (amount > 0) balance -= amount;
        else System.out.println("Withdrawal amount must be positive.");
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    // Getter to return the balance
    public double getBalance() {
        return balance;
    }

    // Prints all account information
    public void accountSummary() {
        System.out.println("=======Account Summary=======");
        System.out.println("Account Holder: " + firstName + " " + lastName);
        System.out.println("Account ID: " + accountID);
        System.out.printf("Balance: $%.2f%n", balance);
    }
}
