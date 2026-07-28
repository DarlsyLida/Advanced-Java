import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class P_stmt {
    public static void main(String args[]) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://172.21.170.10:3306/msc", "msc", "msc");

            if (con != null) {
                System.out.println("connection success");
            } else {
                System.out.println("fail");
            }

            PreparedStatement stmt = con.prepareStatement("insert into student values(?,?)");
            stmt.setInt(1, 49); // 1 specifies the first parameter in the query
            stmt.setString(2, "Darl");

            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");

            ResultSet rs = stmt.executeQuery("select *from student");
            while (rs.next()) {
                System.out.println(rs.getInt("sno") + " " + rs.getString("sname"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}