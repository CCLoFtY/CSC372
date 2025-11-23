import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalanceApp {

    private JFrame frame;
    private JPanel panel;
    private JTextField startingBalanceField;
    private JTextField amountField;
    private JLabel balanceLabel;

    private BankAccount account; // holds the user's account

    public BankBalanceApp() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Bank Balance Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 250);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2, 5, 5)); // JPanel requirement

        // Row 1: starting balance
        JLabel startingBalanceLabel = new JLabel("Starting Balance:");
        startingBalanceField = new JTextField(10);

        // Row 2: button to set balance + balance display
        JButton setBalanceButton = new JButton("Set Balance"); // JButton requirement
        balanceLabel = new JLabel("Current Balance: $0.00");

        // Row 3: amount for deposit/withdraw
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);

        // Row 4: deposit & withdraw buttons
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");

        // Row 5: exit button
        JButton exitButton = new JButton("Exit");

        // Add components to panel
        panel.add(startingBalanceLabel);
        panel.add(startingBalanceField);

        panel.add(setBalanceButton);
        panel.add(balanceLabel);

        panel.add(amountLabel);
        panel.add(amountField);

        panel.add(depositButton);
        panel.add(withdrawButton);

        panel.add(new JLabel()); // empty cell for spacing
        panel.add(exitButton);

        // Add panel to frame
        frame.add(panel);

        // ActionListeners (requirement)

        // Set starting balance / create account
        setBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double startingBalance = Double.parseDouble(startingBalanceField.getText());
                    account = new BankAccount(startingBalance);
                    updateBalanceLabel();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for starting balance.");
                }
            }
        });

        // Deposit
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ensureAccountExists()) {
                    try {
                        double amount = Double.parseDouble(amountField.getText());
                        account.deposit(amount);
                        updateBalanceLabel();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid number for amount.");
                    }
                }
            }
        });

        // Withdraw
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ensureAccountExists()) {
                    try {
                        double amount = Double.parseDouble(amountField.getText());
                        account.withdraw(amount);
                        updateBalanceLabel();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Please enter a valid number for amount.");
                    }
                }
            }
        });

        // Exit – show remaining balance before exiting
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double finalBalance = (account != null) ? account.getBalance() : 0.0;
                JOptionPane.showMessageDialog(
                        frame,
                        String.format("Final account balance: $%.2f", finalBalance)
                );
                System.exit(0);
            }
        });

        frame.setLocationRelativeTo(null); // center window
        frame.setVisible(true);
    }

    private boolean ensureAccountExists() {
        if (account == null) {
            JOptionPane.showMessageDialog(frame, "Please set a starting balance first.");
            return false;
        }
        return true;
    }

    private void updateBalanceLabel() {
        if (account != null) {
            balanceLabel.setText(String.format("Current Balance: $%.2f", account.getBalance()));
        }
    }

    public static void main(String[] args) {
        // Run GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankBalanceApp();
            }
        });
    }
}