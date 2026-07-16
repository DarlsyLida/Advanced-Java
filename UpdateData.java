/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advancedjava;

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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
            if(con!=null){
                System.out.println("Connection Success");                
                
            }

            Statement stmt = con.createStatement();
            

            
            // Update Record
            stmt.executeUpdate("UPDATE student SET sname='Lida' WHERE sno=5");
            System.out.println("record updated successfully");
            
            // Displaye records
            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next()){
                System.out.println(rs.getInt("sno")+"  "+rs.getString("sname"));
            }
            
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }
    
    
}
