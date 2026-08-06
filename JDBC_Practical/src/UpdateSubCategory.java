import java.sql.*;
import java.util.Scanner;

public class UpdateSubCategory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Category ID : ");

            int cid = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter New Name : ");

            String name = sc.nextLine();

            Statement st = con.createStatement();

            String sql = "UPDATE SubCategory SET Sc_name='" + name + "' WHERE Cid=" + cid;

            st.executeUpdate(sql);

            System.out.println("Updated");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}