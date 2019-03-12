package com.practice.controller;

import com.practice.model.CheckInternet;
import com.practice.model.Host;
import com.practice.service.HostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RootServlet")
public class RootServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("here");

        List<Host> hostSelect = new HostService().selectHost();
        boolean isUrlList = new CheckInternet().httpStatusList(hostSelect);
        if(isUrlList){
            System.out.println("OK!!!");
            request.getRequestDispatcher("jsp/yesInternet.jsp").forward(request,response);
        }else
        {
            System.out.println("NoOK!!");
            request.getRequestDispatcher("jsp/noInternet.jsp").forward(request,response);
        }
    }
}
