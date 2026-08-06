import java.sql.*;

public class CreateCatImage {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "CREATE TABLE category_image("
                    + "cimg_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "image LONGBLOB,"
                    + "Cid INT,"
                    + "FOREIGN KEY(Cid) REFERENCES Category(cid))";

            Statement st = con.createStatement();

            st.execute(sql);

            System.out.println("Category Image Table Created");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}