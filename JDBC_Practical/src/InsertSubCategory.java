import java.sql.*;

public class InsertSubCategory {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            String sql = "INSERT INTO SubCategory VALUES(1,'Cheese Pizza',250,'Extra Cheese',1)";

            st.executeUpdate(sql);

            System.out.println("Inserted");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}