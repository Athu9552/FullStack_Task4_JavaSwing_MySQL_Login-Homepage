import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Homepage extends JFrame {
    private JLabel lblGreeting;
    private JButton logoutButton;

    public Homepage(String fullname) {
        setTitle("Homepage");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10,10));

        JLabel lblTitle = new JLabel("Welcome to the Homepage", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitle, BorderLayout.NORTH);

        lblGreeting = new JLabel("Hello, " + fullname + "!", SwingConstants.CENTER);
        add(lblGreeting, BorderLayout.CENTER);

        JPanel btnPanel = new JPanel();
        logoutButton = new JButton("Logout");
        btnPanel.add(logoutButton);
        add(btnPanel, BorderLayout.SOUTH);

        // Logout action
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginForm().setVisible(true);
                dispose();
            }
        });
    }
}