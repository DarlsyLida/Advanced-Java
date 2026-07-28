import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insert_image {
    public static void main(String[] args) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://172.21.170.10:3306/msc", "msc", "msc");
            if (con != null) {
                System.out.println("connection success");
            } else {
                System.out.println("fail");
            }

            PreparedStatement ps = con.prepareStatement("insert into imagetable49 values(?,?)");
            ps.setString(1, "flower");

            FileInputStream fin = new FileInputStream("Z:\\images.jpg");
            ps.setBinaryStream(2, fin, fin.available());
            int i = ps.executeUpdate();
            System.out.println(i + " records affected");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}