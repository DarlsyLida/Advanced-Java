import java.sql.*;

public class InsertCategory {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            String sql = "INSERT INTO Category VALUES(2,'Maize')";

            st.executeUpdate(sql);

            System.out.println("Record Inserted");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}