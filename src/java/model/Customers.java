/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author NLVM
 */
public class Customers {
     public Customers(){
    }
     public boolean checkLogin(String user, String pass) {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/ass";
            Connection con = DriverManager.getConnection(url, "root", "");
             String sql = "select * from customer where Username=? and Password=?";
             PreparedStatement stm = con.prepareStatement(sql);
             stm.setString(1, user);
             stm.setString(2, pass);
             ResultSet rs = stm.executeQuery();
             boolean exist = false;
             exist = rs.next();
             rs.close();stm.close();con.close();
             if(exist){
                 return true;
             }
         }catch(Exception e){
             e.printStackTrace();
         }
        return false;
    } 
   

}
