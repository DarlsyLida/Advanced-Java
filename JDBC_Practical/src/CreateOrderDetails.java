import java.sql.*;

public class CreateOrderDetails {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "CREATE TABLE Order_Detail("
                    + "Od_id INT PRIMARY KEY,"
                    + "Oid INT,"
                    + "subid INT,"
                    + "Qty INT,"
                    + "price DOUBLE,"
                    + "FOREIGN KEY(Oid) REFERENCES Orders(oid),"
                    + "FOREIGN KEY(subid) REFERENCES SubCategory(subid))";

            Statement st = con.createStatement();

            st.execute(sql);

            System.out.println("Order Detail Table Created");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}