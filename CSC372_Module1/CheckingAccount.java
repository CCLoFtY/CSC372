public class CheckingAccount extends BankAccount {

    // Interest rate attribute
    private double interestRate;

    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void processWithdrawal(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        // Use superclass withdrawal logic to subtract the amount
        withdrawal(amount);

        if (getBalance() < 0) {
            // Apply $30 overdraft fee
            withdrawal(30.0);
            System.out.printf(
                "Overdraft! A $30 fee has been assessed. New balance: $%.2f%n",
                getBalance()
            );
        } else {
            System.out.printf(
                "Withdrawal processed. New balance: $%.2f%n",
                getBalance()
            );
        }
    }

    public void displayAccount() {
        accountSummary();
        System.out.printf("Interest Rate: %.2f%%%n", interestRate * 100);
        System.out.println("==================");
    }
}
