import java.sql.*;

public class Createcategory {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "CREATE TABLE Category("
                    + "cid INT PRIMARY KEY,"
                    + "C_name VARCHAR(100))";

            Statement st = con.createStatement();

            st.execute(sql);

            System.out.println("Category Table Created");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}