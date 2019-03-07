package com.practice.service;

import com.practice.database.DBConnection;
import com.practice.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserCheckService {

    boolean isUserSame =false;

    public boolean CheckUserSame(Users user){
        try{
             String sql = "select email from user where email = ?";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            pstm.setString(1,user.getEmail());
            ResultSet rs = pstm.executeQuery();
                    if(rs.next()){
                        isUserSame =true;
                        System.out.println("User Already Exist");
                    }else {
                        isUserSame = false;
                        System.out.println("User is Valid");
                    }
        }catch (SQLException e){
            e.printStackTrace();
        }
            return isUserSame;
    }
}
