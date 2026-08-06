import java.sql.*;

public class ViewCategory {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM Category");

            while (rs.next()) {

                System.out.println(rs.getInt(1) + " "
                        + rs.getString(2));

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}