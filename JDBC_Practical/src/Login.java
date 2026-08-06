import java.sql.*;

public class Login {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "CREATE TABLE Login ("
                    + "id INT PRIMARY KEY,"
                    + "username VARCHAR(50),"
                    + "password VARCHAR(50),"
                    + "email VARCHAR(100),"
                    + "Role ENUM('admin','user'))";

            Statement st = con.createStatement();
            st.execute(sql);

            System.out.println("Login Table Created");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}