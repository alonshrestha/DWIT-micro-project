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

    public int countApp(){
        int num = 0;
        try{
            String sql = "select count(*) as total from host";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                num = rs.getInt("total");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }return num;
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

    boolean isAppCount = false;


    //*---------------------------------------------------------------------------------------------------------------*/

    boolean isServerAdd = false;
    public boolean addServer(Host s){
        try{
            String sql = "insert into serverHost (serverName,serverAddr)" + " values(?,?)";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            System.out.println(s.getServerName() + "aayo ta yaa ta serverName");
            pstm.setString(1,s.getServerName());
            pstm.setString(2,s.getServerAddr());

            int rowAffected = pstm.executeUpdate();
            if(rowAffected > 0){
                isHostAdd = true;
            }else
                isHostAdd = false;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return isServerAdd;
    }

    public List<Host> serverList() {
        List<Host> sList = new ArrayList<>();
        try{
            String sql = "select * from serverHost";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){

                Host s = new Host();
                s.setserverId(rs.getInt("ID"));
                System.out.println("s = " + s.getserverId());
                s.setServerName(rs.getString("serverName"));
                System.out.println("s = " + s.getServerName());
                s.setServerAddr(rs.getString("serverAddr"));
                System.out.println("s = " + s.getServerAddr());
                sList.add(s);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return sList;
    }


    public void deleteserver(int id) {
        String query = "delete from serverHost where id=?";
        try {
            PreparedStatement pstm = new DBConnection().getPreparedStatement(query);
            pstm.setInt(1,id);

            pstm.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    boolean isUpdateServer = false;
    public boolean editServer(Host s){
        System.out.println("edit server samma aaye");
        try{
            String sql = "update serverHost " + "set serverName=?, serverAddr=? " +  "where ID="+s.getserverId();
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            pstm.setString(1,s.getServerName());
            pstm.setString(2,s.getServerAddr());

            int affectedRow = pstm.executeUpdate();
            if(affectedRow > 0){
                isUpdateServer = true;
            }else {
                isUpdateServer = false;
            }
            System.out.println(isUpdateServer);
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(isUpdateServer);
        }return isUpdateServer;
    }


    public List<Host> selectServerAddr(){
        List<Host> serverAddrSelect = new ArrayList<>();
        try{
            String sql = "select serverAddr from host";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){

                Host s = new Host();
                s.setIpAddr(rs.getString("serverAddr"));
                serverAddrSelect.add(s);


            }
        }catch (Exception e){
            e.printStackTrace();

        }
        return serverAddrSelect;

    }




    public static void main(String[] args){

        HostService myobj = new HostService();
        myobj.serverList();

        }
}
