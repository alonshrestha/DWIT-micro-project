package com.Practice.service;
import com.Practice.model.Users;
import com.Practice.database.DBConnection;
import com.Practice.service.UserRegisterService;
import com.mysql.cj.xdevapi.Result;

import javax.jws.soap.SOAPBinding;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserListService {


    public List<Users> listUser() {
        List<Users> usersList = new ArrayList<>();
        try{
            String sql = "select * from user";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){

                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                usersList.add(user);
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return usersList;
    }

    public void delete(int id) {
        String query = "delete from user where id=?";
        try {
            PreparedStatement pstm = new DBConnection().getPreparedStatement(query);
            pstm.setInt(1,id);

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
