import java.sql.*;
import java.util.Scanner;

public class DeleteCategory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Category ID : ");

            int cid = sc.nextInt();

            Statement st = con.createStatement();

            String sql = "DELETE FROM Category WHERE cid=" + cid;

            int i = st.executeUpdate(sql);

            System.out.println(i + " Record Deleted");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}