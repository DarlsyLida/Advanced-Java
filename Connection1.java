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
import javax.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connection1 {
    public static void main (String args[]){
        try{
//            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "");
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
