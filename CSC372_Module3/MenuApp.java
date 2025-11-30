import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import javax.swing.*;

public class MenuApp extends JFrame {

    private JTextArea textArea;
    private Color randomGreenColor = null;
    private String randomGreenHex = null;
    private JMenuItem randomGreenMenuItem;

    public MenuApp() {
        setTitle("Menu Example Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        // Text area in the center 
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        //  Menu bar at the top
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        JMenuItem dateTimeItem = new JMenuItem("1. Show Date & Time");
        JMenuItem saveToFileItem = new JMenuItem("2. Save Text to log.txt");
        randomGreenMenuItem = new JMenuItem("3. Random Green Background");
        JMenuItem exitItem = new JMenuItem("4. Exit");

        menu.add(dateTimeItem);
        menu.add(saveToFileItem);
        menu.add(randomGreenMenuItem);
        menu.add(exitItem);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Add Listeners

        // 1) Print date/time into the text box
        dateTimeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter formatter =
                        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String now = LocalDateTime.now().format(formatter);
                textArea.append("Current date/time: " + now + "\n");
            }
        });

        // 2) Write text box contents to log.txt
        saveToFileItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = textArea.getText();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
                    writer.write(content);
                    writer.newLine();
                    JOptionPane.showMessageDialog(
                            MenuApp.this,
                            "Text saved to log.txt",
                            "Saved",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(
                            MenuApp.this,
                            "Error writing to file: " + ex.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });

        // 3) Change background to a random green hue
        randomGreenMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (randomGreenColor == null) {
                    // Generate a random green hue using HSB
                    Random rand = new Random();
                    float hue = 0.25f + rand.nextFloat() * 0.2f; // roughly green range
                    float saturation = 0.8f;
                    float brightness = 0.9f;
                    randomGreenColor = Color.getHSBColor(hue, saturation, brightness);

                    randomGreenHex = String.format(
                            "#%02X%02X%02X",
                            randomGreenColor.getRed(),
                            randomGreenColor.getGreen(),
                            randomGreenColor.getBlue()
                    );

                    // Update menu text to show the chosen hue for this run
                    randomGreenMenuItem.setText("3. Random Green Background (" + randomGreenHex + ")");
                }

                // Apply the same random green color each time in this execution
                getContentPane().setBackground(randomGreenColor);
            }
        });

        // 4) Exit the program
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuApp());
    }
}