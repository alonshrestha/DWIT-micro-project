package com.Practice.service;

import com.Practice.database.DBConnection;
import com.Practice.model.Users;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDeleteService {

    public void delete(int id){
        try{
            String sql = "delete from user where id = ?";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            pstm.setInt(1,id);
            pstm.executeQuery();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
