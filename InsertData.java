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

public class InsertData {
    public static void main (String args[]){
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
            if(con!=null){
                System.out.println("Connection Success");                
                
            }

            Statement stmt = con.createStatement();
            
//            Insert record
                    
            String q1 = "insert into student(sno, sname) values(5, 'Darlsy')";
            stmt.executeUpdate(q1);            
            System.out.println("record inserted successfully");
            
           
            con.close();
        } catch(Exception e){
            System.out.println(e);
        }
        
        
        
    }
    
    
}
