import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3307/onlinevoting";

    private static final String USER = "root";

    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {

            System.out.println("=== DATABASE CONNECTION TEST ===");
            System.out.println("URL: " + URL);
            System.out.println("User: " + USER);
            System.out.println("Password provided: "
                    + (!PASSWORD.isEmpty()));

            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("MySQL JDBC Driver loaded successfully.");

            // Try connection
            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Database connected successfully!");

            return con;

        } catch (ClassNotFoundException e) {

            System.out.println("ERROR: MySQL JDBC Driver was not found.");
            e.printStackTrace();

        } catch (SQLException e) {

            System.out.println("ERROR: Database connection failed.");
            System.out.println("SQL Error Code: " + e.getErrorCode());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Message: " + e.getMessage());

            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("ERROR: Unexpected error.");
            System.out.println("Message: " + e.getMessage());

            e.printStackTrace();
        }

        return null;
    }
}