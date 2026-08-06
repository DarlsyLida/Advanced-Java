import java.sql.*;

public class CreateOrders {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "CREATE TABLE Orders("
                    + "oid INT PRIMARY KEY,"
                    + "odate DATE,"
                    + "Amount DOUBLE,"
                    + "id INT,"
                    + "Status VARCHAR(30),"
                    + "FOREIGN KEY(id) REFERENCES Login(id))";

            Statement st = con.createStatement();

            st.execute(sql);

            System.out.println("Orders Table Created");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}