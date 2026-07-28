import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class retrieve_file {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://172.21.170.10:3306/msc", "msc", "msc");
            if (con != null) {
                System.out.println("connection success");
            } else {
                System.out.println("fail");
            }

            PreparedStatement ps = con.prepareStatement("select * from filetable_9");
            ResultSet rs = ps.executeQuery();
            rs.next(); // now on 1st row

            Clob c = rs.getClob(2);
            Reader r = c.getCharacterStream();

            FileWriter fw = new FileWriter("z:\\output\\mark1.txt");

            int i;
            while ((i = r.read()) != -1) {
                fw.write((char) i);
            }

            fw.close();
            con.close();

            System.out.println("success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}