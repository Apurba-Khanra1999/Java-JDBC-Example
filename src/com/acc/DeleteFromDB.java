package com.acc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConnection;

public class DeleteFromDB {
    public static void main(String[] args) {
        
        Connection con = null;
        PreparedStatement pstmt = null;

        int id;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n Enter the ID to be DELETED : ");
        id = sc.nextInt();

        try{
            con = DBConnection.getDBConnection();
            pstmt = con.prepareStatement("delete from employee where id=" + id);
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

            System.out.println("Data deleted Successfully . . . \n");
    }
    
}
