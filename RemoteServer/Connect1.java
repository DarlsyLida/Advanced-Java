import javax.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class Connect1 {
    public static void main(String[] args) {
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://172.21.170.10:3306/msc", "msc", "msc");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
            if(con!=null){
                System.out.println("Connection Success");

            }

            else{
                System.out.println("Fail");
            }
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
