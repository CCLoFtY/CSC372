public class BankTest {
    public static void main(String[] args) {

        // Create a checking account
        CheckingAccount ca = new CheckingAccount("Cayden", "Cobb", 12345, 0.02);    
        // Initial account summary
        System.out.println("Initial account state:");
        ca.displayAccount();    
        // Test deposit
        System.out.println("Depositing $200...");
        ca.deposit(200.0);
        ca.displayAccount();    
        // Test normal withdrawal
        System.out.println("Withdrawing $50 (no overdraft)...");
        ca.processWithdrawal(50.0);
        ca.displayAccount();    
        // Test overdraft + fee
        System.out.println("Withdrawing $300 (this should cause overdraft and fee)...");
        ca.processWithdrawal(300.0);
        ca.displayAccount();    
        // Another test case with different account
        CheckingAccount ca2 = new CheckingAccount("Alex", "Smith", 98765, 0.015);
        ca2.deposit(100.0);
        System.out.println("Second account test:");
        ca2.displayAccount();
        ca2.processWithdrawal(120.0); // overdraft scenario
        ca2.displayAccount();
    }
}
