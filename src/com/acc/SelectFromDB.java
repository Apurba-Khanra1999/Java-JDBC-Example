package com.acc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DBConnection;

public class SelectFromDB {
    public static void main(String[] args) {
        
        Connection con = null;
        //PreparedStatement pstmt = null;
        Statement pstmt = null;

        

        try{
        con = DBConnection.getDBConnection();
        pstmt = con.createStatement();

        String query = "select * from employee";

        ResultSet rs = pstmt.executeQuery(query);

        System.out.print("ID\t" + "Age\t" + "First\t" + "Last\n");
        System.out.println("--------------------------------");

        while(rs.next()){
            int id= rs.getInt("id");
            int age =rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");

            System.out.print(id);
            System.out.print("\t"+ age);
            System.out.print("\t"+ first);
            System.out.print("\t"+ last);
            System.out.println();


        }
        //System.out.println("--------------------------------");
        rs.close();

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        finally{
            try {
                if(pstmt!=null){
                    pstmt.close();
                }
            } catch (SQLException e) {
                //TODO: handle exception
                e.printStackTrace();
            }

            try {
                if(con!=null){
                    con.close();
                }
            } catch (SQLException e) {
                //TODO: handle exception
                e.printStackTrace();
            }
        }

        System.out.println("\nData retrieved successfully !!!\n");
    }
}
