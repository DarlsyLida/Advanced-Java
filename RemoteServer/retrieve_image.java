import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class retrieve_image {
    public static void main(String[] args) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://172.21.170.10:3306/msc", "msc", "msc");
            if (con != null) {
                System.out.println("connection success");
            } else {
                System.out.println("fail");
            }

            PreparedStatement ps = con.prepareStatement("select * from imagetable49");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) { // now on 1st row

                Blob b = rs.getBlob(2); // 2 means 2nd column data
                byte barr[] = b.getBytes(1, (int) b.length()); // 1 means first image

                FileOutputStream fout = new FileOutputStream("Z:\\output\\r1.jpg");
                fout.write(barr);

                fout.close();
            } // end of if
            System.out.println("ok");

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}