package com.practice.service;
import java.sql.*;

import com.practice.database.DBConnection;
import com.practice.model.Host;
import com.practice.model.Reports;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReportService {

    boolean isReportInserted = false;
    public boolean insertReport(Reports r){
     try{
         String sql = "insert into reports (Date,name,batch,email,subject,messages)" + " values(?,?,?,?,?,?)";
         PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);


         java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
         pstm.setTimestamp(1, date);
         pstm.setString(2,r.getReportName());
         pstm.setString(3,r.getReportBatch());
         pstm.setString(4,r.getReportEmail());
         pstm.setString(5,r.getReportSubject());
         pstm.setString(6,r.getReportMessage());

         System.out.println(date);
         int rowAffected = pstm.executeUpdate();
         if(rowAffected > 0){
             isReportInserted = true;
         }else{
             isReportInserted = false;
         }

     }catch (SQLException e){
         e.printStackTrace();
     }
     return isReportInserted;
    }

    public List<Reports> selectReport() {
        List<Reports> report = new ArrayList<>();
        try{
            String sql = "select * from reports";
            PreparedStatement pstm = new DBConnection().getPreparedStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){

                Reports r = new Reports();
                r.setDate(rs.getTimestamp("Date"));
                System.out.println("r.getDate() = r = " + r.getDate());
                r.setReportName(rs.getString("name"));
                System.out.println("r.getReportName() = " + r.getReportName());
                r.setReportBatch(rs.getString("batch"));
                System.out.println("r.setReportBatch(); = " + r.getReportBatch());
                r.setReportEmail(rs.getString("email"));
                System.out.println("r.getReportEmail() = " + r.getReportEmail());
                r.setReportSubject(rs.getString("subject"));
                System.out.println("r.getReportSubject() = " + r.getReportSubject());
                r.setReportMessage(rs.getString("messages"));
                System.out.println("r.getReportMessage() = " + r.getReportMessage());

                report.add(r);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return report;
    }

}
