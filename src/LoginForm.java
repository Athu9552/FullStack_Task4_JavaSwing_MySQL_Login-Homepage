import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginForm extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginForm() {
        setTitle("Login Form");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTitle = new JLabel("Login", SwingConstants.CENTER);
        lblTitle.setBounds(120, 10, 100, 30);
        add(lblTitle);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(30, 50, 80, 25);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(120, 50, 150, 25);
        add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(30, 90, 80, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(120, 90, 150, 25);
        add(txtPassword);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 130, 100, 30);
        add(btnLogin);

        // Attach action listener
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginAction();
            }
        });
    }

    private void loginAction() {
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword());

        System.out.println("Login clicked: " + username + " / " + password); // debug

        String sql = "SELECT fullname FROM users WHERE username=? AND password=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString("fullname");
                new Homepage(fullname).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "DB error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}