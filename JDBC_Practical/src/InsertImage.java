import java.io.FileInputStream;
import java.sql.*;

public class InsertImage {

    public static void main(String[] args) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO category_image(image,Cid) VALUES(?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            FileInputStream fis = new FileInputStream("Z:\\piz.jpg");

            ps.setBinaryStream(1, fis, fis.available());

            ps.setInt(2, 1);

            ps.executeUpdate();

            System.out.println("Image Inserted");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}