/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author symsc49
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class UpdateData {
    public static void main (String args[]){
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://172.21.170.10:3306/msc", "msc", "msc");
            if(con!=null){
                System.out.println("Connection Success");

            }

            Statement stmt = con.createStatement();



            // Update Record
            stmt.executeUpdate("UPDATE student SET sname='Lida' WHERE sno=49");
            System.out.println("record updated successfully");

            // Displaye records
            System.out.println("Display the records");
            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next()){
                System.out.println(rs.getInt("sno")+"  "+rs.getString("sname"));
            }

            // Delete record
            System.out.println("Display the records after deletion");
            stmt.executeUpdate("DELETE FROM student WHERE sno=49");
            System.out.println("record deleted successfully");

            ResultSet rsd = stmt.executeQuery("select * from student");
            while (rsd.next()){
                System.out.println(rsd.getInt("sno")+"  "+rsd.getString("sname"));
            }


            con.close();
        } catch(Exception e){
            System.out.println(e);
        }



    }


}
