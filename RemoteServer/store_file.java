import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class store_file {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://172.21.170.10:3306/msc", "msc", "msc");
            if (con != null) {
                System.out.println("connection success");
            }

            PreparedStatement ps = con.prepareStatement("insert into FILETABLE_9 values(?,?)");

            File f = new File("z:\\input\\file49.txt");
            FileReader fr = new FileReader(f);

            ps.setInt(1, 10);
            ps.setCharacterStream(2, fr, (int) f.length());
            int i = ps.executeUpdate();
            System.out.println(i + " records affected");

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}