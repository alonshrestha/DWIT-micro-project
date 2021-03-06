package com.practice.service;
import com.practice.model.Users;
import com.practice.database.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserLoginService {

    boolean isUserExist = false;

    public boolean login(Users user){
        try{

            String sql = "select email and password from user where email = ? and password = ?";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            pstm.setString(1,user.getEmail());
            pstm.setString(2,user.getPassword());
            ResultSet rs = pstm.executeQuery();

            if (rs.next()){
                isUserExist =true;
            }else
                isUserExist =false;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return isUserExist;
    }

}
