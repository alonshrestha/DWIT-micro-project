package com.practice.service;

import com.practice.database.DBConnection;
import com.practice.model.CheckInternet;
import com.practice.model.Host;
import com.practice.model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HostService {

    boolean isHostAdd = false;
    public boolean addHost(Host h){
        try{
            String sql = "insert into host (appName,ipAddr,url)" + " values(?,?,?)";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            System.out.println(h.getAppName() + "aayo ta yaa ta");
            pstm.setString(1,h.getAppName());
            pstm.setString(2,h.getIpAddr());
            pstm.setString(3,h.getUrl());

            int rowAffected = pstm.executeUpdate();
            if(rowAffected > 0){
                isHostAdd = true;
            }else
                isHostAdd = false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isHostAdd;
    }


    public List<Host> listHost() {
        List<Host> hostList = new ArrayList<>();
        try{
            String sql = "select * from host";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){

                Host h = new Host();
                h.setId(rs.getInt("id"));
                h.setAppName(rs.getString("appName"));
                h.setIpAddr(rs.getString("ipAddr"));
                h.setUrl(rs.getString("url"));
                hostList.add(h);
            }
        }catch (SQLException e){
            e.printStackTrace();

        }
        return hostList;
    }

    public void deleteHost(int id) {
        String query = "delete from host where id=?";
        try {
            PreparedStatement pstm = new DBConnection().getPreparedStatement(query);
            pstm.setInt(1,id);

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean isUpdateHost = false;
    public boolean editHost(Host h){
        System.out.println("edit host samma aaye");
        try{
            String sql = "update host " + "set appName=?, ipAddr=?, url=? " +  "where id="+h.getId();
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            pstm.setString(1,h.getAppName());
            pstm.setString(2,h.getIpAddr());
            pstm.setString(3,h.getUrl());

            int affectedRow = pstm.executeUpdate();
            if(affectedRow > 0){
                isUpdateHost = true;
            }else {
                isUpdateHost = false;
            }
            System.out.println(isUpdateHost);
        }catch (SQLException e){
            e.printStackTrace();
        }return isUpdateHost;
    }

    public List<Host> selectUrl(){
        List<Host> urlSelect = new ArrayList<>();
        try{
            String sql = "select url from host";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){

                Host h = new Host();
                h.setUrl(rs.getString("url"));
                urlSelect.add(h);


            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return urlSelect;

    }


    public List<Host> selectIPAddr(){
        List<Host> ipAddrSelect = new ArrayList<>();
        try{
            String sql = "select ipAddr from host";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){

                Host h = new Host();
                h.setIpAddr(rs.getString("ipAddr"));
                ipAddrSelect.add(h);


            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return ipAddrSelect;

    }

        public static void main(String[] args){

        }
}
