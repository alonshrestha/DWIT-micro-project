package com.practice.controller;

import com.practice.model.SendMail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        SendMail.send(name,batch,cc,subject, message);
        out.println("Mail send successfully");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
