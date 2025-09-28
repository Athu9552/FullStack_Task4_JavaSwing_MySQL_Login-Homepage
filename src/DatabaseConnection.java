import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/task4db?useSSL=false&serverTimezone=UTC";
private static final String USER = "root";
private static final String PASSWORD = ""; // empty for XAMPP default

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL JDBC driver
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL database!");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
        return connection;
    }

    public static void main(String[] args) {
        getConnection(); // test
    }
}