package com.acc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConnection;

public class InsertToDB {
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pstmt = null;

        int i=0;
        int id ,age;
        String first,last;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("\n Enter id : ");
        id = sc.nextInt();

        System.out.print("\n Enter age : ");
        age = sc.nextInt();

        System.out.print("\n Enter First name : ");
        first = sc.next();

        System.out.print("\n Enter last name : ");
        last = sc.next();
        

        try{
        con = DBConnection.getDBConnection();
        pstmt = con.prepareStatement("insert into employee values(?,?,?,?)");
        pstmt.setInt(1, id);
        pstmt.setInt(2, age);
        pstmt.setString(3, first);
        pstmt.setString(4, last);
        pstmt.executeUpdate();

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

        System.out.println("Data inserted successfully !!! \n");
    }
}
