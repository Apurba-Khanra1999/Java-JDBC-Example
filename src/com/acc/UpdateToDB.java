package com.acc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.util.DBConnection;

public class UpdateToDB {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        // Main switch case ------------------
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Update Id ");
        System.out.println("2. Update Age");
        System.out.println("3. Update First name and Last name : ");
        System.out.println();
        System.out.print("\n Enter your choice : ");
        int choice = sc.nextInt();
        switch(choice){

        case 1:{    // Update new ID


        int oldId,newId;
        //Scanner sc = new Scanner(System.in);
        System.out.println("Enter the OLD ID to be UPDATED : ");
        oldId = sc.nextInt();
        System.out.println("\n Enter the NEW ID : ");
        newId = sc.nextInt();


        try{
            con = DBConnection.getDBConnection();
            pstmt = con.prepareStatement("update employee set id = "+newId+" where id = "+oldId);
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

            System.out.println("Data Updated Successfully . . . \n");
            break;
        }

        case 2:{   // Update age

            int default_id;
            System.out.print("\n Enter id whose age you want to change :  ");
            default_id = sc.nextInt();

            System.out.print("\n Enter new age : ");
            int new_age = sc.nextInt();

            try{
                con = DBConnection.getDBConnection();
                pstmt = con.prepareStatement("update employee set age = "+new_age+" where id = "+default_id);
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
    
                System.out.println("Data Updated Successfully . . . \n");
                break;
        }
        case 3:{ // Update the first name and last name ...............

            int default_id;
            String new_first_name,new_last_name;
            System.out.print("\n Enter id whose age you want to change :  ");
            default_id = sc.nextInt();

            System.out.print("\n Enter new First name : ");
            new_first_name = sc.next();
            System.out.print("\n Enter the last name : ");
            new_last_name = sc.next();


            try{
                con = DBConnection.getDBConnection();
                pstmt = con.prepareStatement("update employee set first = "+"'"+new_first_name+"'"+", last = "+"'"+new_last_name+"'" +"where id = "+default_id);
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
    
                System.out.println("Data Updated Successfully . . . \n");
                break;
        }


    }
    }



}
