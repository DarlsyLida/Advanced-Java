import java.sql.*;
import java.util.Scanner;

public class DeleteSubCategory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Category ID : ");

            int cid = sc.nextInt();

            Statement st = con.createStatement();

            st.executeUpdate("DELETE FROM SubCategory WHERE Cid=" + cid);

            System.out.println("Deleted");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}