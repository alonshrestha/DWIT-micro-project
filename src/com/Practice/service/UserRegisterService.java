package com.Practice.service;
import com.Practice.model.Users;
import com.Practice.database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegisterService {

    boolean isInserted = false;
    public boolean addUser(Users user){

        String sql = "insert into user (name,email,password)" + " values(?,?,?)";
        try {

            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getEmail());
            pstm.setString(3,user.getPassword());
            pstm.executeUpdate();

            int affectedRow = pstm.executeUpdate(); //row ma changes aayo ki nai ?? check gareko
            if(affectedRow > 0){
                isInserted = true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return isInserted;
    }
}
