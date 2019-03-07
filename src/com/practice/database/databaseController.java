package com.practice.database;

import java.sql.*;
import java.util.Scanner;

public class databaseController {
    DBConnection connection;

    public databaseController() {
        connection = new DBConnection();
    }

    int select;
    String iname, dname, password ;

    public void insert() {
        try {

            System.out.println("INSERT");
            System.out.print("Enter UserName : ");
            Scanner input1 = new Scanner(System.in);
            iname = input1.nextLine();
            System.out.print("Enter Password : ");
            Scanner input2 = new Scanner(System.in);
            password = input2.nextLine();
//{Andy Tiimmson = cry for you}
            String query = "insert into users(name,password)" + " values(?,?)";

            PreparedStatement pstm = connection.getPreparedStatement(query);
//            pstm.setInt(1,id);
            pstm.setString(1, iname);
            pstm.setString(2, password);
            pstm.execute();

            System.out.println("Done!!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Chireena");
        } finally {
            System.out.println("try ni vayoo catch ni vayo!!!");
        }
    }

    public void delete() {
        System.out.println("DELETE");
        System.out.println("Enter Username : ");
        Scanner input1 = new Scanner(System.in);
        dname = input1.nextLine();

        String query = "delete from users where name = ?";
        try {
            PreparedStatement pstm = connection.getPreparedStatement(query);
            pstm.setString(1, dname);
            pstm.execute();
            System.out.println("Deleted Successfully!!!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("No Such Name");
        }
    }

    public void Selction(){
        databaseController selectObj = new databaseController();
        System.out.print("Enter 1 for Inserting & 2 for Deletation : ");
        Scanner input = new Scanner(System.in);
        select = input.nextInt();

        switch (select){
            case 1:
                selectObj.insert();
                break;
            case 2:
                selectObj.delete();
                break;
             default:
                 System.out.println("Invalid Input!!");
                 break;
        }
    }
        public static void main (String[] args){
            databaseController connObj = new databaseController();
            connObj.Selction();
        }
    }
