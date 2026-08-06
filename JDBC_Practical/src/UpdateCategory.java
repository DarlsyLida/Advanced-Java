import java.sql.*;
import java.util.Scanner;

public class UpdateCategory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Category ID : ");
            int cid = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter New Category Name : ");
            String name = sc.nextLine();

            Statement st = con.createStatement();

            String sql = "UPDATE Category SET C_name='" + name + "' WHERE cid=" + cid;

            int i = st.executeUpdate(sql);

            System.out.println(i + " Record Updated");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}