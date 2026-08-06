import java.sql.*;

public class CreateSub {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "CREATE TABLE SubCategory("
                    + "subid INT PRIMARY KEY,"
                    + "Sc_name VARCHAR(100),"
                    + "Price DOUBLE,"
                    + "Description VARCHAR(200),"
                    + "Cid INT,"
                    + "FOREIGN KEY(Cid) REFERENCES Category(cid))";

            Statement st = con.createStatement();

            st.execute(sql);

            System.out.println("SubCategory Created");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}