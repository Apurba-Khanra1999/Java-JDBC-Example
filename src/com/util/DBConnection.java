package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    public static Connection getDBConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/hexadb?useSSL=false";
            String user_name = "root";
            String user_password = "Password123";

            con = DriverManager.getConnection(url,user_name,user_password);
            return con;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return con;
        
    }
}
