package com.practice.controller;

import com.practice.model.Reports;
import com.practice.model.SendMail;
import com.practice.service.ReportService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "SendMailServlet")
public class SendMailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String batch = request.getParameter("batch");
        String cc = request.getParameter("cc");
        String subject = request.getParameter("subject");
        String message =  request.getParameter("message");


        Reports r = new Reports();
        r.setReportName(name);
        r.setReportBatch(batch);
        r.setReportEmail(cc);
        r.setReportSubject(subject);
        r.setReportMessage(message);



        boolean sendMail = new SendMail().send(name,batch,cc,subject, message);
        if(sendMail) {
            request.setAttribute("alertMsg", "Message Send to IT-Department");
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }


        boolean insertReport = new ReportService().insertReport(r);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
