package com.practice.service;

import com.practice.database.DBConnection;
import com.practice.model.Users;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserEditService {
boolean isUpdate = false;
    public boolean editUser(Users user){

        try{
            String sql = "update user " + "set name=?,email=?, password=? " +  "where id="+user.getId();
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getEmail());
            pstm.setString(3,user.getPassword());
            pstm.executeUpdate();

            int affectedRow = pstm.executeUpdate();
            if(affectedRow > 0){
                isUpdate = true;
            }else {
                isUpdate = false;
            }
            System.out.println(isUpdate);
        }catch (SQLException e){
            e.printStackTrace();
        }return isUpdate;
    }

}
