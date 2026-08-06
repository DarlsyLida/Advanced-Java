import java.sql.*;
import java.util.Scanner;

public class CRUDOrders {

    static Connection con = DBConnection.getConnection();
    static Scanner sc = new Scanner(System.in);

    // Insert Record
    public static void insertOrder() {

        try {

            System.out.print("Enter Order ID : ");
            int oid = sc.nextInt();

            System.out.print("Enter Order Date (YYYY-MM-DD): ");
            String date = sc.next();

            System.out.print("Enter Amount : ");
            double amount = sc.nextDouble();

            System.out.print("Enter Login ID : ");
            int id = sc.nextInt();

            System.out.print("Enter Status : ");
            String status = sc.next();

            Statement st = con.createStatement();

            String sql = "INSERT INTO Orders VALUES("
                    + oid + ",'"
                    + date + "',"
                    + amount + ","
                    + id + ",'"
                    + status + "')";

            st.executeUpdate(sql);

            System.out.println("Order Inserted Successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // View Records
    public static void viewOrders() {

        try {

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Orders");

            System.out.println("\n--------------------------------------------");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("oid") + " | "
                                + rs.getDate("odate") + " | "
                                + rs.getDouble("Amount") + " | "
                                + rs.getInt("id") + " | "
                                + rs.getString("Status"));

            }

            System.out.println("--------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update Status
    public static void updateOrder() {

        try {

            System.out.print("Enter Order ID : ");
            int oid = sc.nextInt();

            System.out.print("Enter New Status : ");
            String status = sc.next();

            Statement st = con.createStatement();

            String sql = "UPDATE Orders SET Status='"
                    + status + "' WHERE oid=" + oid;

            int i = st.executeUpdate(sql);

            System.out.println(i + " Record Updated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Record
    public static void deleteOrder() {

        try {

            System.out.print("Enter Order ID : ");
            int oid = sc.nextInt();

            Statement st = con.createStatement();

            String sql = "DELETE FROM Orders WHERE oid=" + oid;

            int i = st.executeUpdate(sql);

            System.out.println(i + " Record Deleted.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main Menu
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== Orders CRUD =====");
            System.out.println("1. Insert Order");
            System.out.println("2. View Orders");
            System.out.println("3. Update Order");
            System.out.println("4. Delete Order");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    insertOrder();
                    break;

                case 2:
                    viewOrders();
                    break;

                case 3:
                    updateOrder();
                    break;

                case 4:
                    deleteOrder();
                    break;

                case 5:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}